package Client.UI.JavaFX.View;

import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.Player;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gioele on 05/03/2016.
 */
public class Login implements Initializable {

    @FXML
    TextField Username;
    @FXML
    TextField Password;
    @FXML
    Button LoginButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void EseguiLogin(Event event) throws IOException {
        Stage stage;
        Parent root = null;


        Player player = StartUpHandler.getSingletonInstance().getPlayer(Username.getText(), Password.getText());

        System.out.println(player.getNome());

        CreareStrategiaHandler.getSingletonInstance().setCurrentPlayer(player);


        stage = (Stage) LoginButton.getScene().getWindow();
        try {
            System.out.println("Qui");
            root = FXMLLoader.load(getClass().getResource("../Fxml/inizio.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();


    }
}
