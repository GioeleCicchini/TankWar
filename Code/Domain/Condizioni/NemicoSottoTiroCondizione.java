package Domain.Condizioni;


import Domain.Azioni.IAzione;
import Domain.IStrategiaComponent;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoSottoTiroCondizione implements ICondizione, IStrategiaComponent {

    private String name;
    private String description;
    private String idType;

    private String idCond;
    private ArrayList<Integer> valori;
    private  IStrategiaComponent child;

    public NemicoSottoTiroCondizione(String name, String description, String idType, String idCond, ArrayList<Integer> valori) {
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
}
