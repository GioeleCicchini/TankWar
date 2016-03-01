package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.ICreatorCustomLabel;
import Client.UI.JavaFX.CustomWidget.ActionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.UIUtils.LabelsMaker;
import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.ICatalogo;
import Shared.Domain.Player;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;

public class CreareStrategia implements Initializable{

    public Pane DropPaneTarget;
    public Label labelFeedback;
    public VBox condizioniCreatorVBox;
    public VBox azioniCreatorVBox;
    public VBox strategiaVBox;

    private String ultimaCondizione;
    private boolean prossimaCondAnnidata = false;


    public void targetDragOver(DragEvent event) {
        System.out.println("onDragOver");

        if (event.getGestureSource() != DropPaneTarget && event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    public void targetDragEntered(DragEvent event) {
        System.out.println("onDragEntered");

        if (event.getGestureSource() != DropPaneTarget && event.getDragboard().hasString()) {

            DropPaneTarget.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

        }

        event.consume();
    }

    public void targetDragDropped(DragEvent event) {
        System.out.println("onDragDropped");

        Dragboard db = event.getDragboard();
        boolean success = false;

        System.out.println("Ho appena droppato qualcosa");

        System.out.println("Il nome della classe dell'oggetto draggato è " + event.getGestureSource().getClass().toString());

        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel")){ //TODO è bruttissimo
            System.out.println("Hey abbiamo un creator di condizione");
            //TODO mettere qua il fatto che si scrive il pezzo nella strategia
            ConditionCreatorLabel labelDragged =(ConditionCreatorLabel) event.getGestureSource();
            strategiaVBox.getChildren().add(labelDragged);

            String idTypeCond = labelDragged.getIdType();
            List<Integer> valori = new ArrayList<Integer>();
            if (!prossimaCondAnnidata){
                System.out.println("Cond non Annidata!");
                ultimaCondizione= CreareStrategiaHandler.getSingletonInstance().scegliCondizione(idTypeCond,true,valori);
            }
            else {
                System.out.println("Cond Annidata");
                ultimaCondizione=CreareStrategiaHandler.getSingletonInstance().scegliCondizioneAnnidata(idTypeCond,ultimaCondizione,true,valori);
            }
            prossimaCondAnnidata=true;//La prossima si anniderà a questa


        }
        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ActionCreatorLabel") ){ //TODO è bruttissimo
            System.out.println("Hey abbiamo un creator di azione");
            //TODO Mettere un feedback nella grafica
            ActionCreatorLabel labelDragged =(ActionCreatorLabel) event.getGestureSource();
            strategiaVBox.getChildren().add(labelDragged);
            
            String idTypeAz = labelDragged.getIdType();
            List<Integer> valori = new ArrayList<>();
            if (ultimaCondizione != null){
                System.out.println("Sto appendendo l'azione ad una condizione già inserita");
                CreareStrategiaHandler.getSingletonInstance().associaAzione(idTypeAz,ultimaCondizione,valori);
                prossimaCondAnnidata = false;
            }
        }
        System.out.println("Mammeta");

        success = true;

        event.setDropCompleted(success);

        event.consume();
        System.out.println("Ultima condizione: " + ultimaCondizione);
    }

    public void condDragDone(DragEvent event) {
        System.out.println("onDragDone");

        event.consume();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ICatalogo ccc = StartUpHandler.getSingletonInstance().getCatalogoCondCreator();
        ICatalogo cac = StartUpHandler.getSingletonInstance().getCatalogoAzCreator();

        //TODO sta qua solo provvisoriamente, verrà chiamato da un handler precedente
        Player player = StartUpHandler.getSingletonInstance().getPlayer();
        CreareStrategiaHandler.getSingletonInstance().setCurrentPlayer(player);//TODO anche questo non va qua
        CreareStrategiaHandler.getSingletonInstance().iniziaNuovaStrategia();

        List<ICreatorCustomLabel> condCLabels = LabelsMaker.getConditionCreatorLabels(ccc);
        ICreatorCustomLabel currentCLabel;
        for (int i=0; i<condCLabels.size(); i++){
            condizioniCreatorVBox.getChildren().add((Node) condCLabels.get(i));
        }
        /*
        GridPutter gridCondPutter = new GridPutter(conditionCreatorGrid);
        for (int i=0; i<condCLabels.size(); i++){
            if (!gridCondPutter.isFull()){
                currentCLabel= condCLabels.get(i);
                gridCondPutter.put((Node)currentCLabel);
                }
        }
        */

        List <ICreatorCustomLabel> azioneCLabels = LabelsMaker.getActionCreatorLabels(cac);//Vorrei chiamasse lo stesso metodo di sopra
        ICreatorCustomLabel currentALabel;
        for (int i=0; i<azioneCLabels.size(); i++){
            azioniCreatorVBox.getChildren().add((Node) azioneCLabels.get(i));
        }
        /*
        GridPutter gridAzioniPutter = new GridPutter(azioneCreatorGrid);
        for (int i=0; i<azioneCLabels.size(); i++){
            if (!gridAzioniPutter.isFull()){
                currentALabel= azioneCLabels.get(i);
                gridAzioniPutter.put((Node) currentALabel);
            }
        }
        */
    }
}
