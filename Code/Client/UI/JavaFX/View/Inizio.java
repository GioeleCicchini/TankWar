package Client.UI.JavaFX.View;

import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.Player;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by beniamino on 03/03/16.
 */
public class Inizio implements Initializable {
    public Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO sta qua solo provvisoriamente, verrà chiamato da un handler precedente
        Player player = StartUpHandler.getSingletonInstance().getPlayer();
        CreareStrategiaHandler.getSingletonInstance().setCurrentPlayer(player);//TODO anche questo non va qua
        CreareStrategiaHandler.getSingletonInstance().iniziaNuovaStrategia();
    }

    public void startDemo(Event event) {
        Stage stage;
        Parent root = null;

        stage=(Stage)startButton.getScene().getWindow();
        try {
            root= FXMLLoader.load(getClass().getResource("../Fxml/crearestrategia.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();


    }
}
