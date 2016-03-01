package Client.UI.UIUtils;

import Client.UI.JavaFX.CustomWidget.ActionCreatorLabelCreator;
import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabelCreator;
import Client.UI.JavaFX.CustomWidget.ICreatorCustomLabel;
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
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by beniamino on 25/02/16.
 */
public class LabelsMaker {

    //TODO Il metodo seguente non è flessibile, ne vorrei uno unico per Condition e Action. Occorrono pattern?

    public static List<ICreatorCustomLabel> getConditionLabels (ICatalogo catalogo){
        List<ICreatorCustomLabel> customLabels = new ArrayList<>();
        Map<String, ICreator> creators = catalogo.getCreators();
        ICreator currentCreator;
        for (String id: creators.keySet()) {
            currentCreator = creators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ICreatorCustomLabel myLabel = new ConditionCreatorLabelCreator(id,name,description);//Questa riga crea rigidità
            ((Label)myLabel).setText(currentCreator.getName());
            myLabel.setDescription(currentCreator.getDescription());

            layoutizeLabel(myLabel);
            customLabels.add(myLabel);
        }
        return customLabels;
    }

    public static List<ICreatorCustomLabel> getActionLabes (ICatalogo catalogo){
        List<ICreatorCustomLabel> customLabels = new ArrayList<>();
        Map<String,ICreator> creators = catalogo.getCreators();
        ICreator currentCreator;
        for (String id :
                creators.keySet()) {
            currentCreator = creators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ICreatorCustomLabel myLabel = new ActionCreatorLabelCreator(id,name,description);//RIGIDITA'
            ((Label)myLabel).setText(currentCreator.getName());
            myLabel.setDescription(currentCreator.getDescription());

            layoutizeLabel(myLabel);
            customLabels.add(myLabel);
        }
        return customLabels;
    }

    private static void layoutizeLabel(ICreatorCustomLabel myLabel){
        Random rand = new Random();
        float r = rand.nextFloat();
        while(r<0.5){
            r=rand.nextFloat();
        }
        float g = rand.nextFloat();
        while(g<0.5){
            g=rand.nextFloat();
        }
        float b = rand.nextFloat();
        while(b<0.5){
            b=rand.nextFloat();
        }
        Color color=Color.color(r,g,b);
        ((Label) myLabel).setBackground(new Background(new BackgroundFill(color,new CornerRadii(3),new Insets(0))));
        //((ConditionCreatorLabelCreator) myLabel).setLayoutX(1000);
        ((Label) myLabel).setBorder(Border.EMPTY);
        ((Label) myLabel).setMinSize(300,35);


        ((Label) myLabel).setTextAlignment(TextAlignment.CENTER);
        ((Label) myLabel).setFont(Font.font(20));


        ((Label)myLabel).setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = ((Label) event.getSource()).startDragAndDrop(TransferMode.ANY);

                ClipboardContent content = new ClipboardContent();
                content.putString("Qua ci andrà qualcosa per id");
                db.setContent(content);

                event.consume();
            }
        });
        ((Label)myLabel).setVisible(true);
    }

}
