package Shared.Domain.StartupBattle;

import Shared.Domain.CampoBattaglia;
import Shared.TecnicalService.Fondation.ConcreteRemoteService;
import Shared.Util.DTO;
import Shared.Util.DTOMaker;

import java.io.IOException;

/**
 * Created by gioele on 22/03/16.
 */
public class RandomCampoBattagliaGenerator implements  IGeneratoreCampoBattaglia {

    public CampoBattaglia getCampoBattaglia(Integer livello) throws IOException {
        CampoBattaglia campoBattaglia;

        ConcreteRemoteService service = ConcreteRemoteService.getSingletonInstance();
        DTOMaker dtoMaker = DTOMaker.getSingletonInstance();

        DTO risp = (DTO) service.RichiediAlServer(dtoMaker.getCampoBattagliaRandomDTO(livello));

        if (risp.getFunzione().equals("CampoBattagliaTrovato")) {
            campoBattaglia = (CampoBattaglia) risp.getOggettiTrasferimento().get(0);
            System.out.println("Campo Battaglia Ricevuto");
        }
        else {
            throw new NullPointerException("Campo Battaglia non trovato");
        }

        return campoBattaglia;
    }

}
