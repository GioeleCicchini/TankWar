package Domain.Creator.AzioneCreator;

import Domain.Azioni.IAzione;
import Domain.Azioni.TemporeggiaAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class TemporeggiaAzioneCreator implements IAzioneCreator {

    private static TemporeggiaAzioneCreator singletonInstance = null;

    private String idTypeAz;
    private String name;
    private String description;

    private TemporeggiaAzioneCreator() {
        this.name = "Temporeggia";
        this.description = "Quest'azione fa passare un turno senza eseguire nulla al Tank";
        this.idTypeAz = "006";
    };

    public static TemporeggiaAzioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new TemporeggiaAzioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione temporeggiaAzione = new TemporeggiaAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return temporeggiaAzione;
    }
}
