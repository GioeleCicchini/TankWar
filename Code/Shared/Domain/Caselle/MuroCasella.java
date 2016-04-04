package Shared.Domain.Caselle;


import Shared.Domain.Caselle.ICasella;
import Shared.Domain.ITank;
import Shared.Domain.Posizione;
import Shared.Util.OrientamentoEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by gioele on 22/03/16.
 */
public class MuroCasella implements ICasella,Serializable {
    private Map caselleVicine = new HashMap< OrientamentoEnum,ICasella>();

    private String id;
    private Posizione posizione;

    public MuroCasella(Posizione posizione) {
        this.posizione = posizione;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

    @Override
    public boolean isDisponibile() {
        return false;
    }

    @Override
    public ITank getTank() {
        return null;
    }

    @Override
    public void setTank(ITank tank) {

    }

    @Override
    public Posizione getPosizione() {
        return posizione;
    }

    @Override
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }
}
