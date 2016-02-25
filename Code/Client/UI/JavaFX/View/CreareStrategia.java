package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.UIUtils.GridPutter;
import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.*;

public class CreareStrategia implements Initializable{

    public Pane DropPaneTarget;
    public Rectangle NemicoAvantiRectangle;
    public Rectangle NemicoDestraRectangle;
    public Rectangle NemicoSinistraRectangle;
    public Rectangle NemicoDietroRectangle;
    public Rectangle NemicoSottoTiroRectangle;
    public Label labelFeedback;
    public GridPane conditionCreatorGrid;
    public GridPane azioneCreatorGrid;


    public void condDragDetected(Event event) {
        System.out.println("onDragDetected");

        Dragboard db = ((Label) event.getSource()).startDragAndDrop(TransferMode.ANY);
        //Dragboard db = NemicoAvantiRectangle.startDragAndDrop(TransferMode.ANY);


        ClipboardContent content = new ClipboardContent();
        content.putString("Qua ci andrà qualcosa per id");
        db.setContent(content);

        event.consume();
    }

    public void targetDragOver(DragEvent event) {
        System.out.println("onDragOver");

        if (event.getGestureSource() != DropPaneTarget && event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    public void targetDragEntered(DragEvent event) {
        System.out.println("onDragEntered");

        if (event.getGestureSource() != DropPaneTarget && event.getDragboard().hasString()) {
            DropPaneTarget.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
        }

        event.consume();
    }

    public void targetDragDropped(DragEvent event) {
        System.out.println("onDragDropped");

        Dragboard db = event.getDragboard();
        boolean success = false;

        System.out.println("Ho appena droppato qualcosa");

        labelFeedback.setText("PRESA!");

        //TODO mettere qua il fatto che si scrive il pezzo nella strategia

        success = true;

        event.setDropCompleted(success);

        event.consume();
    }

    public void condDragDone(DragEvent event) {
        System.out.println("onDragDone");

        event.consume();
    }

    private List getCondizioneCreatorLabels (){
        CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();
        List<ConditionCreatorLabel> condCreatLabels = new ArrayList<>();
        Map<String,ICondizioneCreator> condCreators = ccc.getCondizioniCreators();
        for (String id: condCreators.keySet()) {
            ICondizioneCreator currentCreator = condCreators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ConditionCreatorLabel ccl = new ConditionCreatorLabel(id,name,description);
            ccl.setText(currentCreator.getName());
            ccl.setDescription(currentCreator.getDescription());
            ccl.setVisible(true);
            //TODO diamogli un colore
            condCreatLabels.add(ccl);
        }
        return condCreatLabels;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List condCLabels = this.getCondizioneCreatorLabels();
        ConditionCreatorLabel currentLabel;

        GridPutter gridPutter = new GridPutter(conditionCreatorGrid);
        for (int i=0; i<condCLabels.size(); i++){
            if (!gridPutter.isFull()){
                gridPutter.put((Node) condCLabels.get(i));
            }
        }
    }
}
