package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.LabelConditionCreator;
import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CreareStrategia implements Initializable{

    public Pane DropPaneTarget;
    public Rectangle NemicoAvantiRectangle;
    public Rectangle NemicoDestraRectangle;
    public Rectangle NemicoSinistraRectangle;
    public Rectangle NemicoDietroRectangle;
    public Rectangle NemicoSottoTiroRectangle;
    public Label labelFeedback;
    public GridPane conditionCreatorGrid;


    public void condDragDetected(Event event) {
        System.out.println("onDragDetected");

        Dragboard db = ((Label) event.getSource()).startDragAndDrop(TransferMode.ANY);
        //Dragboard db = NemicoAvantiRectangle.startDragAndDrop(TransferMode.ANY);


        ClipboardContent content = new ClipboardContent();
        content.putString("Qua ci andrà qualcosa per id");
        db.setContent(content);

        event.consume();
    }

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

        labelFeedback.setText("PRESA!");

        //TODO mettere qua il fatto che si scrive il pezzo nella strategia

        success = true;

        event.setDropCompleted(success);

        event.consume();
    }

    public void condDragDone(DragEvent event) {
        System.out.println("onDragDone");

        event.consume();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CatalogoCondizioneCreator catalogoCondizioneCreator = CatalogoCondizioneCreator.getSingletonInstance();
        HashMap<String, LabelConditionCreator> LabelMap = new HashMap<>();
        Map<String, ICondizioneCreator> catalogoMap = catalogoCondizioneCreator.getCondizioniCreators();
        for (String id : catalogoMap.keySet()) {
            String name = catalogoMap.get(id).getName();
            String description = catalogoMap.get(id).getDescription();
            LabelConditionCreator lcc = new LabelConditionCreator(id,name,description);
            LabelMap.put(id, lcc); //perchè sono solo 2?
            //System.out.println(lcc.toString());
        }
        //System.out.println(PaneCondizioni);
        //System.out.println(gridPane);

        //GRIDPANE

        LabelConditionCreator elemento;
        for (String id: LabelMap.keySet()) {
            elemento = LabelMap.get(id);
            elemento.setVisible(true);
            elemento.setText(LabelMap.get(id).getName());
            elemento.setDescription(LabelMap.get(id).getDescription());
            conditionCreatorGrid.add(elemento,0,0);
            System.out.println("Mammeta");
        }



        //PANE SEMPLICE
        /*
        LabelConditionCreator elemento;
        for (String id : LabelMap.keySet()) {
            elemento = LabelMap.get(id);
            System.out.println(elemento.toString());

            //PaneCondizioni.getChildren().add(elemento);
        }
        */



    }
}
