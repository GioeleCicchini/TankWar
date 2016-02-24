package Client.UI.JavaFX.CustomWidget;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * Created by beniamino on 24/02/16.
 */
public class LabelConditionCreator extends Label{
    private String idType;

    public LabelConditionCreator(String idType) {
        this.idType = idType;
    }

    public LabelConditionCreator(String text, String idType) {
        super(text);
        this.idType = idType;
    }

    public LabelConditionCreator(String text, Node graphic, String idType) {
        super(text, graphic);
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}
