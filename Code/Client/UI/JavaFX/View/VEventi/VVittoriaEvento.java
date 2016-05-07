package Client.UI.JavaFX.View.VEventi;

import Client.UI.JavaFX.View.Runnable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

import java.util.List;
import java.util.Map;

/**
 * Created by Gioele on 07/05/2016.
 */
public class VVittoriaEvento implements VEvento {

    private GridPane CampoBattaglia;
    private Label RisultatoLabel;
    private HBox RisultatoHbox;




    @Override
    public void eseguiti(Map Evento, List<Label> Player) throws InterruptedException {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                RisultatoLabel.setText("Hai Vinto");

                RisultatoHbox.getChildren().add(getButtonSimulaPartite());



            }
        });


    }

    private Button getButtonSimulaPartite(){

        Button button = new Button("Simula 100 Partite");
        button.setStyle("-fx-background-color: #1B5E20; -fx-text-fill:white;-fx-font-size: 37px;");
        button.setPrefHeight(127);
        button.setPrefWidth(400);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Qui ci va il codice per simulare le 100 partite!





            }
        });


        return button;
    }

    private void setGrid(GridPane grid) {
        this.CampoBattaglia = grid;
    }
    private void setLabelRisultato(Label label){this.RisultatoLabel = label;}
    private void setRisultatoHbox(HBox hbox){this.RisultatoHbox = hbox;}

    @Override
    public void setParametriGui(List<Node> Parametri) {
            setGrid((GridPane)Parametri.get(0));
        setLabelRisultato((Label)Parametri.get(2));
        setRisultatoHbox((HBox)Parametri.get(3));
    }

    @Override
    public void setTankOnBattleGui(Map tankOnBattleGui) {

    }

    @Override
    public void setDimesioneCampo(Map dimesioneCampo) {

    }
}