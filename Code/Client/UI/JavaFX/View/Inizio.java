package Client.UI.JavaFX.View;

import Shared.Domain.Controllers.CreareStrategiaHandler;
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

    }

    public void startDemo(Event event) {

        CreareStrategiaHandler.getSingletonInstance().iniziaNuovaStrategia();
        Stage stage;
        Parent root = null;

        stage = (Stage) startButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("../Fxml/crearestrategia.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();


    }
}
