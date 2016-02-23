package Client.UI.JavaFX.View;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.event.*;

public class CreareStrategia {
    public Label salutoLabel;

    public VBox boxpozzo;
    public Rectangle blucondition;
    public VBox ant;
    public Label labelll;


    public Text trascinami;
    public Text trascinaqui; //target

    public void myDragDetected(Event event) {
        System.out.println("onDragDetected");

        Dragboard db = trascinami.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(trascinami.getText());
        db.setContent(content);
        

        event.consume();
    }

    public void myDragOver(DragEvent event) {
        System.out.println("onDragOver");

        if (event.getGestureSource() != trascinaqui && event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    public void myDragEntered(DragEvent event) {
        System.out.println("onDragEntered");
        if (event.getGestureSource() != trascinaqui &&
                event.getDragboard().hasString()) {
            trascinaqui.setFill(Color.GREEN);
        }
        event.consume();
    }

    public void myDragExited(Event event) {
        trascinaqui.setFill(Color.BLACK);

        event.consume();
    }

    public void myDragDropped(DragEvent event) {
        System.out.println("onDragDropped");
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            trascinaqui.setText(db.getString());
            success = true;
            event.setDropCompleted(success);

            event.consume();
        }
    }

    public void myDragDone(DragEvent event) {
        System.out.println("onDragDone");
        if (event.getTransferMode() == TransferMode.MOVE) {
            trascinami.setText("");
        }
        event.consume();
    }


}
