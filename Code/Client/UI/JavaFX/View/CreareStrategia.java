package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.*;
import Client.UI.UIUtils.StrategiaPutter;
import Client.UI.UIUtils.LabelsMaker;
import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.ICatalogo;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.*;
import javafx.scene.layout.*;

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
    public ToggleButton toggleButton;
    private int indentazione;
    private String where = null;
    public StrategiaPutter strategiaPutter;

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
        boolean booleanoDellaCondizione = true;
        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel")) { //TODO è bruttissimo
            //Caso in cui viene trascinato un CondizioneCreator
            System.out.println("Hey abbiamo un creator di condizione");
            ConditionCreatorLabel labelDragged = (ConditionCreatorLabel) event.getGestureSource();
            String idTypeCond = labelDragged.getIdType();
            List<Integer> valori = new ArrayList<Integer>();
            String idCondCreata;
            if (toggleButton.isSelected()) {
                booleanoDellaCondizione = false;
            }
            if (where == null) { //è una condizione direttamente figlia di strategia
                System.out.println("Cond non Annidata!");
                idCondCreata = CreareStrategiaHandler.getSingletonInstance().scegliCondizione(idTypeCond, booleanoDellaCondizione, valori);
                ICustomLabel conditionLabel = labelDragged.makeComponent(idCondCreata, where, booleanoDellaCondizione);
                where = idCondCreata;
                strategiaPutter.addLabel(conditionLabel,true);

            } else {
                System.out.println("Cond Annidata");
                idCondCreata = CreareStrategiaHandler.getSingletonInstance().scegliCondizioneAnnidata(idTypeCond, where, booleanoDellaCondizione, valori);
                ICustomLabel conditionLabel = labelDragged.makeComponent(idCondCreata, where, booleanoDellaCondizione);
                where = idCondCreata;
                strategiaPutter.addLabel(conditionLabel,false);
            }
        }
        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ActionCreatorLabel") ) { //TODO è bruttissimo
            //Caso in cui viene trascinato un AzioneCreator
            if (where!=null) {
                System.out.println("Hey abbiamo un creator di azione");
                ActionCreatorLabel labelDragged = (ActionCreatorLabel) event.getGestureSource();
                String idTypeAz = labelDragged.getIdType();
                List<Integer> valori = new ArrayList<Integer>();
                String idAzioneCreata;
                idAzioneCreata = CreareStrategiaHandler.getSingletonInstance().associaAzione(idTypeAz,where,valori);
                ICustomLabel azioneLabel = labelDragged.makeComponent(idAzioneCreata,where,true); //TODO cacca
                where = null;
                strategiaPutter.addLabel(azioneLabel,false);
            }
        }
        /*System.out.println("onDragDropped");


        Dragboard db = event.getDragboard();
        boolean success = false;
        boolean vera = true;

        System.out.println("Ho appena droppato qualcosa");

        System.out.println("Il nome della classe dell'oggetto draggato è " + event.getGestureSource().getClass().toString());

        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel")){ //TODO è bruttissimo
            System.out.println("Hey abbiamo un creator di condizione");
            //TODO mettere qua il fatto che si scrive il pezzo nella strategia
            ConditionCreatorLabel labelDragged =(ConditionCreatorLabel) event.getGestureSource();



            String idTypeCond = labelDragged.getIdType();
            List<Integer> valori = new ArrayList<Integer>();
            if (toggleButton.isSelected()) {
                vera = false;
            }
            if (!prossimaCondAnnidata){
                System.out.println("Cond non Annidata!");
                ultimaCondizione= CreareStrategiaHandler.getSingletonInstance().scegliCondizione(idTypeCond,vera,valori);
            }
            else {
                System.out.println("Cond Annidata");
                ultimaCondizione=CreareStrategiaHandler.getSingletonInstance().scegliCondizioneAnnidata(idTypeCond,ultimaCondizione,vera,valori);
                indentazione = indentazione +1;
            }
            prossimaCondAnnidata=true;//La prossima si anniderà a questa
            String nameLabel = labelDragged.getName();
            String descriptionLabel = labelDragged.getDescription();
            Color colore = labelDragged.getColor();
            ICustomLabel conditionLabel = labelDragged.makeComponent(nameLabel,descriptionLabel,colore,ultimaCondizione,vera);
            HBox elemento = StrategiaPutter.crea(indentazione);
            elemento.getChildren().add((Label)conditionLabel);
            strategiaVBox.getChildren().add(elemento);

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
                Color colore = labelDragged.getColor();
                ICustomLabel actionLabel = labelDragged.makeComponent(nameLabel,descriptionLabel,colore,ultimaCondizione,vera);
                HBox elemento = StrategiaPutter.crea(indentazione);
                elemento.getChildren().add((Label)actionLabel);
                strategiaVBox.getChildren().add(elemento);

                ultimaCondizione = null;
                indentazione = 0;
            }


        }
        System.out.println("Mammeta");

        success = true;

        event.setDropCompleted(success);

        event.consume();
        System.out.println("Ultima condizione: " + ultimaCondizione);*/
        System.out.println("Lunghezza VBox= "+ ((Integer)strategiaVBox.getChildren().size()).toString());
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

        strategiaPutter= new StrategiaPutter(strategiaVBox);

    }

    public void rimuoviComponente(MouseEvent event) {

        Integer lunghezzaVBox = this.strategiaVBox.getChildren().size();
        if (lunghezzaVBox > 0){
            HBox rigaCorrente = (HBox)this.strategiaVBox.getChildren().get(lunghezzaVBox-1);
            Integer lunghezzaHBox = rigaCorrente.getChildren().size();
            ICustomLabel ultimaInserita = (ICustomLabel)rigaCorrente.getChildren().get(lunghezzaHBox-1);
            String idUltimaInserita = ultimaInserita.getIdComponent();
            where=ultimaInserita.getIdPadre();//La prossima messa andrà al posto di questa
            CreareStrategiaHandler.getSingletonInstance().rimuoviComponente(idUltimaInserita);
            strategiaPutter.removeLastLabel();
            System.out.println("lunghezza VBox= " + this.strategiaVBox.getChildren().size());
        }

        /*Integer lunghezza  = strategiaVBox.getChildren().size();
        if (lunghezza != 0) {
            HBox riga = (HBox)strategiaVBox.getChildren().get(lunghezza-1);
            ICustomLabel label= (ICustomLabel)riga.getChildren().get(riga.getChildren().size()-1);
            String idComponent = label.getIdComponent();
            CreareStrategiaHandler.getSingletonInstance().rimuoviComponente(idComponent);
            strategiaVBox.getChildren().remove(riga);

            lunghezza = lunghezza - 1;
            if (lunghezza != 0) {
                indentazione = indentazione -1 ;
                HBox ultimaRiga= (HBox) strategiaVBox.getChildren().get(lunghezza-1);
                ICustomLabel ultima = (ICustomLabel)(ultimaRiga.getChildren().get(ultimaRiga.getChildren().size()-1));
                ultimaCondizione = ultima.getIdComponent();
                if (indentazione == -1) {
                    indentazione = 0;
                    prossimaCondAnnidata = false;
                    System.out.println("Ci sono");

                }
            } else {
                ultimaCondizione = null;
                indentazione = 0;
            }
        }*/
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

    public void clickToggle(Event event) {
        if (toggleButton.isSelected()){
            toggleButton.setText("Premi per le NON negate");
            ConditionCreatorLabel currentElement;
            for (int i=0; i<condizioniCreatorVBox.getChildren().size(); i++){
                currentElement = (ConditionCreatorLabel) condizioniCreatorVBox.getChildren().get(i);
                currentElement.setFalse();
            }
        }
        else {
            toggleButton.setText("Premi per le negate");
            ConditionCreatorLabel currentElement;
            for (int i=0; i<condizioniCreatorVBox.getChildren().size(); i++){
                currentElement = (ConditionCreatorLabel) condizioniCreatorVBox.getChildren().get(i);
                currentElement.setTrue();
            }
        }
    }
}
