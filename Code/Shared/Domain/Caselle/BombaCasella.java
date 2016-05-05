package Shared.Domain.Caselle;

import Shared.Domain.ITank;
import Shared.Domain.Posizione;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emanuele on 05/05/16.
 */
public class BombaCasella implements ICasella {

    private boolean disponibile = true;
    private Posizione posizione;
    private String id;
    public ITank tankOccupanteCasella = null;
    public ITank bombaTank = null;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isDisponibile() {
        return disponibile;
    }

    @Override
    public ITank getTank() {
        return this.tankOccupanteCasella;
    }

    @Override
    public void setTank(ITank tank) {
        tankOccupanteCasella = tank;
        this.disponibile = false;
    }

    @Override
    public ITank getBombaTank() {
        return bombaTank;
    }

    @Override
    public void setBombaTank(ITank tank) {
        this.bombaTank = tank;
    }

    @Override
    public void togliBombaTank() {
        this.bombaTank = null;
    }

    @Override
    public void togliTank() {
        this.tankOccupanteCasella = null;
        this.disponibile = true;
    }

    @Override
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    @Override
    public Posizione getPosizione() {
        return posizione;
    }

    @Override
    public Map getMap() {
        Map casella = new HashMap();
        casella.put("Id",this.id);
        casella.put("Posizione",this.posizione.getMap());
        casella.put("Disponibile",this.disponibile);
        casella.put("Tipo","BombaCasella");
        if(this.tankOccupanteCasella != null) {
            casella.put("tankOccupanteCasella", this.tankOccupanteCasella.getId());
        }
        else{
            casella.put("tankOccupanteCasella", null);
        }
        if(this.bombaTank != null) {
            casella.put("bombaTank", this.bombaTank.getId());
        }
        else{
            casella.put("bombaTank", null);
        }
        return casella;
    }
}
