package Shared.Domain.Azioni;

import Shared.Controllers.SimulareBattagliaHandler;
import Shared.Domain.CampoBattaglia;
import Shared.Domain.Eventi.IEvento;
import Shared.Domain.Eventi.TemporeggiaEvento;
import Shared.Domain.IStrategiaComponent;
import Shared.Domain.ITank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emanuele on 15/02/16.
 */
public class TemporeggiaAzione implements IAzione, IStrategiaComponent, Serializable {

    private String id;
    private String idTypeAz;
    private String name;
    private String description;
    private List<Integer> valori;

    public TemporeggiaAzione() {

    }

    public TemporeggiaAzione(String name, String description, String idTypeAz, String idAz, List<Integer> valori) {
        this.id = idAz;
        this.idTypeAz = idTypeAz;
        this.name = name;
        this.description = description;
        this.valori = valori;
    }

    public String getIdTypeAz() {
        return idTypeAz;
    }

    public void setIdTypeAz(String idTypeAz) {
        this.idTypeAz = idTypeAz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getValori() {
        return valori;
    }

    public void setValori(List<Integer> valori) {
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

    @Override
    public boolean hasChild() {
        return false;
    }

    @Override
    public void setChild(IStrategiaComponent child) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Map getMap() {
        Map azione = new HashMap();
        List valoriCorrenti = new ArrayList<>();
        if(valori != null) {
            for (Integer v : this.valori) {
                valoriCorrenti.add(v);
            }
        }
        azione.put("id", this.id);
        azione.put("idTypeAz", this.idTypeAz);
        azione.put("name", this.name);
        azione.put("description", this.description);
        azione.put("valori", this.valori);
        return azione;
    }

    @Override
    public boolean eseguiti(ITank tankTurno, ITank tankAvversario, CampoBattaglia campo) {
        IEvento evento = new TemporeggiaEvento();
        List<IEvento> eventi = new ArrayList<>();
        eventi.add(evento);
        this.fireEvent(eventi);
        return true;
    }

    @Override
    public void fireEvent(List eventi) {
        SimulareBattagliaHandler.getSingletonInstance().setEventi(eventi);
    }

}
