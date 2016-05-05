package Client.UI.JavaFX.View.VEventi;

import Client.UI.JavaFX.View.Runnable;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gioele on 05/05/16.
 */
public class VMovimentoEvento implements VEvento{


    private GridPane CampoBattaglia;

    public VMovimentoEvento(){

    }



    @Override
    public void eseguiti(Map Evento,List<Label> Player) {

        Map tankTurno = (Map)Evento.get("tankTurno");

        for(Label playerLabel : Player){
            if(playerLabel.getId().equals(tankTurno.get("Id"))){
                Map CasellaPosizioneTank = (Map) tankTurno.get("CasellaPosizione");
                int OrientamentoTank = (int) tankTurno.get("Orientamento");
                double OrientamentoGradiTank = 0;
                switch (OrientamentoTank) {
                    case 0:
                        OrientamentoGradiTank= 0;
                        break;
                    case 1:
                        OrientamentoGradiTank= 90;
                        break;
                    case 2:
                        OrientamentoGradiTank= 180;
                        break;
                    case 3:
                        OrientamentoGradiTank = -90;

                }


                playerLabel.setRotate(OrientamentoGradiTank);

                final Map PosizioneTank = (Map) CasellaPosizioneTank.get("Posizione");

                //CampoBattaglia.add(new Button(),1,1);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        CampoBattaglia.getChildren().remove(playerLabel);
                        CampoBattaglia.add(playerLabel,(int)PosizioneTank.get("X"),(int)PosizioneTank.get("Y"));
                        
                    }
                });

            }
        }







    }

    @Override
    public void setGrid(GridPane grid) {
        this.CampoBattaglia = grid;
    }


}
