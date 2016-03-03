package Client.UI.JavaFX.CustomWidget;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Created by beniamino on 25/02/16.
 */
public interface ICreatorCustomLabel {

    public ICustomLabel makeComponent(String name, String description, Color color, String idComponent);
    public String getIdType();
    public void setIdType(String idType);
    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);
    public void setColor(Color color);
    public Color getColor();

}
