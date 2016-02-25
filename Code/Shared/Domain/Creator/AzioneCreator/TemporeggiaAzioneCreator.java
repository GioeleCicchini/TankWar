package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Azioni.TemporeggiaAzione;
import Shared.Domain.Creator.AzioneCreator.IAzioneCreator;

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
