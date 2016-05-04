package Shared.Domain.Eventi;

import Shared.Domain.Caselle.ICasella;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emanuele on 04/05/16.
 */
public class SparaEvento implements IEvento {

    private List<ICasella> casellePropagazione = new ArrayList<>();
    private ICasella casellaTank;

    public SparaEvento(List casellePropagazione,ICasella casellaTank) {
        this.casellePropagazione = casellePropagazione;
        this.casellaTank = casellaTank;
    }

    @Override
    public Map getMap() {
        Map evento = new HashMap();
        List caselleCorrenti = new ArrayList<>();
        for (ICasella c : this.casellePropagazione) {
            caselleCorrenti.add(c);
        }
        evento.put("casellePropagazione",caselleCorrenti);
        if (casellaTank != null) {
            evento.put("casellaTank",casellaTank.getMap());
        } else {
            evento.put("casellaTank",null);
        }
        evento.put("nomeEvento","SparaEvento");
        return evento;
    }
}
