package Shared.Domain.TankDecorator;

import Shared.Domain.Caselle.ICasella;
import Shared.Domain.ITank;
import Shared.Domain.Strategia;
import Shared.Domain.Tank;

/**
 * Created by beniamino on 22/03/16.
 */
public class TankOnBattle extends TankDecorator {

    private ICasella casellaPosizione;

    public TankOnBattle(ITank component) {
        super(component);
    }

    @Override
    public void setStrategia(Strategia strategia) {

    }

    @Override
    public Strategia getStrategia() {
        return null;
    }

    @Override
    public ITank getTank() {
        return null;
    }

    @Override
    public void setTank(Tank tank) {

    }

    @Override
    public Integer getLivello() {
        return super.getLivello();
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public ICasella getCasellaPosizione() {
        return casellaPosizione;
    }

    @Override
    public void setCasellaPosizione(ICasella casellaPosizione) {
        this.casellaPosizione = casellaPosizione;
    }

}
