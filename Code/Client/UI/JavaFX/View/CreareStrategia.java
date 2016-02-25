package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.LabelConditionCreator;
import Shared.Domain.CatalogoCondizioneCreator;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import java.util.HashMap;
import java.util.Map;

public class CreareStrategia {

    public Pane DropPaneTarget;
    public Rectangle NemicoAvantiRectangle;
    public Rectangle NemicoDestraRectangle;
    public Rectangle NemicoSinistraRectangle;
    public Rectangle NemicoDietroRectangle;
    public Rectangle NemicoSottoTiroRectangle;
    public Label labelFeedback;
    public Pane PaneCondizioni = new Pane();
    public GridPane gridPane = new GridPane();


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

    public void caricaSchermata() {
        CatalogoCondizioneCreator catalogoCondizioneCreator = CatalogoCondizioneCreator.getSingletonInstance();
        Map<String, LabelConditionCreator> LabelMap = new HashMap<>();
        for (String id : catalogoCondizioneCreator.getCondizioniCreators().keySet()) {
            LabelConditionCreator lcc = new LabelConditionCreator(id);
            LabelMap.put(id, lcc); //perchè sono solo 2?
            //System.out.println(lcc.toString());
        }
        //System.out.println(PaneCondizioni);
        //System.out.println(gridPane);

        //GRIDPANE

        LabelConditionCreator elemento;
        for (String id:LabelMap.keySet()) {
            elemento = LabelMap.get(id);
            elemento.setVisible(true);
            elemento.setText("Mammeta Works");
            elemento.setLayoutX(10);
            elemento.setLayoutY(10);
            elemento.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    System.out.println("Nonneta works");
                }
            });
            gridPane.add(elemento,0,0);
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
