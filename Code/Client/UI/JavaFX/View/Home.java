package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Controllers.CreareStrategiaHandler;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by beniamino on 03/03/16.
 */
public class Home implements Initializable {
    public Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startDemo(Event event) {

        CreareStrategiaHandler.getSingletonInstance().iniziaNuovaStrategia();

        ViewTransaction.getSingletonInstance().goToCreareStrategia(startButton);


    }
}
