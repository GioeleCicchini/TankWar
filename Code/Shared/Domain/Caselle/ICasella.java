package Shared.Domain.Caselle;

import Shared.Domain.ITank;
import Shared.Domain.Posizione;

/**
 * Created by gioele on 22/03/16.
 */
public interface ICasella {

    String getId();

    void setId(String id);

    public boolean isDisponibile();
    public ITank getTank();
    public void setTank(ITank tank);
    public ITank getBombaTank();
    public void setBombaTank(ITank tank);
    public void togliBombaTank();
    public void togliTank();
    public void setPosizione(Posizione posizione);
    public Posizione getPosizione();
}
