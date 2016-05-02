package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Controllers.SimulareBattagliaHandler;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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


        System.out.println("qui");
    }


}
