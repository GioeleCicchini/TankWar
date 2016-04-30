package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Controllers.SimulareBattagliaHandler;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gioele on 22/03/16.
 */
public class ImpostareBattaglia implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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


        System.out.println("Sono qui inizio");



        ViewTransaction.getSingletonInstance().goToBattaglia(startBattagliaButton);

    }


}
