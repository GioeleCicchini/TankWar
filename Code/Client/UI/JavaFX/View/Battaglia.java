package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Controllers.SimulareBattagliaHandler;
import Shared.Domain.Strategia;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


import java.net.URL;
import java.util.*;

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


        SimulareBattagliaHandler simulareBattagliaHandler = SimulareBattagliaHandler.getSingletonInstance();

       Map Battaglia = simulareBattagliaHandler.getCampoBattaglia();


        List<HashMap> CampoBat = new ArrayList<HashMap>((List)Battaglia.get("CampoBattaglia"));

        Map[][] campo = new HashMap[10][10];

        for(int i=0;i<(10*10);i++){
            Integer x = i % 10;
            Integer y = (i-x)/10;
            campo[x][y] = CampoBat.get(i);
        }
        for(int i=0; i<dimensioneCampoCelle ; i++){
            ColumnConstraints colonna = new ColumnConstraints();
            colonna.setPercentWidth(100/dimensioneCampoCelle);

            CampoBattagliaGrid.getColumnConstraints().add(colonna);

            RowConstraints riga = new RowConstraints();
            riga.setPercentHeight(100/dimensioneCampoCelle);
            CampoBattagliaGrid.getRowConstraints().add(riga);
        }
        for(int i =0 ; i< 10 ; i++){
            for(int j=0 ; j<10; j++){
                Map elemento = campo[i][j];
                if(elemento.get("Tipo").equals("MuroCasella")){
                    Label Muro = new Label();
                    Muro.setPrefHeight(100);
                    Muro.setPrefWidth(100);
                    Muro.setStyle("-fx-background-color: #000000");


                    CampoBattagliaGrid.add(Muro,i,j);
                }
            }
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

    public void inizio(){
        SimulareBattagliaHandler.getSingletonInstance().iniziaImpostareBattagliaCasuale();
        List<Strategia> strategias = SimulareBattagliaHandler.getSingletonInstance().getStrategieList();


    }

    public void indietro(Event event){
        ViewTransaction.getSingletonInstance().goToHome(indietroButton);

    }
}
