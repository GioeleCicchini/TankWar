package Shared.Domain.TankDecorator;

import Shared.Domain.ITank;

/**
 * Created by beniamino on 22/03/16.
 */
public abstract class TankDecorator implements ITank{

    private ITank component;

    public TankDecorator(ITank component) {
        this.component = component;
    }

    @Override
    public Integer getLivello() {
        return this.component.getLivello();
    }
}
