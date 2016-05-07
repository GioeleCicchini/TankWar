package Client.UI.JavaFX.View.VEventi;

import Client.UI.JavaFX.View.Runnable;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Map;

/**
 * Created by Gioele on 07/05/2016.
 */
public class VPareggioEvento implements VEvento {

    private GridPane CampoBattaglia;
    private Label RisultatoLabel;




    @Override
    public void eseguiti(Map Evento, List<Label> Player) throws InterruptedException {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                RisultatoLabel.setText("Pareggio");
            }
        });


    }

    public void setGrid(GridPane grid) {
        this.CampoBattaglia = grid;
    }
    public  void setLabelRisultato(Label label){this.RisultatoLabel = label;}

    @Override
    public void setParametriGui(List<Node> Parametri) {
        setGrid((GridPane)Parametri.get(0));
        setLabelRisultato((Label)Parametri.get(2));

    }

    @Override
    public void setTankOnBattleGui(Map tankOnBattleGui) {

    }

    @Override
    public void setDimesioneCampo(Map dimesioneCampo) {

    }

}
