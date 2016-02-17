package Domain.Azioni;

import Domain.IStrategiaComponent;

import java.util.ArrayList;

/**
 * Created by emanuele on 15/02/16.
 */
public class SparaAzione implements IAzione, IStrategiaComponent {

    private String idAz;
    private String idTypeAz;
    private String name;
    private String description;
    private ArrayList<Integer> valori;

    public SparaAzione(String name, String description, String idTypeAz, String idAz, ArrayList<Integer> valori) {
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
}
