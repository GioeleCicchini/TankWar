package Client.UI.JavaFX.View;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CreareStrategia {
    public Label salutoLabel;
    public Button faisalutoButton;


    public void faiSaluto(ActionEvent actionEvent) {
        salutoLabel.setText("Salutam a Soreta!");
    }
}
