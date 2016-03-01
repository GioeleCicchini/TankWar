package Client.UI.JavaFX.CustomWidget;

import javafx.scene.control.Label;

/**
 * Created by emanuele on 01/03/16.
 */
public class ConditionLabel extends Label implements ICustomLabel {

    private String name;
    private String description;
    private String idCond;

    public ConditionLabel(String name, String description, String idCond) {
        this.name = name;
        this.description = description;
        this.idCond = idCond;
    }


    @Override
    public String getIdComponent() {
        return this.idCond;
    }

    @Override
    public void setIdComponent(String idCond) {
        this.idCond = idCond;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
