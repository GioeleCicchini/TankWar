package Shared.Domain.Caselle;

import Shared.Domain.ITank;

/**
 * Created by beniamino on 31/03/16.
 */
public class PlainCasella implements ICasella {

    public boolean disponibile = true;

    public ITank tankOccupanteCasella = null;

    public ITank getTank() {
        return tankOccupanteCasella;
    }

    public void setTank(ITank tank) {
        this.tankOccupanteCasella = tank;
        this.disponibile=false;
    }

    @Override
    public boolean isDisponibile() {
        return disponibile;
    }
}
