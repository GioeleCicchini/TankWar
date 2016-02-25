package Client.UI.JavaFX;

import Client.UI.JavaFX.View.CreareStrategia;
import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import com.sun.javafx.fxml.LoadListener;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class TankWarMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/crearestrategia.fxml"));

        primaryStage.setTitle("Hello World");
        /*
        primaryStage.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                CreareStrategia creareStrategia = new CreareStrategia();
                creareStrategia.caricaSchermata();
            }
        });
        */
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);

        StartUpHandler startUpHandler = StartUpHandler.getSingletonInstance();
        startUpHandler.inizia();


        primaryStage.show();
        while (!primaryStage.isShowing()) {
            System.out.println(primaryStage.isShowing());
        }
        CreareStrategia creareStrategia = new CreareStrategia();
        creareStrategia.caricaSchermata();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
