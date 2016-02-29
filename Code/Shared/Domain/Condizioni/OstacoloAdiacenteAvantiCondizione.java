package Shared.Domain.Condizioni;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.IStrategiaComponent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by beniamino on 15/02/16.
 */
public class OstacoloAdiacenteAvantiCondizione implements ICondizione, IStrategiaComponent, Serializable {


    private String name;
    private String description;
    private String idType;

    private String id;
    private boolean vera;
    private List<Integer> valori;
    private IStrategiaComponent child;

    public OstacoloAdiacenteAvantiCondizione(String name, String description, String idType, String idCond, boolean vera, List<Integer> valori) {
        this.name = name;
        this.description = description;
        this.idType = idType;
        this.id = idCond;
        this.vera = vera;
        this.valori = valori;
        this.child = null;
    }

    public OstacoloAdiacenteAvantiCondizione() {
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
    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getValori() {
        return valori;
    }

    public void setValori(List<Integer> valori) {
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

    @Override
    public boolean getVera() {
        return vera;
    }

    @Override
    public void setVera(boolean vera) {
        this.vera = vera;
    }
}
