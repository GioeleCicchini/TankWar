package Client.UI.UIUtils;

import Client.UI.JavaFX.CustomWidget.ICustomLabel;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by emanuele on 03/03/16.
 */
public class HBoxMaker {

    private static Integer indentazione = 0;

    public static HBox creaRiga(ICustomLabel iCustomLabel,boolean diretta) {
        if (diretta) {
            indentazione = 0;
        } else {
            indentazione = indentazione+1;
        }
        HBox elemento = HBoxMaker.creaSpazi();
        elemento.getChildren().add((Node) iCustomLabel);
        return elemento;
    }

    public static HBox creaSpazi() {
        HBox elemento =  new HBox();
        int i;
        for(i=0;i<indentazione; i=i+1) {
            Label space = new Label();
            space.setMinWidth(50);
            elemento.getChildren().add(space);
        }
        return elemento;
    }

}
