package Shared.Domain.TankDecorator;

import Shared.Domain.ITank;

/**
 * Created by beniamino on 22/03/16.
 */
public class TankOnBattle extends TankDecorator {
    public TankOnBattle(ITank component) {
        super(component);
    }
}
