package Client.UI.JavaFX.CustomWidget;

import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Created by beniamino on 25/02/16.
 */
public class ActionCreatorLabel extends Label implements ICustomLabel{

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
