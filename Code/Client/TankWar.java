package Client;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Shared.Domain.Player;
import Shared.Domain.Strategia;
import Shared.Util.DTO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beniamino
 */
public class TankWar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost",6789);


        try{

            ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
            CatalogoCondizioneCreator cc = CatalogoCondizioneCreator.getSingletonInstance();
            ICondizioneCreator stampino = cc.getCondizioneDefaultCreator();
            Strategia strategia = new Strategia(stampino);

            // creo una condizione



            Player player = new Player();
            List<Strategia> strategie = new ArrayList<Strategia>();
            strategie.add(strategia);
            player.setStrategieList(strategie);
            player.setNome("Gioele");


            strategia.setNome("ciao beniamino sono passato al server");
            DTO dto = new DTO();
            dto.setFunzione("Registra");
            dto.aggiungiOggettoPersistente(strategia);
            dto.aggiungiOggettoPersistente(player);
            objectOutput.writeObject(dto);


        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            clientSocket.close();
            System.out.println("Inviato al server");
        }

        Socket clientSocket2 = new Socket("localhost",6789);


    }

}
