package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import Shared.Controllers.SimulareBattagliaHandler;
import Shared.Domain.Strategia;
import javafx.application.Platform;
import javafx.concurrent.Task;
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
import org.hibernate.annotations.SourceType;


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
    public Label label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      dimensioneCampoPixel = CampoBattagliaGrid.getPrefWidth();


        SimulareBattagliaHandler simulareBattagliaHandler = SimulareBattagliaHandler.getSingletonInstance();


        //QUI INIZIA IL SETTAGGIO DELLA GRAFICA

       Map Battaglia = simulareBattagliaHandler.getCampoBattaglia();

        Map CampoBattaglia = (Map)Battaglia.get("CampoBattaglia");

        List<HashMap> CampoBat = new ArrayList<HashMap>((List)CampoBattaglia.get("CampoBattaglia"));

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

        // Creazione 1 Player
        Label PlayerCorrente = new Label();
        Image immagine = new Image("Client/UI/JavaFX/View/Image/tank.png");
        ImageView imageView = new ImageView(immagine);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(CampoBattagliaGrid.getPrefHeight()/dimensioneCampoCelle-10);

        PlayerCorrente.setGraphic(imageView);
        PlayerCorrente.setPrefHeight(10);
        PlayerCorrente.setPrefWidth(10);

        PlayerCorrente.setPadding(new Insets(0,0,0,(dimensioneCampoPixel/dimensioneCampoCelle)/4));

        // Creazione Secondo Player

        Label PlayerAvversario = new Label();
        Image immagineAvversario = new Image("Client/UI/JavaFX/View/Image/tankAvversario.png");
        ImageView imageViewAvversario = new ImageView(immagineAvversario);
        imageViewAvversario.setPreserveRatio(true);
        imageViewAvversario.setFitHeight(CampoBattagliaGrid.getPrefHeight()/dimensioneCampoCelle-10);

        PlayerAvversario.setGraphic(imageViewAvversario);
        PlayerAvversario.setPrefHeight(10);
        PlayerAvversario.setPrefWidth(10);

        PlayerAvversario.setPadding(new Insets(0,0,0,(dimensioneCampoPixel/dimensioneCampoCelle)/4));

        // Posizionamento Tank

        Map TankPersonale = (Map)Battaglia.get("TankPersonale");
        Map CasellaPosizioneTankPersonale = (Map)TankPersonale.get("CasellaPosizione");
        int OrientamentoTankPersonale = (int)TankPersonale.get("Orientamento");
        double OrientamentoGradiTankPersonale = 0;
        switch (OrientamentoTankPersonale) {
            case 0: OrientamentoGradiTankPersonale = 0 ;
                break;
            case 1: OrientamentoGradiTankPersonale = 90;
                break;
            case 2: OrientamentoGradiTankPersonale = 180;
                break;
            case 3: OrientamentoGradiTankPersonale = -90;

        }
        PlayerCorrente.setRotate(OrientamentoGradiTankPersonale);

        Map PosizioneTankPersonale = (Map)CasellaPosizioneTankPersonale.get("Posizione");



        Map TankAvversario = (Map)Battaglia.get("TankAvversario");
        Map CasellaPosizioneTankAvversario = (Map)TankAvversario.get("CasellaPosizione");
        int OrientamentoTankAvversario = (int)TankAvversario.get("Orientamento");
        double OrientamentoGradiTankAvversario = 0;
        switch (OrientamentoTankAvversario) {
            case 0: OrientamentoGradiTankAvversario = 0 ;
                break;
            case 1: OrientamentoGradiTankAvversario = 90;
                break;
            case 2: OrientamentoGradiTankAvversario= 180;
                break;
            case 3: OrientamentoGradiTankAvversario= -90;

        }
        PlayerAvversario.setRotate(OrientamentoGradiTankAvversario);

        Map PosizioneTankAvversario = (Map)CasellaPosizioneTankAvversario.get("Posizione");


        System.out.println(PosizioneTankPersonale.get("X")+"  "+PosizioneTankPersonale.get("Y"));

        CampoBattagliaGrid.add(PlayerCorrente, (int)PosizioneTankPersonale.get("X"), (int)PosizioneTankPersonale.get("Y"));
        CampoBattagliaGrid.add(PlayerAvversario, (int)PosizioneTankAvversario.get("X"), (int)PosizioneTankAvversario.get("Y"));





        //QUI FINISCE IL SETTAGGIO GRAFICA

        //Si battaglia ragazzi
        Integer i=0;


        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                int i = 0;
                while (true) {
                    final int finalI = i;


                    SimulareBattagliaHandler.getSingletonInstance().faiMossa();

                    Map BattagliaThread = simulareBattagliaHandler.getCampoBattaglia();


                    Map TankPersonaleThread = (Map)BattagliaThread.get("TankPersonale");
                    Map  CasellaPosizioneTankPersonaleThread = (Map)TankPersonaleThread.get("CasellaPosizione");
                    int OrientamentoTankPersonaleThread = (int)TankPersonaleThread.get("Orientamento");
                    double OrientamentoGradiTankPersonaleThread = 0;
                    switch (OrientamentoTankPersonaleThread) {
                        case 0: OrientamentoGradiTankPersonaleThread = 0 ;
                            break;
                        case 1: OrientamentoGradiTankPersonaleThread = 90;
                            break;
                        case 2: OrientamentoGradiTankPersonaleThread = 180;
                            break;
                        case 3: OrientamentoGradiTankPersonaleThread = -90;

                    }


                    PlayerCorrente.setRotate(OrientamentoGradiTankPersonaleThread);

                    final Map PosizioneTankPersonaleThread = (Map)CasellaPosizioneTankPersonaleThread.get("Posizione");



                    Map TankAvversarioThread = (Map)BattagliaThread.get("TankAvversario");
                    Map CasellaPosizioneTankAvversarioThread = (Map)TankAvversarioThread.get("CasellaPosizione");
                    int OrientamentoTankAvversarioThread = (int)TankAvversarioThread.get("Orientamento");
                    double OrientamentoGradiTankAvversarioThread = 0;
                    switch (OrientamentoTankAvversarioThread) {
                        case 0: OrientamentoGradiTankAvversarioThread = 0 ;
                            break;
                        case 1: OrientamentoGradiTankAvversarioThread = 90;
                            break;
                        case 2: OrientamentoGradiTankAvversarioThread= 180;
                            break;
                        case 3: OrientamentoGradiTankAvversarioThread= -90;

                    }
                    PlayerAvversario.setRotate(OrientamentoGradiTankAvversarioThread);

                    Map PosizioneTankAvversarioThread = (Map)CasellaPosizioneTankAvversarioThread.get("Posizione");




                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            label.setText("" + finalI);

                            System.out.println( (int)PosizioneTankPersonaleThread.get("X")+" "+ (int)PosizioneTankPersonaleThread.get("Y"));
                            CampoBattagliaGrid.add(PlayerCorrente, (int)PosizioneTankPersonaleThread.get("X"), (int)PosizioneTankPersonaleThread.get("Y"));
                            CampoBattagliaGrid.add(PlayerAvversario, (int)PosizioneTankAvversarioThread.get("X"), (int)PosizioneTankAvversarioThread.get("Y"));
                           // CampoBattagliaGrid.getChildren().remove(PlayerCorrente);
                           // CampoBattagliaGrid.getChildren().remove(PlayerAvversario);



                        }
                    });
                    i++;
                    Thread.sleep(1000);


                    /*
                    CampoBattagliaGrid.add(PlayerCorrente, (int)PosizioneTankPersonaleThread.get("X"), (int)PosizioneTankPersonaleThread.get("Y"));



*/

                }
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();


/*

        while (!SimulareBattagliaHandler.getSingletonInstance().isFinita()){




            CampoBattagliaGrid.getChildren().remove(PlayerCorrente);
            CampoBattagliaGrid.getChildren().remove(PlayerAvversario);


           SimulareBattagliaHandler.getSingletonInstance().faiMossa();


            i++;


            // Aggiornare Parte Grafica

            // elimino i tank del turno precedente




            Battaglia = simulareBattagliaHandler.getCampoBattaglia();


            TankPersonale = (Map)Battaglia.get("TankPersonale");
            CasellaPosizioneTankPersonale = (Map)TankPersonale.get("CasellaPosizione");
            OrientamentoTankPersonale = (int)TankPersonale.get("Orientamento");
            OrientamentoGradiTankPersonale = 0;
            switch (OrientamentoTankPersonale) {
                case 0: OrientamentoGradiTankPersonale = 0 ;
                    break;
                case 1: OrientamentoGradiTankPersonale = 90;
                    break;
                case 2: OrientamentoGradiTankPersonale = 180;
                    break;
                case 3: OrientamentoGradiTankPersonale = -90;

            }
            PlayerCorrente.setRotate(OrientamentoGradiTankPersonale);

           PosizioneTankPersonale = (Map)CasellaPosizioneTankPersonale.get("Posizione");



            TankAvversario = (Map)Battaglia.get("TankAvversario");
            CasellaPosizioneTankAvversario = (Map)TankAvversario.get("CasellaPosizione");
             OrientamentoTankAvversario = (int)TankAvversario.get("Orientamento");
            OrientamentoGradiTankAvversario = 0;
            switch (OrientamentoTankAvversario) {
                case 0: OrientamentoGradiTankAvversario = 0 ;
                    break;
                case 1: OrientamentoGradiTankAvversario = 90;
                    break;
                case 2: OrientamentoGradiTankAvversario= 180;
                    break;
                case 3: OrientamentoGradiTankAvversario= -90;

            }
            PlayerAvversario.setRotate(OrientamentoGradiTankAvversario);

            PosizioneTankAvversario = (Map)CasellaPosizioneTankAvversario.get("Posizione");

            CampoBattagliaGrid.add(PlayerCorrente, (int)PosizioneTankPersonale.get("X"), (int)PosizioneTankPersonale.get("Y"));
            CampoBattagliaGrid.add(PlayerAvversario, (int)PosizioneTankAvversario.get("X"), (int)PosizioneTankAvversario.get("Y"));


        }

*/


    }

    public void inizio(){
        SimulareBattagliaHandler.getSingletonInstance().iniziaImpostareBattagliaCasuale();
        List<Strategia> strategias = SimulareBattagliaHandler.getSingletonInstance().getStrategieList();


    }

    public void indietro(Event event){
        ViewTransaction.getSingletonInstance().goToHome(indietroButton);

    }
}
