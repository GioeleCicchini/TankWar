package Shared.Domain;

import Shared.Domain.StartupBattle.IImpostatoreBattaglia;
import Shared.Domain.StartupBattle.ImpostatoreBattagliaCasuale;

import java.io.IOException;

/**
 * Created by gioele on 22/03/16.
 */
public class Battaglia {

    private boolean terminata;
    private Tank TankPersonale;
    private Tank TankAvversario;

    IImpostatoreBattaglia impBattaglia;



    public Battaglia(Tank tankPersonale){
        terminata = false;
        this.TankPersonale = tankPersonale;
        impBattaglia=new ImpostatoreBattagliaCasuale();
    }

    public  Battaglia(){}

    public boolean isTerminata() {
        return terminata;
    }

    public void setTerminata(boolean terminata) {
        this.terminata = terminata;
    }

    public Tank getTankPersonale() {
        return TankPersonale;
    }

    public void setTankPersonale(Tank tankPersonale) {
        TankPersonale = tankPersonale;
    }

    public Tank getTankAvversario() {
        return TankAvversario;
    }

    public void setTankAvversario(Tank tankAvversario) {
        TankAvversario = tankAvversario;
    }

    public void scegliAvversario(String livello) throws IOException {
        impBattaglia.getAvversario(livello);
    }
}
