package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.*;
import Client.UI.UIUtils.LabelsMaker;
import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.ICatalogo;
import Shared.Domain.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CreareStrategia implements Initializable{

    public Pane DropPaneTarget;
    public Label labelFeedback;
    public VBox condizioniCreatorVBox;
    public VBox azioniCreatorVBox;
    public VBox strategiaVBox;
    public TextArea nomeStrategia;
    private int indentazione;

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



            String idTypeCond = labelDragged.getIdType();
            List<Integer> valori = new ArrayList<Integer>();
            if (!prossimaCondAnnidata){
                System.out.println("Cond non Annidata!");
                ultimaCondizione= CreareStrategiaHandler.getSingletonInstance().scegliCondizione(idTypeCond,true,valori);
            }
            else {
                System.out.println("Cond Annidata");
                ultimaCondizione=CreareStrategiaHandler.getSingletonInstance().scegliCondizioneAnnidata(idTypeCond,ultimaCondizione,true,valori);
                indentazione = indentazione +1;
            }
            prossimaCondAnnidata=true;//La prossima si anniderà a questa
            String nameLabel = labelDragged.getName();
            String descriptionLabel = labelDragged.getDescription();
            HBox conditionLabel = labelDragged.makeComponent(nameLabel,descriptionLabel,ultimaCondizione,indentazione);
            strategiaVBox.getChildren().add((Node)conditionLabel);

        }
        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ActionCreatorLabel") ){ //TODO è bruttissimo
            System.out.println("Hey abbiamo un creator di azione");
            //TODO Mettere un feedback nella grafica
            ActionCreatorLabel labelDragged =(ActionCreatorLabel) event.getGestureSource();
            
            String idTypeAz = labelDragged.getIdType();
            List<Integer> valori = new ArrayList<>();
            if (ultimaCondizione != null && strategiaVBox.getChildren().size() != 0){
                indentazione = indentazione +1 ;
                System.out.println("Sto appendendo l'azione ad una condizione già inserita");
                CreareStrategiaHandler.getSingletonInstance().associaAzione(idTypeAz,ultimaCondizione,valori);
                prossimaCondAnnidata = false;
                String nameLabel = labelDragged.getName();
                String descriptionLabel = labelDragged.getDescription();
                HBox actionLabel = labelDragged.makeComponent(nameLabel,descriptionLabel,ultimaCondizione,indentazione);
                strategiaVBox.getChildren().add((Node)actionLabel);

                ultimaCondizione = null;
                indentazione = 0;
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

    public void rimuoviComponente(MouseEvent event) {

        Integer lunghezza  = strategiaVBox.getChildren().size();
        if (lunghezza != 0) {
            HBox riga = (HBox)strategiaVBox.getChildren().get(lunghezza-1);
            ICustomLabel label= (ICustomLabel)riga.getChildren().get(riga.getChildren().size()-1);
            String idComponent = label.getIdComponent();
            CreareStrategiaHandler.getSingletonInstance().rimuoviComponente(idComponent);
            strategiaVBox.getChildren().remove(riga);

            lunghezza = lunghezza - 1;
            Integer indexUltimo = lunghezza-1;
            if (lunghezza != 0) {
                ICustomLabel ultima= (ICustomLabel)(riga.getChildren().get(riga.getChildren().size()-1));
                ultimaCondizione = ultima.getIdComponent();
                indentazione = indentazione -1 ;
            } else {
                ultimaCondizione = null;
                indentazione = 0;
            }
        }
    }

    public void terminaStrategia(MouseEvent event) throws IOException {
        CreareStrategiaHandler creareStrategiaHandler = CreareStrategiaHandler.getSingletonInstance();
        creareStrategiaHandler.inserisciNomeStrategia(nomeStrategia.getText());
        creareStrategiaHandler.terminaStrategia();
    }

    public void inserisciNomeStrategia(Event event) {
        String nome = nomeStrategia.getText();
        CreareStrategiaHandler.getSingletonInstance().inserisciNomeStrategia(nome);
        System.out.println(nome);
    }
}
