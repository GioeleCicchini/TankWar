package Client.UI.JavaFX.CustomWidget;

import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Created by beniamino on 24/02/16.
 */
public class ConditionCreatorLabelCreator extends Label implements ICreatorCustomLabel {
    private String idType;
    private String name;
    private String description;

    public ConditionCreatorLabelCreator(String idType, String name, String description) {
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public ConditionCreatorLabelCreator(String text, String idType, String name, String description) {
        super(text);
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public ConditionCreatorLabelCreator(String text, Node graphic, String idType, String name, String description) {
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
