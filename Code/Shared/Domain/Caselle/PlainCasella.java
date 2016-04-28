package Shared.Domain.Caselle;

import Shared.Domain.ITank;
import Shared.Domain.Posizione;

import java.io.Serializable;

/**
 * Created by beniamino on 31/03/16.
 */
public class PlainCasella implements ICasella,Serializable {

    private boolean disponibile = true;
    private Posizione posizione;
    private String id;
    public ITank tankOccupanteCasella = null;
    public ITank bombaTank = null;



    public PlainCasella(){}
    public PlainCasella(Posizione posizione) {
        this.posizione = posizione;
    }

    public ITank getTank() {
        return tankOccupanteCasella;
    }

    public void setTank(ITank tank) {
        this.tankOccupanteCasella = tank;
        this.disponibile=false;
    }

    @Override
    public ITank getBombaTank() {
        return bombaTank;
    }

    @Override
    public void setBombaTank(ITank bombaTank) {
        this.bombaTank = bombaTank;
    }

    @Override
    public void togliBombaTank() {
        this.bombaTank = null;
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

    @Override
    public Posizione getPosizione() {
        return posizione;
    }

    @Override
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }
}
