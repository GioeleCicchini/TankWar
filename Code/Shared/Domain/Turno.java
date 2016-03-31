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

    public Turno(String idTankPersonale, String idTankAvversario) {
        this.idTankPersonale = idTankPersonale;
        this.idTankAvversario = idTankAvversario;
        numeroTurno = 0;
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

    public String getaChiTocca() {
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
}
