package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Domain.CampoBattaglia;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gioele on 22/03/16.
 */
public class Battaglia implements Initializable {

    public Button indietroButton;
    public GridPane CampoBattagliaGrid;
    public static double dimensioneCampoCelle = 10;
    public static double dimensioneCampoPixel ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      dimensioneCampoPixel = CampoBattagliaGrid.getPrefWidth();

        for(int i=0; i<dimensioneCampoCelle ; i++){

            ColumnConstraints colonna = new ColumnConstraints();
            colonna.setPercentWidth(100/dimensioneCampoCelle);

            CampoBattagliaGrid.getColumnConstraints().add(colonna);

            RowConstraints riga = new RowConstraints();
            riga.setPercentHeight(100/dimensioneCampoCelle);
            CampoBattagliaGrid.getRowConstraints().add(riga);

        }

        Label Player = new Label();

        Image immagine = new Image("Client/UI/JavaFX/View/Image/tank.png");
        ImageView imageView = new ImageView(immagine);
            imageView.setPreserveRatio(true);
        imageView.setFitHeight(CampoBattagliaGrid.getPrefHeight()/dimensioneCampoCelle-10);


        Player.setGraphic(imageView);
        Player.setPrefHeight(10);
        Player.setPrefWidth(10);

        Player.setPadding(new Insets(0,0,0,(dimensioneCampoPixel/dimensioneCampoCelle)/4));


        CampoBattagliaGrid.add(Player, 5, 5 );



    }









    public void indietro(Event event){
        ViewTransaction.getSingletonInstance().goToHome(indietroButton);

    }
}
