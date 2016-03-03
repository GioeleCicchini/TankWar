package Client.UI.JavaFX.CustomWidget;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by beniamino on 25/02/16.
 */
public interface ICreatorCustomLabel {

    public HBox makeComponent(String name, String description, String idComponent, int indent);
    public String getIdType();
    public void setIdType(String idType);
    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);

}
