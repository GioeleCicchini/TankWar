package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Azioni.SparaAzione;


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

    public String getIdTypeAz() {
        return idTypeAz;
    }

    public void setIdTypeAz(String idTypeAz) {
        this.idTypeAz = idTypeAz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
