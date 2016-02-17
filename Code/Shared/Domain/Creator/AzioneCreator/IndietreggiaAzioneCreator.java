package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Azioni.IndietreggiaAzione;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class IndietreggiaAzioneCreator implements IAzioneCreator {

    private String idTypeAz;
    private String name;
    private String description;

    private IndietreggiaAzioneCreator() {
        this.name = "Indietreggia";
        this.description = "Quest'azione fa indietreggiare il Tank";
        this.idTypeAz = "002";
    };

    @Override
    public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
        IAzione indietreggiaAzione = new IndietreggiaAzione(this.name,this.description,this.idTypeAz,idAz,valori);
        return indietreggiaAzione;
    }
}
