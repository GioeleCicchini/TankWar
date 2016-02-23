package Client.UI.JavaFX.View;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class CreareStrategia {
    public Label salutoLabel;

    public VBox boxpozzo;
    public Rectangle blucondition;
    public VBox ant;
    public Label labelll;


    public void faiSaluto(ActionEvent actionEvent) {
        salutoLabel.setText("Salutam a Soreta!");
    }


    public void startdragndrop(Event event) {
        Dragboard db = blucondition.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("Hello!");
        System.out.println("E pattita start drag n drop");
        db.setContent(content);
        event.consume();
    }

    public void dragover(Event event) {
        if (event.getSource() != blucondition){

        }
    }

    public void elementDropped(Event event) {
        System.out.println("element dropped!");
    }

    public void elementDragDone(Event event) {
        System.out.println("element drag done");
    }

    public void elementDragEntered(Event event) {
        System.out.println("element drag entered");
    }

    public void elementDragExited(Event event) {
        System.out.println("element drag exited");
    }

    public void elementDragOver(Event event) {
        System.out.println("element drag over");
    }

    public void mouseDragEntered(Event event) {
        System.out.println("mouse drag entered");
    }

    public void mouseDragExited(Event event) {
        System.out.println("mouse drag exited");
    }

    public void mouseDragOver(Event event) {
        System.out.println("mouse drag over");
    }

    public void mouseDragReleased(Event event) {
        System.out.println("mouse drag released");
    }

    public void scrivi(Event event) {
        System.out.println("sto qua");
    }

    public void aaaaant(Event event) {
        labelll.setText("scrivi cazzo");
    }

    public void startdrag(Event event) {
    }
}
