package Client.UI.JavaFX.View;

import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.UIUtils.GridPutter;
import Client.UI.UIUtils.LabelsMaker;
import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.ICatalogo;
import javafx.event.Event;
import javafx.event.EventHandler;
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
    public Label labelFeedback;
    public GridPane conditionCreatorGrid;
    public GridPane azioneCreatorGrid;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ICatalogo ccc = StartUpHandler.getSingletonInstance().getCatalogoCondCreator();
        ICatalogo cac = StartUpHandler.getSingletonInstance().getCatalogoAzCreator();

        LabelsMaker labelsMaker = new LabelsMaker();

        List condCLabels = labelsMaker.getConditionLabels(ccc);
        ConditionCreatorLabel currentLabel;

        GridPutter gridCondPutter = new GridPutter(conditionCreatorGrid);

        for (int i=0; i<condCLabels.size(); i++){
            if (!gridCondPutter.isFull()){
                currentLabel= (ConditionCreatorLabel)condCLabels.get(i);
                gridCondPutter.put((Node)currentLabel);
                }
        }
    }
}
