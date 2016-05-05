package Shared.Domain.Eventi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emanuele on 05/05/16.
 */
public class InCorsoEvento implements IEvento {
    @Override
    public Map getMap() {
        Map evento = new HashMap();
        evento.put("nomeEvento","InCorsoEvento");
        return evento;
    }
}
