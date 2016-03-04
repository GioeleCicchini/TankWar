package Client.UI.JavaFX.CustomWidget;

import Client.UI.UIUtils.LabelsMaker;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Created by beniamino on 25/02/16.
 */
public class ActionCreatorLabel extends Label implements ICreatorCustomLabel {

    private String idType;
    private String name;
    private String description;
    private Color color;

    public ActionCreatorLabel(String idTypeAz, String name, String description) {
        this.idType = idTypeAz;
        this.name = name;
        this.description = description;
    }

    public ActionCreatorLabel(String text, String idTypeAz, String name, String description) {
        super(text);
        this.idType = idTypeAz;
        this.name = name;
        this.description = description;
    }

    public ActionCreatorLabel(String text, Node graphic, String idTypeAz, String name, String description) {
        super(text, graphic);
        this.idType = idTypeAz;
        this.name = name;
        this.description = description;
    }

    @Override
    public ICustomLabel makeComponent(String name, String description, Color color, String idAz,boolean vera) {
        ActionLabel actionLabel = new ActionLabel(name,description,idAz,vera);
        actionLabel.setPadding(new Insets(0,0,0,20));
        LabelsMaker.layoutizeLabel(actionLabel,this.color);
        return actionLabel;

    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idTypeAz) {
        this.idType = idTypeAz;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
