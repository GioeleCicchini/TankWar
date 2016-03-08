package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Azioni.LasciaBombaAzione;
import Shared.Domain.Creator.ICreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emanuele on 15/02/16.
 */
public class LasciaBombaAzioneCreator implements ICreator, IAzioneCreator {

    private static LasciaBombaAzioneCreator singletonInstance = null;

    private String idType;
    private String name;
    private String description;

    private LasciaBombaAzioneCreator() {
        this.name = "Lascia una bomba";
        this.description = "Quest'azione fa lasciare una bomba al Tank";
        this.idType = "005";
    }

    ;

    public static LasciaBombaAzioneCreator getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new LasciaBombaAzioneCreator();
        }
        return singletonInstance;
    }

    public IAzione doMakeAzione(String idAz, List<Integer> valori) {
        IAzione lasciaBombaAzione = new LasciaBombaAzione(this.name, this.description, this.idType, idAz, valori);
        return lasciaBombaAzione;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
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

    @Override
    public Map getMap() {
        Map azioneCreator = new HashMap();
        azioneCreator.put("idType", this.idType);
        azioneCreator.put("name", this.name);
        azioneCreator.put("description", this.description);
        return azioneCreator;
    }
}
