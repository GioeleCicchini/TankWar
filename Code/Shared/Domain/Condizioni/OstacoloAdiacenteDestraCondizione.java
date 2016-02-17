package Shared.Domain.Condizioni;


import Shared.Domain.Azioni.IAzione;
import Shared.Domain.IStrategiaComponent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteDestraCondizione implements ICondizione, IStrategiaComponent, Serializable {

    private String name;
    private String description;
    private String idType;

    private String idCond;
    private ArrayList<Integer> valori;
    private IStrategiaComponent child;

    public OstacoloAdiacenteDestraCondizione(String name, String description, String idType, String idCond, ArrayList<Integer> valori) {
        this.name = name;
        this.description = description;
        this.idType = idType;
        this.idCond = idCond;
        this.valori = valori;
        this.child = null;
    }

    public OstacoloAdiacenteDestraCondizione() {
    }

    @Override
    public boolean verificaSeVera() {
        return false;
    }

    @Override
    public IAzione getAzione() {
        return null;
    }


    @Override
    public void create(String idCond, ArrayList<Integer> valori) {

    }

    @Override
    public String getIdCond() {
        return idCond;
    }

    @Override
    public void addChild(IStrategiaComponent c) {
        if (this.child == null) {
            this.child = c;
        }
    }

    @Override
    public void removeChild() {
        this.child = null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public void setIdCond(String idCond) {
        this.idCond = idCond;
    }

    public ArrayList<Integer> getValori() {
        return valori;
    }

    public void setValori(ArrayList<Integer> valori) {
        this.valori = valori;
    }

    public void setChild(IStrategiaComponent child) {
        this.child = child;
    }

    @Override
    public IStrategiaComponent getChild() {
        return this.child;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
