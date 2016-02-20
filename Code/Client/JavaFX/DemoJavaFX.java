package Client.JavaFX;/**
 * Created by beniamino on 19/02/16.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DemoJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prova form");
        primaryStage.show();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text scenetitle = new Text("Benvenuto");
        scenetitle.setFont(Font.font("Thaoma", FontWeight.NORMAL,20));
        grid.add(scenetitle,0,0,2,1);

        Label username = new Label("Nome utente:");
        grid.add(username,0,1);

        TextField userTextField = new TextField();
        grid.add(userTextField,1,1);

        Label pw = new Label("Password:");
        grid.add(pw,0,2);
        PasswordField pwbox = new PasswordField();
        grid.add(pwbox,1,2);

        Button btn = new Button("Login");

        HBox hbBtn = new HBox(10);

        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);

        grid.add(hbBtn,1,4);

        final Text actionTarget = new Text();
        grid.add(actionTarget,1,6);

        Scene scene = new Scene(grid,300,275);
        primaryStage.setScene(scene);

        //agiungere un evento
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Pulsante login premuto");
            }
        });
    }
}
