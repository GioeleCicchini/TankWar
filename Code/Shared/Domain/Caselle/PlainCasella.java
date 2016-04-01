package Shared.Domain.Caselle;

import Shared.Domain.ITank;

import java.io.Serializable;

/**
 * Created by beniamino on 31/03/16.
 */
public class PlainCasella implements ICasella,Serializable {

    public boolean disponibile = true;

    private String id;
    public ITank tankOccupanteCasella = null;

    public ITank getTank() {
        return tankOccupanteCasella;
    }

    public void setTank(ITank tank) {
        this.tankOccupanteCasella = tank;
        this.disponibile=false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id= id;
    }

    @Override
    public boolean isDisponibile() {
        return disponibile;
    }
}
