package Shared.Domain.Condizioni;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.IStrategiaComponent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by emanuele on 16/02/16.
 */
public class BombeRimanentiCondizione implements ICondizione, IStrategiaComponent, Serializable {


    private String name;
    private String description;
    private String idType;

    private String id;
    private boolean vera;
    private ArrayList<Integer> valori;
    private IStrategiaComponent child;

    public BombeRimanentiCondizione(String name, String description, String idType, String idCond, boolean vera, ArrayList<Integer> valori) {
        this.name = name;
        this.description = description;
        this.idType = idType;
        this.id = idCond;
        this.vera = vera;
        this.valori = valori;
        this.child = null;
    }

    public BombeRimanentiCondizione() {
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
    public String getId() {
        return id;
    }

    @Override
    public void addChild(IStrategiaComponent c) {
        if (this.child == null){
            this.child=c;
        }
    }

    @Override
    public void removeChild() {
        this.child = null;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getIdType() {
        return idType;
    }

    @Override
    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public void setId(String idCond) {
        this.id = idCond;
    }

    @Override
    public ArrayList<Integer> getValori() {
        return valori;
    }

    @Override
    public void setValori(ArrayList<Integer> valori) {
        this.valori = valori;
    }

    @Override
    public void setChild(IStrategiaComponent child) {
        this.child = child;
    }

    @Override
    public IStrategiaComponent getChild() {
        return this.child;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isVera() {
        return vera;
    }

    public void setVera(boolean vera) {
        this.vera = vera;
    }
}
