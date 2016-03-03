package Client.UI.UIUtils;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by emanuele on 03/03/16.
 */
public class HBoxMaker {

    public static HBox crea(int indentazione) {
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
