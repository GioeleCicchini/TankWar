package Client.UI.JavaFX.View.VEventi;

import Client.UI.JavaFX.View.Runnable;
import Shared.Domain.CampoBattaglia;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

/**
 * Created by gioele on 05/05/16.
 */
public class VPiazzamentoBombaEvento implements VEvento {

    GridPane CampoBattaglia;

    @Override
    public void eseguiti(Map Evento, List<Label> Player) {

        Map casella = (Map)Evento.get("casella");
        Map PosizioneCasella = (Map) casella.get("Posizione");

        Label Bomba = new Label();
        Bomba.setStyle("-fx-background-color: green");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                CampoBattaglia.add(Bomba,(int)PosizioneCasella.get("X"),(int)PosizioneCasella.get("Y"));
            }
        });


    }

    public void setGrid(GridPane grid) {
        this.CampoBattaglia = grid;
    }

    @Override
    public void setParametriGui(List<Node> Parametri) {
        setGrid((GridPane)Parametri.get(0));

    }
}
