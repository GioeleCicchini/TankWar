package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.ActionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ICreatorCustomLabel;
import Client.UI.JavaFX.CustomWidget.ICustomLabel;
import Client.UI.UIUtils.LabelsMaker;
import Client.UI.UIUtils.StrategiaPutter;
import Shared.Controllers.CreareStrategiaHandler;
import Shared.Controllers.StartUpHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class CreareStrategia implements Initializable {

    public Pane DropPaneTarget;
    public VBox condizioniCreatorVBox;
    public VBox azioniCreatorVBox;
    public VBox strategiaVBox;
    public TextField nomeStrategia;
    public ToggleButton toggleButton;
    public VBox condizioneDefaultVBox;
    public Button indietroButton;
    public StrategiaPutter strategiaPutter;
    public StrategiaPutter defaultPutter;
    private String where = null;
    private boolean messaAzioneDefault = false;


    public void targetDragOver(DragEvent event) {
        if (event.getGestureSource() != DropPaneTarget && event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    public void targetDragEntered(DragEvent event) {
        event.consume();
    }


    public void targetDragDropped(DragEvent event) {
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
                strategiaPutter.addLabel(conditionLabel, true);

            } else {
                System.out.println("Cond Annidata");
                idCondCreata = CreareStrategiaHandler.getSingletonInstance().scegliCondizioneAnnidata(idTypeCond, where, booleanoDellaCondizione, valori);
                ICustomLabel conditionLabel = labelDragged.makeComponent(idCondCreata, where, booleanoDellaCondizione);
                where = idCondCreata;
                strategiaPutter.addLabel(conditionLabel, false);
            }
        }
        if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ActionCreatorLabel")) { //TODO è bruttissimo
            //Caso in cui viene trascinato un AzioneCreator
            if (where != null) {
                System.out.println("Hey abbiamo un creator di azione");
                ActionCreatorLabel labelDragged = (ActionCreatorLabel) event.getGestureSource();
                String idTypeAz = labelDragged.getIdType();
                List<Integer> valori = new ArrayList<Integer>();
                String idAzioneCreata;
                idAzioneCreata = CreareStrategiaHandler.getSingletonInstance().associaAzione(idTypeAz, where, valori);
                ICustomLabel azioneLabel = labelDragged.makeComponent(idAzioneCreata, where, true);
                where = null;
                strategiaPutter.addLabel(azioneLabel, false);
            }
        }
    }

    public void condDragDone(DragEvent event) {
        event.consume();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        strategiaPutter = new StrategiaPutter(strategiaVBox);
        defaultPutter = new StrategiaPutter(condizioneDefaultVBox);

        nomeStrategia.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue){
                    System.out.println("Textfield on focus");
                }
                else {
                    System.out.println("Textfield out focus");
                    String nome = nomeStrategia.getText();
                    if (!nome.equals("")){
                        CreareStrategiaHandler.getSingletonInstance().inserisciNomeStrategia(nome);
                    }
                }
            }
        });

        Map ccc = StartUpHandler.getSingletonInstance().getCatalogoConditionCreatorMap();
        Map cac = StartUpHandler.getSingletonInstance().getCatalogoAzCreatorMap();

        List<ICreatorCustomLabel> condCLabels = LabelsMaker.getConditionCreatorLabels(ccc);
        ICreatorCustomLabel currentCLabel;
        for (int i = 0; i < condCLabels.size(); i++) {
            currentCLabel = condCLabels.get(i);
            if (currentCLabel.getIdType() != "000") { //Non vogliamo che ci sia la cond di defaults
                condizioniCreatorVBox.getChildren().add((Node) condCLabels.get(i));
            } else {
                Map strategiaCorrente = CreareStrategiaHandler.getSingletonInstance().getStrategiaCorrenteMap();
                String idCondDef = (String) ((Map) strategiaCorrente.get("defaultCondition")).get("id");
                ICustomLabel deafultCondizioneLabel = currentCLabel.makeComponent(idCondDef, null, true);
                defaultPutter.addLabel(deafultCondizioneLabel, true);
            }

        }

        List<ICreatorCustomLabel> azioneCLabels = LabelsMaker.getActionCreatorLabels(cac);//Vorrei chiamasse lo stesso metodo di sopra
        for (int i = 0; i < azioneCLabels.size(); i++) {
            azioniCreatorVBox.getChildren().add((Node) azioneCLabels.get(i));
        }
    }

    public void rimuoviComponente(MouseEvent event) {

        Integer lunghezzaVBox = this.strategiaVBox.getChildren().size();
        if (lunghezzaVBox > 0) {
            HBox rigaCorrente = (HBox) this.strategiaVBox.getChildren().get(lunghezzaVBox - 1);
            Integer lunghezzaHBox = rigaCorrente.getChildren().size();
            ICustomLabel ultimaInserita = (ICustomLabel) rigaCorrente.getChildren().get(lunghezzaHBox - 1);
            String idUltimaInserita = ultimaInserita.getIdComponent();
            where = ultimaInserita.getIdPadre();//La prossima messa andrà al posto di questa
            CreareStrategiaHandler.getSingletonInstance().rimuoviComponente(idUltimaInserita);
            strategiaPutter.removeLastLabel();
        }
    }

    public void terminaStrategia(MouseEvent event) throws IOException {
        CreareStrategiaHandler.getSingletonInstance().terminaStrategia();
    }

    public void inserisciNomeStrategia(Event event) {
        String nome = nomeStrategia.getText();
        CreareStrategiaHandler.getSingletonInstance().inserisciNomeStrategia(nome);
    }

    public void clickToggle(Event event) {
        if (toggleButton.isSelected()) {
            toggleButton.setText("Premi per le NON negate");
            toggleButton.setStyle("-fx-background-color:#0277BD");

            ConditionCreatorLabel currentElement;
            for (int i = 0; i < condizioniCreatorVBox.getChildren().size(); i++) {
                currentElement = (ConditionCreatorLabel) condizioniCreatorVBox.getChildren().get(i);
                currentElement.setFalse();
            }
        } else {
            toggleButton.setText("Premi per le negate");
            toggleButton.setStyle("-fx-background-color:#01579B");
            ConditionCreatorLabel currentElement;
            for (int i = 0; i < condizioniCreatorVBox.getChildren().size(); i++) {
                currentElement = (ConditionCreatorLabel) condizioniCreatorVBox.getChildren().get(i);
                currentElement.setTrue();
            }
        }
    }


    public void rimuoviAzioneDefault(MouseEvent event) {
        Integer elementi = this.condizioneDefaultVBox.getChildren().size();
        if (elementi == 2) {
            HBox riga = (HBox) this.condizioneDefaultVBox.getChildren().get(1);
            Integer lunghezzaHBox = riga.getChildren().size();
            ICustomLabel label = (ICustomLabel) riga.getChildren().get(lunghezzaHBox - 1);
            String idLabel = label.getIdComponent();
            messaAzioneDefault = false;
            CreareStrategiaHandler.getSingletonInstance().rimuoviComponente(idLabel);
            defaultPutter.removeLastLabel();
        }

    }

    public void defDragDone(DragEvent event) {
        event.consume();
    }

    public void defDragDropped(DragEvent event) {
        if (!messaAzioneDefault) {
            if (event.getGestureSource().getClass().toString().equals("class Client.UI.JavaFX.CustomWidget.ActionCreatorLabel")) { //TODO è bruttissimo
                System.out.println("Hey abbiamo un creator di azione nel default pozzo");
                ActionCreatorLabel labelDragged = (ActionCreatorLabel) event.getGestureSource();
                String idTypeAz = labelDragged.getIdType();
                List<Integer> valori = new ArrayList<Integer>();
                String idAzioneCreata;
                idAzioneCreata = CreareStrategiaHandler.getSingletonInstance().scegliAzioneDefault(idTypeAz, valori);
                Map strategiaMap = CreareStrategiaHandler.getSingletonInstance().getStrategiaCorrenteMap();
                String idCondDefault = (String) ((Map) strategiaMap.get("defaultCondition")).get("id");
                ICustomLabel azioneLabel = labelDragged.makeComponent(idAzioneCreata, idCondDefault, true);
                defaultPutter.addLabel(azioneLabel, false);
                messaAzioneDefault = true;
            }
        }

    }

    public void defDragEntered(DragEvent event) {
        event.consume();
    }

    public void defDragOver(DragEvent event) {
        if (event.getGestureSource() != DropPaneTarget && event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    public void indietro(MouseEvent event) {

        CreareStrategiaHandler.getSingletonInstance().distruggiStrategiaCorrente();
        Stage stage;
        Parent root = null;

        stage = (Stage) indietroButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("../Fxml/inizio.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();


    }


}
