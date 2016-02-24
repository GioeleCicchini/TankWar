package Client.UI.JavaFX.View;

import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;

import java.awt.*;

/**
 * Created by emanuele on 23/02/16.
 */
public class nuovo {
    public Label label;
    public Circle cerchio;
    public Label label1;
    public Circle cerchio1;


    public void dragLabel(Event event) {
        System.out.println("onDragDetected");

                /* allow any transfer mode */
        Dragboard db = ((Circle)event.getSource()).startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(label.getText());
        db.setContent(content);

        event.consume();
    }

    public void dragOver(DragEvent event) {
        /* data is dragged over the target */
        System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
        if (event.getGestureSource() != label &&
                event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    public void dragEntered(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() != label &&
                event.getDragboard().hasString()) {
            cerchio.setFill(Color.TRANSPARENT);
        }

        event.consume();
    }

    public void dragDropped(DragEvent event) {

                /* data dropped */
            System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
            Dragboard db = event.getDragboard();
            boolean success = false;
        ((Circle)event.getGestureSource()).setLayoutX(MouseInfo.getPointerInfo().getLocation().getX());
        ((Circle)event.getGestureSource()).setLayoutY(MouseInfo.getPointerInfo().getLocation().getY());
        ((Circle)event.getGestureSource()).setScaleZ(100);
        System.out.println(MouseInfo.getPointerInfo().getLocation().getX());
        System.out.println(MouseInfo.getPointerInfo().getLocation().getY());
            success = true;
                /* let the source know whether the string was successfully
                 * transferred and used */
            event.setDropCompleted(success);

            event.consume();

    }
}
