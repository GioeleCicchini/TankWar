package Shared.Domain.Azioni;

import Shared.Domain.IStrategiaComponent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class IndietreggiaAzione implements IAzione, IStrategiaComponent, Serializable {
    private String idAz;
    private String idTypeAz;
    private String name;
    private String description;
    private ArrayList<Integer> valori;

    public IndietreggiaAzione() {
    }

    public String getIdTypeAz() {
        return idTypeAz;
    }

    public void setIdTypeAz(String idTypeAz) {
        this.idTypeAz = idTypeAz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getValori() {
        return valori;
    }

    public void setValori(ArrayList<Integer> valori) {
        this.valori = valori;
    }

    public IndietreggiaAzione(String name, String description, String idTypeAz, String idAz, ArrayList<Integer> valori) {
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
