package Client.UI.UIUtils;

import Client.UI.JavaFX.CustomWidget.ActionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ICreatorCustomLabel;
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

    public static List<ICreatorCustomLabel> getConditionCreatorLabels(ICatalogo catalogo){
        List<ICreatorCustomLabel> customLabels = new ArrayList<>();
        Map<String, ICreator> creators = catalogo.getCreators();
        ICreator currentCreator;
        for (String id: creators.keySet()) {
            currentCreator = creators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ICreatorCustomLabel myLabel = new ConditionCreatorLabel(id,name,description);//Questa riga crea rigidità
            ((Label)myLabel).setText(currentCreator.getName());
            myLabel.setDescription(currentCreator.getDescription());
            double r = 0.753;
            double g = 0.902;
            double b = 0.514;
            layoutizeLabelCreator(myLabel, r,g,b);
            setTrue((ConditionCreatorLabel) myLabel);//Non è pulitissimo
            customLabels.add(myLabel);
        }
        return customLabels;
    }

    public static List<ICreatorCustomLabel> getActionCreatorLabels(ICatalogo catalogo){
        List<ICreatorCustomLabel> customLabels = new ArrayList<>();
        Map<String,ICreator> creators = catalogo.getCreators();
        ICreator currentCreator;
        for (String id :
                creators.keySet()) {
            currentCreator = creators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ICreatorCustomLabel myLabel = new ActionCreatorLabel(id,name,description);//RIGIDITA'
            ((Label)myLabel).setText(currentCreator.getName());
            myLabel.setDescription(currentCreator.getDescription());
            double r = 0.012;
            double g = 0.61;
            double b = 0.90;
            layoutizeLabelCreator(myLabel,r,g,b);
            customLabels.add(myLabel);
        }
        return customLabels;
    }

    private static void layoutizeLabelCreator(ICreatorCustomLabel myLabel, double r,double g, double b){
        /*Random rand = new Random();
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
        }*/
        Color color=Color.color(r,g,b);
        ((Label) myLabel).setBackground(new Background(new BackgroundFill(color,new CornerRadii(3),new Insets(0))));
        //((ConditionCreatorLabel) myLabel).setLayoutX(1000);
        ((Label) myLabel).setStyle("-fx-border-color: white;");
        ((Label) myLabel).setMinSize(400,35);


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

    public static void layoutizeLabel(ICustomLabel myLabel,Color color){

        ((Label) myLabel).setBackground(new Background(new BackgroundFill(color,new CornerRadii(3),new Insets(0))));
        ((Label) myLabel).setBorder(Border.EMPTY);
        ((Label) myLabel).setStyle("-fx-border-color: white;");
        ((Label) myLabel).setMinSize(400,35);
        ((Label) myLabel).setText(myLabel.getName());
        myLabel.setDescription(myLabel.getDescription());


        ((Label) myLabel).setTextAlignment(TextAlignment.CENTER);
        ((Label) myLabel).setFont(Font.font(20));

        ((Label)myLabel).setVisible(true);
    }

    public static void setTrue(ConditionCreatorLabel l){
        Double r= 0.753;
        Double g= 0.902;
        Double b= 0.514;
        Color color =Color.color(r,g,b);
        ((Label) l).setBackground(new Background(new BackgroundFill(color,new CornerRadii(3),new Insets(0))));
        String text = l.getName();
        text="Se " + text;
        l.setText(text);
    }

    public static void setFalse(ConditionCreatorLabel l){
        Double r= 1.0;
        Double g= 0.4;
        Double b= 0.4;
        Color color =Color.color(r,g,b);
        ((Label) l).setBackground(new Background(new BackgroundFill(color,new CornerRadii(3),new Insets(0))));
        String text = l.getName();
        text="Se NON " + text;
        l.setText(text);
    }

}
