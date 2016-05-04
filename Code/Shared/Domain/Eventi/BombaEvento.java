package Shared.Domain.Eventi;

import Shared.Domain.Caselle.ICasella;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emanuele on 04/05/16.
 */
public class BombaEvento implements IEvento {

    private ICasella casellaEsplosa;

    public BombaEvento(ICasella casellaEsplosa) {
        this.casellaEsplosa = casellaEsplosa;
    }

    @Override
    public Map getMap() {
        Map evento = new HashMap();
        evento.put("casellaEsplosa",this.casellaEsplosa.getMap());
        evento.put("nomeEvento","BombaEvento");
        return evento;
    }
}
