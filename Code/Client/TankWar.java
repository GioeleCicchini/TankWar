package Client;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Controllers.CreareStrategiaHandler;
import Shared.Domain.Controllers.StartUpHandler;
import Shared.Domain.Creator.CodizioneCreator.DefaultCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.NemicoAvantiCondizioneCreator;
import Shared.Domain.Creator.ICreator;
import Shared.Domain.ICatalogo;
import Shared.Domain.Player;
import Shared.Util.DTO;
import org.dom4j.io.STAXEventReader;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
       /*     CatalogoCondizioneCreator cc = CatalogoCondizioneCreator.getSingletonInstance();
           ICondizioneCreator stampino = cc.getCondizioneDefaultCreator();
            Strategia strategia = new Strategia(stampino);

            strategia.setNome("ciao beniamino sono passato al server");
            // creo una condizione

            NemicoAvantiCondizioneCreator condizione = NemicoAvantiCondizioneCreator.getSingletonInstance();

            String idCondPadre = strategia.aggiungiCondizione(condizione,new ArrayList<>());
            strategia.aggiungiCondizioneAnnidata(condizione,idCondPadre,new ArrayList<>());
*/


            ICatalogo catalogoCondizioneCreator = StartUpHandler.getSingletonInstance().getCatalogoCondCreator();
            Map<String,ICreator> map = new HashMap<>();

            NemicoAvantiCondizioneCreator nemicoAvantiCondizioneCreator = NemicoAvantiCondizioneCreator.getSingletonInstance();
            DefaultCondizioneCreator defaultCondizioneCreator = DefaultCondizioneCreator.getSingletonInstance();

            map.put("001",nemicoAvantiCondizioneCreator);
            map.put("000",defaultCondizioneCreator);

            catalogoCondizioneCreator.setCreators(map);

            Player player = StartUpHandler.getSingletonInstance().getPlayer();
            player.setNome("Gioele");




            CreareStrategiaHandler handler = CreareStrategiaHandler.getSingletonInstance();
            handler.setCurrentPlayer(player);
            handler.iniziaNuovaStrategia();
            handler.inserisciNomeStrategia("Prima Strategia");
            String idcondpadre = handler.scegliCondizione("001",true,new ArrayList<Integer>());
            handler.scegliCondizioneAnnidata("001",idcondpadre,true,new ArrayList<Integer>());

            DTO dto = new DTO();
            dto.setFunzione("Registra");
            dto.aggiungiOggettoPersistente(player);
            objectOutput.writeObject(dto);


        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            clientSocket.close();
            System.out.println("Inviato al server");
        }




    }

}
