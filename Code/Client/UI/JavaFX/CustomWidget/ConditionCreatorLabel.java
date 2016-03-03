package Client.UI.JavaFX.CustomWidget;

import Client.UI.UIUtils.LabelsMaker;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * Created by beniamino on 24/02/16.
 */
public class ConditionCreatorLabel extends Label implements ICreatorCustomLabel {
    private String idType;
    private String name;
    private String description;
    private Color color;

    public ConditionCreatorLabel(String idType, String name, String description) {
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public ConditionCreatorLabel(String text, String idType, String name, String description) {
        super(text);
        this.idType = idType;
        this.name = name;
        this.description = description;
    }

    public ConditionCreatorLabel(String text, Node graphic, String idType, String name, String description) {
        super(text, graphic);
        this.idType = idType;
        this.name = name;
        this.description = description;
    }


    @Override
    public ICustomLabel makeComponent(String name, String description, Color color, String idCond) {
        ConditionLabel conditionLabel = new ConditionLabel(name,description,idCond);
        conditionLabel.setPadding(new Insets(0,0,0,20));
        LabelsMaker.layoutizeLabel(conditionLabel,this.color);
        return conditionLabel;
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

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
