package Client.UI.UIUtils;

import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ICustomLabel;
import Shared.Domain.Creator.ICreator;
import Shared.Domain.ICatalogo;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by beniamino on 25/02/16.
 */
public class LabelsMaker {

    //TODO Il metodo seguente non è flessibile, ne vorrei uno unico per Condition e Action. Occorrono pattern?

    public List<ICustomLabel> getConditionLabels (ICatalogo catalogo){
        List<ICustomLabel> customLabels = new ArrayList<>();
        Map<String, ICreator> creators = catalogo.getCreators();
        for (String id: creators.keySet()) {
            ICreator currentCreator = creators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ICustomLabel myLabel = new ConditionCreatorLabel(id,name,description);
            ((ConditionCreatorLabel)myLabel).setText(currentCreator.getName());
            ((ConditionCreatorLabel)myLabel).setDescription(currentCreator.getDescription());
            ((ConditionCreatorLabel)myLabel).setVisible(true);
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color color=Color.color(r,g,b);
            ((ConditionCreatorLabel) myLabel).setBackground(new Background(new BackgroundFill(color,new CornerRadii(3),new Insets(0))));
            //((ConditionCreatorLabel) myLabel).setLayoutX(1000);
            ((ConditionCreatorLabel) myLabel).setBorder(Border.EMPTY);

            ((ConditionCreatorLabel)myLabel).setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Dragboard db = ((Label) event.getSource()).startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString("Qua ci andrà qualcosa per id");
                    db.setContent(content);

                    event.consume();
                }
            });
            customLabels.add(myLabel);
        }
        return customLabels;
    }

}
