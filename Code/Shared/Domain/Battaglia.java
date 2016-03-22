package Shared.Domain;

/**
 * Created by gioele on 22/03/16.
 */
public class Battaglia {

    private boolean terminata;
    private Tank TankPersonale;
    private Tank TankAvversario;



    public Battaglia(Tank tankPersonale){
        terminata = false;
        this.TankPersonale = tankPersonale;
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
}
