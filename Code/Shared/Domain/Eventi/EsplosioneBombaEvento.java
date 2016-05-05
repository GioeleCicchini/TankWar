package Shared.Domain.Eventi;

import Shared.Domain.Caselle.ICasella;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emanuele on 05/05/16.
 */
public class EsplosioneBombaEvento implements IEvento {

    private ICasella casellaEsplosa;

    public EsplosioneBombaEvento(ICasella casellaEsplosa) {
        this.casellaEsplosa = casellaEsplosa;
    }

    @Override
    public Map getMap() {
        Map evento = new HashMap();
        evento.put("casellaEsplosa",this.casellaEsplosa.getMap());
        evento.put("nomeEvento","EsplosioneBombaEvento");
        return evento;
    }
}
