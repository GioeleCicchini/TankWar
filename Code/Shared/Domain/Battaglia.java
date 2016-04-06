package Shared.Domain;

import Shared.Domain.StartupBattle.IImpostatoreBattaglia;
import Shared.Domain.StartupBattle.ImpostatoreBattagliaCasuale;
import Shared.Domain.TankDecorator.TankOnBattle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private String risultato = "in corso";



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
        try{  tankAvversario=impBattaglia.getAvversario(tankPersonale.getLivello());
        }catch (NullPointerException e){
            throw new NullPointerException("Tank avversario non trovato");
        }

    }

    public void creaCampoBattaglia() throws IOException {
        try {
            this.campoBattaglia=impBattaglia.getCampoBattaglia(tankPersonale.getLivello());
        }catch (NullPointerException e){
            throw new NullPointerException("Campo Battaglia non trovato");
        }


    }

    public void posizionaTank() {
        this.impBattaglia.posizionaTank(this.tankPersonale,this.tankAvversario,this.campoBattaglia);
    }

    public void impostaTurni() {
        String idTankPersonale = this.tankPersonale.getId();
        String idTankAvversario = this.tankAvversario.getId();
        this.turno = new Turno(idTankPersonale,idTankAvversario,500);//todo questo 500 diverrà flessibile?
        String idTankInizio = this.impBattaglia.decidiTurno(idTankPersonale,idTankAvversario);
        this.turno.setaChiTocca(idTankInizio);
    }

    public void faiMossa(){
        String idAChiTocca = turno.aChiTocca();
        List<ITank> partecipanti = new ArrayList<>();
        partecipanti.add(tankPersonale);
        partecipanti.add(tankAvversario);
        //TODO Nota: occorrerrebbe una estensione al caso con più di 2 giocatori
        ITank tankAttuale;
        ITank tankAltro;
        if (idAChiTocca.equals(tankPersonale.getId())){
            tankAttuale=tankPersonale;
            tankAltro=tankAvversario;
        }
        else {
            tankAttuale=tankAvversario;
            tankAltro=tankPersonale;
        }
        tankAttuale.faiMossa(tankAltro,campoBattaglia);
        if (tankAvversario.seiMorto()){
            risultato="vittoria";
            terminata=true;
        }
        if (tankPersonale.seiMorto()){
            risultato="sconfitta";
            terminata=true;
        }
        if (turno.isFinitaPartita()){
            risultato="pareggio";
            terminata=true;
        }

    }

    public void getState(){

    }
}
