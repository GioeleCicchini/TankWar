package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.AvanzaDestraAzione;
import Shared.Domain.Azioni.IAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class AvanzaDestraAzioneCreator implements IAzioneCreator {

    private static AvanzaDestraAzioneCreator singletonInstance = null;

    private String idTypeAz;
    private String name;
    private String description;

    private AvanzaDestraAzioneCreator() {
        this.name = "Avanza a Destra";
        this.description = "Quest'azione fa avanzare il Tank a destra";
        this.idTypeAz = "001";
    };

    public static AvanzaDestraAzioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new AvanzaDestraAzioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione avanzaDestraAzione = new AvanzaDestraAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return avanzaDestraAzione;
    }
}
