package Server.Controller;

import Shared.Util.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gioele on 16/02/16.
 */
public class ControllerFacade implements Controller{

        private String funzione;
        private List<Serializable> OggettiPersistenti;



    private List<Observer> OsservatoriRichieste = new ArrayList<Observer>();

    public List<Observer> getOsservatoriRichieste() {
        return OsservatoriRichieste;
    }

    public void setOsservatoriRichieste(List<Observer> osservatoriRichieste) {
        OsservatoriRichieste = osservatoriRichieste;
    }

    public void ControllerFacade(){

    }


    public String getFunzione(){
        return this.funzione;
    }


    public void ArrivaRichiesta(DTO dto){
        this.funzione = dto.getFunzione();
        this.OggettiPersistenti = dto.getOggettiPersistenti();

        this.Notify();
    }

    @Override
    public void Attach(Observer o) {
            OsservatoriRichieste.add(o);
    }

    @Override
    public void Detach(Observer o) {
            OsservatoriRichieste.remove(o);
    }

    @Override
    public void Notify() {
            for(Observer osservatore : OsservatoriRichieste){
                osservatore.update(this);
            }
    }

    private void prelevato(){
        this.funzione = null;
        this.OggettiPersistenti.clear();

    }

    public List<Serializable> getOggettiPersistenti() {
        return OggettiPersistenti;
    }

    public void setOggettiPersistenti(List<Serializable> oggettiPersistenti) {
        OggettiPersistenti = oggettiPersistenti;
    }
}
