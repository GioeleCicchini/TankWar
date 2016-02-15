package Domain.Azioni;

import Domain.Azioni.IAzione;

import java.util.ArrayList;

public class AvanzaAvantiAzione implements IAzione {

    private String idAz;
    private String idTypeAz;
    private String name;
    private String description;
    private ArrayList<Integer> valori;

    public AvanzaAvantiAzione(String name, String description, String idTypeAz, String idAz, ArrayList<Integer> valori) {
        this.idAz = idAz;
        this.idTypeAz = idTypeAz;
        this.name = name;
        this.description = description;
        this.valori = valori;
    }
}