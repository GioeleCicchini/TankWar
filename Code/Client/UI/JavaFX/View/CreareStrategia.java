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
import java.awt.event.MouseEvent;

public class CreareStrategia {


    public Text trascinami;
    public Text trascinaqui; //target
    public Rectangle blueSource;
    public Rectangle whiteTarget;



    public void myDragOver(DragEvent event) {
        System.out.println("onDragOver");

        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

        event.consume();
    }

    public void myDragEntered(DragEvent event) {
        System.out.println("onDragEntered");

        ((Rectangle)event.getGestureSource()).setFill(Color.BISQUE);

        event.consume();
    }

    public void myDragExited(DragEvent event) {
        ((Rectangle)event.getGestureSource()).setFill(Color.BLACK);

        event.consume();
    }

    public void myDragDropped(DragEvent event) {
        System.out.println("onDragDropped");
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            success = true;
            event.setDropCompleted(success);

            event.consume();
        }
    }

    public void myDragDone(DragEvent event) {
        System.out.println("onDragDone");
        if (event.getTransferMode() == TransferMode.MOVE) {
        }
        event.consume();
    }


    public void myDragDetected(MouseEvent event) {
        System.out.println("onDragDetected");

        Dragboard db = ((Rectangle)event.getSource()).startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("rerere");
        db.setContent(content);


        event.consume();
    }
}
