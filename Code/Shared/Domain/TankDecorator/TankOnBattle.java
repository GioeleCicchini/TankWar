package Shared.Domain.TankDecorator;

import Shared.Domain.ITank;
import Shared.Domain.Strategia;

/**
 * Created by beniamino on 22/03/16.
 */
public class TankOnBattle extends TankDecorator {
    public TankOnBattle(ITank component) {
        super(component);
    }

    @Override
    public void setStrategia(Strategia strategia) {
        
    }
}
