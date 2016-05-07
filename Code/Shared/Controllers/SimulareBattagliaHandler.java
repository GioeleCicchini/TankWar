package Shared.Controllers;


import Shared.Domain.*;
import Shared.Domain.Eventi.IEvento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private List<Battaglia> battaglie = null;
    private List<IEvento> eventi = new ArrayList<>();
    private SimulareBattagliaHandler() {
        this.playerLoggato = LoginHandler.getSingletonInstance().getPlayer();
    }



    public void iniziaImpostareBattagliaCasuale(){
        ITank tankPersonale = playerLoggato.getTank();
        this.battaglia = new Battaglia(tankPersonale);
        this.battaglia.setImpostatoreBattagliaCasuale();
    }

    public void iniziaImpostareBattagliaRipetuta() {
        this.battaglie = new ArrayList<>();
        ITank tankAvversario = this.battaglia.getTankAvversario();
        this.battaglia.setImpostatoreBattagliaRipetuta(tankAvversario);
    }

    public void impostaBattaglia() throws IOException {

        try{this.battaglia.scegliAvversario();
        }catch (NullPointerException e){
            throw new NullPointerException("Tank avversario non trovato");
        }
        try {
            this.battaglia.creaCampoBattaglia();

        }catch (NullPointerException e){
            throw new NullPointerException("Campo Battaglia non trovato");
        }

        this.battaglia.posizionaTank();

        this.battaglia.impostaTurni();

    }

    public void impostaBattagliaRipetuta(Integer numeroPartita) throws IOException {
        try{this.battaglie.get(numeroPartita).scegliAvversario();
        }catch (NullPointerException e){
            throw new NullPointerException("Tank avversario non trovato");
        }
        try {
            this.battaglie.get(numeroPartita).creaCampoBattaglia();

        }catch (NullPointerException e){
            throw new NullPointerException("Campo Battaglia non trovato");
        }

        this.battaglie.get(numeroPartita).posizionaTank();

        this.battaglie.get(numeroPartita).impostaTurni();
    }

    public void faiMossa(){
        System.out.println("Siamo nell'handler");
        if (!battaglia.isTerminata()){
            battaglia.faiMossa();
        }
    }

    public void faiSimulazioniStatistiche(Integer numeroVolte) throws IOException {
        ITank tankPersonale = playerLoggato.getTank();
        for (int i=0;i<numeroVolte;i++) {
            Battaglia b = new Battaglia(tankPersonale);
            this.battaglie.add(b);
            impostaBattagliaRipetuta(i);
            while (!b.isTerminata()) {
                faiMossa();
            }
        }
    }

    public boolean isFinita(){
        return battaglia.isTerminata();
    }

    public Map getCampoBattaglia(){
        return battaglia.getMap();
    }

    public Map getEventiMap() {
        Map map = new HashMap();
        List<Map> eventiCorrenti = new ArrayList<>();
        for (IEvento evento: this.eventi) {
            eventiCorrenti.add(evento.getMap());
        }
        map.put("eventi",eventiCorrenti);
        return map;
    }

    public List<IEvento> getEventi() {
        return eventi;
    }

    public void setEventi(List eventi) {
        this.eventi = eventi;
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
