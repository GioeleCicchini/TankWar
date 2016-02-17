package Shared.Domain.Condizioni;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.IStrategiaComponent;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoAvantiCondizione implements ICondizione, IStrategiaComponent {

    private String name;
    private String description;
    private String idType;

    private String idCond;
    private ArrayList<Integer> valori;
    private IStrategiaComponent child;

    public NemicoAvantiCondizione(String name, String description, String idType, String idCond, ArrayList<Integer> valori) {
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
    public String getIdCond() {
        return idCond;
    }

    @Override
    public void create(String idCond, ArrayList<Integer> valori) {

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
    public IStrategiaComponent getChild() {
        return this.child;
    }
}
