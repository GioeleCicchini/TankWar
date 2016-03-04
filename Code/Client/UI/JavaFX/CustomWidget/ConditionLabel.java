package Client.UI.JavaFX.CustomWidget;

import javafx.scene.control.Label;

/**
 * Created by emanuele on 01/03/16.
 */
public class ConditionLabel extends Label implements ICustomLabel {

    private String name;
    private String description;
    private String idCond;
    private boolean vera;

    public ConditionLabel(String name, String description, String idCond, boolean vera) {
        this.name = name;
        this.description = description;
        this.idCond = idCond;
        this.vera = vera;
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

    @Override
    public boolean getVera() {
        return this.vera;
    }

    @Override
    public void setVera(boolean vera) {
        this.vera = vera;
    }


}
