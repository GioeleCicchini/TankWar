package Shared.Domain.Eventi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emanuele on 05/05/16.
 */
public class VittoriaEvento implements IEvento {
    @Override
    public Map getMap() {
        Map evento = new HashMap();
        evento.put("nomeEvento","VittoriaEvento");
        return evento;
    }
}
