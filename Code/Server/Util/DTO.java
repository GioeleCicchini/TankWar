package Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gioele on 16/02/16.
 */
public class DTO implements Serializable{

    private static final long serialVersionUID=11;
    private String funzione;
    private List<Serializable> OggettiPersistenti = new ArrayList<Serializable>();



    public void DTO(){


    }

    public String getFunzione() {
        return funzione;
    }

    public void setFunzione(String funzione) {
        this.funzione = funzione;
    }

    public void aggiungiOggettoPersistente(Serializable Object){
        this.OggettiPersistenti.add(Object);
    }

    public List<Serializable> getOggettiPersistenti() {
        return OggettiPersistenti;
    }

    public void setOggettiPersistenti(List<Serializable> oggettiPersistenti) {
        OggettiPersistenti = oggettiPersistenti;
    }
}
