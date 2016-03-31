package Shared.Domain;

import Shared.Domain.StartupBattle.IImpostatoreBattaglia;
import Shared.Domain.StartupBattle.ImpostatoreBattagliaCasuale;
import Shared.Domain.TankDecorator.TankOnBattle;

import java.io.IOException;

/**
 * Created by gioele on 22/03/16.
 */
public class Battaglia {

    private boolean terminata;
    private ITank tankPersonale;
    private ITank tankAvversario;
    private CampoBattaglia campoBattaglia;
    private Turno turno;
    IImpostatoreBattaglia impBattaglia;



    public Battaglia(ITank tankPersonale){
        terminata = false;
        this.tankPersonale = new TankOnBattle(tankPersonale);
    }

    public void setImpostatoreBattagliaCasuale() {
        this.impBattaglia=new ImpostatoreBattagliaCasuale();
    }

    public  Battaglia(){}

    public boolean isTerminata() {
        return terminata;
    }

    public void setTerminata(boolean terminata) {
        this.terminata = terminata;
    }

    public ITank getTankPersonale() {
        return tankPersonale;
    }

    public void setTankPersonale(Tank tankPersonale) {
        this.tankPersonale = new TankOnBattle(tankPersonale);
    }

    public ITank getTankAvversario() {
        return tankAvversario;
    }

    public void setTankAvversario(Tank tankAvversario) {
        this.tankAvversario = new TankOnBattle(tankAvversario);
    }

    public void scegliAvversario() throws IOException {
        tankAvversario=impBattaglia.getAvversario(tankPersonale.getLivello());
    }

    public void creaCampoBattaglia() throws IOException {
        this.campoBattaglia=impBattaglia.getCampoBattaglia(tankPersonale.getLivello());
    }

    public void posizionaTank() {
        this.impBattaglia.posizionaTank(this.tankPersonale,this.tankAvversario,this.campoBattaglia);
    }

    public void impostaTurni() {
        String idTankPersonale = this.tankPersonale.getId();
        String idTankAvversario = this.tankAvversario.getId();
        this.turno = new Turno(idTankPersonale,idTankAvversario);
        String idTankInizio = this.impBattaglia.decidiTurno(idTankPersonale,idTankAvversario);
        this.turno.setaChiTocca(idTankInizio);
    }
}
