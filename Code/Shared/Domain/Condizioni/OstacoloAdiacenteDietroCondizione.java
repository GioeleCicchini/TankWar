package Shared.Domain.Condizioni;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.IStrategiaComponent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteDietroCondizione implements ICondizione, IStrategiaComponent, Serializable {

    private String name;
    private String description;
    private String idType;

    private String idCond;
    private ArrayList<Integer> valori;
    private IStrategiaComponent child;

    public OstacoloAdiacenteDietroCondizione(String name, String description, String idType, String idCond, ArrayList<Integer> valori) {
        this.name = name;
        this.description = description;
        this.idType = idType;
        this.idCond = idCond;
        this.valori = valori;
        this.child = null;
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
