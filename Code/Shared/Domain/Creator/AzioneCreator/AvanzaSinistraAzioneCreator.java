package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.AvanzaSinistraAzione;
import Shared.Domain.Azioni.IAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class AvanzaSinistraAzioneCreator implements IAzioneCreator {

    private static AvanzaSinistraAzioneCreator singletonInstance = null;

    private String idTypeAz;
    private String name;
    private String description;

    private AvanzaSinistraAzioneCreator() {
        this.name = "Avanza a Sinistra";
        this.description = "Quest'azione fa avanzare il Tank a sinistra";
        this.idTypeAz = "003";
    };

    public static AvanzaSinistraAzioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new AvanzaSinistraAzioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione avanzaSinistraAzione = new AvanzaSinistraAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return avanzaSinistraAzione;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
