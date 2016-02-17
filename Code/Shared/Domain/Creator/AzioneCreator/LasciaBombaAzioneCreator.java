package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Azioni.LasciaBombaAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class LasciaBombaAzioneCreator implements IAzioneCreator {

    private static LasciaBombaAzioneCreator singletonInstance = null;

    private String idTypeAz;
    private String name;
    private String description;

    private LasciaBombaAzioneCreator() {
        this.name = "Lascia una bomba";
        this.description = "Quest'azione fa lasciare una bomba al Tank";
        this.idTypeAz = "005";
    };

    public static LasciaBombaAzioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new LasciaBombaAzioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione lasciaBombaAzione = new LasciaBombaAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return lasciaBombaAzione;
    }
}
