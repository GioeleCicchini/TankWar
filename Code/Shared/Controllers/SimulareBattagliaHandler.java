package Shared.Controllers;


import Shared.Domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gioele on 22/03/16.
 */
public class SimulareBattagliaHandler {
    private static SimulareBattagliaHandler singletonInstance = null;

    public static SimulareBattagliaHandler getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SimulareBattagliaHandler();
        }
        return singletonInstance;
    }



    private Player playerLoggato;
    private Battaglia battaglia = null;

    private SimulareBattagliaHandler() {
        this.playerLoggato = LoginHandler.getSingletonInstance().getPlayer();
    }



    public void iniziaImpostareBattagliaCasuale(){
        ITank tankPersonale = playerLoggato.getTank();
        this.battaglia = new Battaglia(tankPersonale);
        this.battaglia.setImpostatoreBattagliaCasuale();
        this.battaglia.posizionaTank();
        this.battaglia.impostaTurni();
    }

    public void impostaBattaglia() throws IOException {
        battaglia.scegliAvversario();
        battaglia.creaCampoBattaglia();
    }

    public void faiMossa(){
        if (!battaglia.isTerminata()){
            battaglia.faiMossa();
        }
    }

    public void getState(){
        battaglia.getState();
    }

    public Player getPlayerLoggato() {
        return playerLoggato;
    }

    public void setPlayerLoggato(Player playerLoggato) {
        playerLoggato = playerLoggato;
    }

    public void scegliStrategia(String idStrategia) {
        this.playerLoggato.scegliStrategia(idStrategia);
    }

    public List getStrategieList() {
        List<Strategia> strategieList =  this.playerLoggato.getStrategieList();
        List strategie = new ArrayList<>();
        for (Strategia s : strategieList) {
            strategie.add(s.getMap());
        }
        return strategie;
    }
}
