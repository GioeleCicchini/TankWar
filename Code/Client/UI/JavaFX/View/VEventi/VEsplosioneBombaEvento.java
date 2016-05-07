package Client.UI.JavaFX.View.VEventi;

import Client.UI.JavaFX.View.Runnable;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Map;

/**
 * Created by Gioele on 07/05/2016.
 */
public class VEsplosioneBombaEvento implements VEvento {


    GridPane CampoBattaglia;
    Map tankPersonale;
    Map tankAvversario;

    public static double dimensioneCampoCelle ;
    public static double dimensioneCampoPixel ;

    @Override
    public void eseguiti(Map Evento, List<Label> Player) throws InterruptedException {

        Map casellaEsplosa = (Map)Evento.get("casellaEsplosa");
        String idTankOccupanteCasellaEsplosa = (String)casellaEsplosa.get("tankOccupanteCasella");
        Map posizioneTankEsploso = (Map)casellaEsplosa.get("Posizione");

        for(final Label PlayerCorrente : Player){
            if(PlayerCorrente.getId().equals(idTankOccupanteCasellaEsplosa)){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        PlayerCorrente.setGraphic(getTankEsploso());
                    }
                });

            }
        }

    }


    private ImageView getTankEsploso(){
        Image immagineTankEsploso = new Image("Client/UI/JavaFX/View/Image/TankEsploso.png");
        ImageView imageView = new ImageView(immagineTankEsploso);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(dimensioneCampoPixel/dimensioneCampoCelle-10);

        return imageView;
    }


    public void setGrid(GridPane grid) {
        this.CampoBattaglia = grid;
    }

    @Override
    public void setParametriGui(List<Node> Parametri) {
        setGrid((GridPane)Parametri.get(0));
    }

    @Override
    public void setTankOnBattleGui(Map tankOnBattleGui) {
        this.tankPersonale = (Map)tankOnBattleGui.get("TankPersonale");
        this.tankAvversario = (Map)tankOnBattleGui.get("TankAvversario");

    }


    @Override
    public void setDimesioneCampo(Map dimesioneCampo) {
        dimensioneCampoCelle = (Double) dimesioneCampo.get("dimensioneCampoCelle");
        dimensioneCampoPixel = (Double) dimesioneCampo.get("dimensioneCampoPixel");
    }

}
