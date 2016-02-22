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
    public Button faisalutoButton;
    public Rectangle blucondition;
    public VBox boxpozzo;


    public void faiSaluto(ActionEvent actionEvent) {
        salutoLabel.setText("Salutam a Soreta!");
    }


    public void startdragndrop(Event event) {
        Dragboard db = blucondition.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("Pippo");
        db.setContent(content);

        event.consume();
    }

    public void dragover(Event event) {
        if (event.getSource() != blucondition){

        }
    }
}
