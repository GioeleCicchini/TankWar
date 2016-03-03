package Client.UI.JavaFX.CustomWidget;

import Client.UI.UIUtils.LabelsMaker;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by beniamino on 24/02/16.
 */
public class ConditionCreatorLabel extends Label implements ICreatorCustomLabel {
    private String idType;
    private String name;
    private String description;

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
    public HBox makeComponent(String name, String description, String idCond,int indent) {
        ConditionLabel conditionLabel = new ConditionLabel(name,description,idCond);
        conditionLabel.setPadding(new Insets(0,0,0,20));
        HBox indentazione =  new HBox();
        int i;
        for(i=0;i<indent; i=i+1) {
            Label space = new Label();
            space.setMinWidth(50);
            indentazione.getChildren().add(space);
        }
        LabelsMaker.layoutizeLabel(conditionLabel);
        indentazione.getChildren().add(conditionLabel);
        return indentazione;
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
