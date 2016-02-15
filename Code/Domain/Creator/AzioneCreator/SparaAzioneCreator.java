package Domain.Creator.AzioneCreator;

import Domain.Azioni.IAzione;
import Domain.Azioni.SparaAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class SparaAzioneCreator implements IAzioneCreator {

    private static SparaAzioneCreator singletonInstance = null;

    private String idTypeAz;
    private String name;
    private String description;

    private SparaAzioneCreator() {
        this.name = "Spara";
        this.description = "Il Tank spara nella direzione davanti a se";
        this.idTypeAz = "004";
    };

    public static SparaAzioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new SparaAzioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione sparaAzione = new SparaAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return sparaAzione;
    }
}
