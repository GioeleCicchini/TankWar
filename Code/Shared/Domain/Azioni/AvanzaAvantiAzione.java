package Shared.Domain.Azioni;

import Shared.Domain.IStrategiaComponent;

import java.io.Serializable;
import java.util.ArrayList;

public class AvanzaAvantiAzione implements IAzione, IStrategiaComponent, Serializable {

    private String idAz;
    private String idTypeAz;
    private String name;
    private String description;
    private ArrayList<Integer> valori;

    public AvanzaAvantiAzione() {
    }

    public AvanzaAvantiAzione(String name, String description, String idTypeAz, String idAz, ArrayList<Integer> valori) {
        this.idAz = idAz;
        this.idTypeAz = idTypeAz;
        this.name = name;
        this.description = description;
        this.valori = valori;
    }

    @Override
    public void addChild(IStrategiaComponent c) {

    }

    @Override
    public void removeChild() {

    }

    @Override
    public IStrategiaComponent getChild() {
        return null;
    }

    public String getIdAz() {
        return idAz;
    }

    public void setIdAz(String idAz) {
        this.idAz = idAz;
    }
}