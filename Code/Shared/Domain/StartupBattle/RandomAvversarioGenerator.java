package Shared.Domain.StartupBattle;

import Shared.Domain.ITank;
import Shared.Domain.Player;
import Shared.Domain.Tank;
import Shared.TecnicalService.Fondation.ConcreteRemoteService;
import Shared.Util.DTO;
import Shared.Util.DTOMaker;

import java.io.IOException;


/**
 * Created by gioele on 22/03/16.
 */
public class RandomAvversarioGenerator implements  IGeneratoreAvversario {

    public ITank getAvversario(Integer livello) throws IOException {
        ITank tank;

        ConcreteRemoteService service = ConcreteRemoteService.getSingletonInstance();
        DTOMaker dtoMaker = DTOMaker.getSingletonInstance();

        DTO risp = (DTO) service.RichiediAlServer(dtoMaker.getPlayerAvversarioRandomDTO(livello));

        if (risp.getFunzione().equals("TankTrovato")) {
            tank = (ITank) risp.getOggettiPersistenti().get(0);
            System.out.println("Tank Ricevuto");
        }
        else {
            throw new NullPointerException("Tank non trovato");
        }

        return tank;
    }
}
