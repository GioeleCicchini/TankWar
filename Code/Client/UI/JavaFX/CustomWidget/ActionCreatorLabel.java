package Client.UI.JavaFX.CustomWidget;

import Client.UI.UIUtils.LabelsMaker;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by beniamino on 25/02/16.
 */
public class ActionCreatorLabel extends Label implements ICreatorCustomLabel {

    private String idType;
    private String name;
    private String description;

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
    public HBox makeComponent(String name, String description, String idAz, int indent) {
        ActionLabel actionLabel = new ActionLabel(name,description,idAz);
        actionLabel.setPadding(new Insets(0,0,0,20));
        HBox indentazione =  new HBox();
        int i;
        for(i=0;i<indent; i=i+1) {
            Label space = new Label();
            space.setMinWidth(50);
            indentazione.getChildren().add(space);
        }
        LabelsMaker.layoutizeLabel(actionLabel);
        indentazione.getChildren().add(actionLabel);
        return indentazione;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
