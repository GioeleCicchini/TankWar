package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Azioni.IndietreggiaAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class IndietreggiaAzioneCreator implements IAzioneCreator {

    private static IndietreggiaAzioneCreator singletonInstance = null;

    private String idTypeAz;
    private String name;
    private String description;

    private IndietreggiaAzioneCreator() {
        this.name = "Indietreggia";
        this.description = "Quest'azione fa indietreggiare il Tank";
        this.idTypeAz = "002";
    };

    public static IndietreggiaAzioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new IndietreggiaAzioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione indietreggiaAzione = new IndietreggiaAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return indietreggiaAzione;
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
