package Shared.Domain;

import Shared.Util.RandomMinMax;

import java.util.Random;

/**
 * Created by gioele on 22/03/16.
 */
public class Turno {

    private String idTankPersonale;
    private String idTankAvversario;
    private String aChiTocca;
    private Integer numeroTurno;
    private Integer maxTurni;

    public Turno(String idTankPersonale, String idTankAvversario, Integer turni) {
        this.idTankPersonale = idTankPersonale;
        this.idTankAvversario = idTankAvversario;
        numeroTurno = 0;
        maxTurni=turni*2;//Todo al posto del 2 ci andrà il numero di partecipanti
    }

    public String getIdTankPersonale() {
        return idTankPersonale;
    }

    public void setIdTankPersonale(String idTankPersonale) {
        this.idTankPersonale = idTankPersonale;
    }

    public String getIdTankAvversario() {
        return idTankAvversario;
    }

    public void setIdTankAvversario(String idTankAvversario) {
        this.idTankAvversario = idTankAvversario;
    }

    public String aChiTocca() {
        return aChiTocca;
    }

    public void setaChiTocca(String aChiTocca) {
        this.aChiTocca = aChiTocca;
    }

    public Integer getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(Integer numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public void increment(){
        numeroTurno++;
        //todo da quì in poi alti livelli di bruttezza
        if (aChiTocca.equals(idTankPersonale)){
            aChiTocca=idTankAvversario;
        }
        else {
            aChiTocca=idTankAvversario;
        }
    }

    public boolean isFinitaPartita(){
        boolean finita = false;
        if (numeroTurno>=maxTurni){
            finita=true;
        }
        return finita;
    }
}
