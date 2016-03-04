package Client.UI.JavaFX.CustomWidget;

import javafx.scene.control.Label;

/**
 * Created by emanuele on 01/03/16.
 */
public class ActionLabel extends Label implements ICustomLabel {

    private String name;
    private String description;
    private String idAz;
    private boolean vera;

    public ActionLabel(String name, String description, String idAz, boolean vera) {
        this.name = name;
        this.description = description;
        this.idAz = idAz;
        this.vera = vera;
    }


    @Override
    public String getIdComponent() {
        return this.idAz;
    }

    @Override
    public void setIdComponent(String idComponent) {
        this.idAz = idComponent;
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
