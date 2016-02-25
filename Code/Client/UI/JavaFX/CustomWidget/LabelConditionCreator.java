package Client.UI.JavaFX.CustomWidget;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * Created by beniamino on 24/02/16.
 */
public class LabelConditionCreator extends Label{
    private String idType;
    private String name;
    private String description;

    public LabelConditionCreator(String idType, String name, String description) {
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public LabelConditionCreator(String text, String idType, String name, String description) {
        super(text);
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public LabelConditionCreator(String text, Node graphic, String idType, String name, String description) {
        super(text, graphic);
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
