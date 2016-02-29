package Client.UI.JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TankWarMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/crearestrategia.fxml"));

        primaryStage.setTitle("Tank War");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root));


        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
