package Domain.Condizioni;

import Domain.Azioni.IAzione;
import Domain.IStrategiaComponent;

import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteSinistraCondizione implements ICondizione, IStrategiaComponent {

    private String name;
    private String description;
    private String idType;

    private String idCond;
    private ArrayList<Integer> valori;

    public OstacoloAdiacenteSinistraCondizione(String name, String description, String idType, String idCond, ArrayList<Integer> valori) {
        this.name = name;
        this.description = description;
        this.idType = idType;
        this.idCond = idCond;
        this.valori = valori;
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
    public void add(IStrategiaComponent c) {

    }

    @Override
    public void remove(IStrategiaComponent c) {

    }

    @Override
    public IStrategiaComponent getChild() {
        return null;
    }
}
