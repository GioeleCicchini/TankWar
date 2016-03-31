package Shared.Domain.Caselle;


import Shared.Domain.Caselle.ICasella;
import Shared.Util.OrientamentoEnum;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by gioele on 22/03/16.
 */
public class MuroCasella implements ICasella {
    private Map caselleVicine = new HashMap< OrientamentoEnum,ICasella>();

    @Override
    public boolean isDisponibile() {
        return false;
    }
}
