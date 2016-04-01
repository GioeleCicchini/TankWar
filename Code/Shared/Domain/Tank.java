package Shared.Domain;

import Shared.Domain.Caselle.ICasella;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by beniamino on 22/03/16.
 */
public class Tank implements ITank,Serializable {

    private Strategia strategia = null;


    public void Tank(){}

    private String id= UUID.randomUUID().toString();
    private Integer livello;

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    @Override
    public Strategia getStrategia() {
        return strategia;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public ICasella getCasellaPosizione() {
        return null;
    }

    @Override
    public void setCasellaPosizione(ICasella casellaPosizione) {

    }

    @Override
    public void setStrategia(Strategia strategia) {
        this.strategia = strategia;
    }

    @Override
    public ITank getTank() {
        return null;
    }

    @Override
    public void setTank(Tank tank) {

    }
}
