package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Controllers.SimulareBattagliaHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by gioele on 22/03/16.
 */
public class ImpostareBattaglia implements Initializable {
    public VBox StrategieSpace;
    public Label StrategiaSelezionata;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inizio();

    }

    public Button startBattagliaButton;



    public void startBattaglia(Event event) throws IOException {

        SimulareBattagliaHandler simulareBattagliaHandler = SimulareBattagliaHandler.getSingletonInstance();
        simulareBattagliaHandler.iniziaImpostareBattagliaCasuale();
        try {
            simulareBattagliaHandler.impostaBattaglia();

        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }



        ViewTransaction.getSingletonInstance().goToBattaglia(startBattagliaButton);

    }


    public void inizio(){

        List<Map> strategias = SimulareBattagliaHandler.getSingletonInstance().getStrategieList();

        for(final Map strategia : strategias){
            final boolean premuto = false;
            final Button nomeStrategia = new Button((String) strategia.get("nome"));
            nomeStrategia.setPrefHeight(76.0);
            nomeStrategia.setPrefWidth(313.0);
            nomeStrategia.setStyle("-fx-background-color: #F63C1A;-fx-border-width:2px;-fx-border-color:black;");
            StrategieSpace.setMargin(nomeStrategia,new Insets(10,0,0,20));
            nomeStrategia.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(premuto == false) {
                        for(Node ButtonLista : StrategieSpace.getChildren()){
                            ButtonLista.setStyle("-fx-background-color: #F63C1A;-fx-border-width:2px;-fx-border-color:black;");
                        }
                        StrategiaSelezionata.setText((String) strategia.get("nome"));
                        nomeStrategia.setStyle("-fx-background-color: #1AF63C;-fx-border-width:2px;-fx-border-color:black;");
                        SimulareBattagliaHandler.getSingletonInstance().scegliStrategia((String) strategia.get("id"));



                    }


                }
            });

            StrategieSpace.getChildren().add(nomeStrategia);
        }

        System.out.println("qui");
    }


}
