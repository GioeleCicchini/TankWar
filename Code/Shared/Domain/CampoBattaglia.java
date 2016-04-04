package Shared.Domain;

import Shared.Domain.Caselle.ICasella;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gioele on 22/03/16.
 */
public class CampoBattaglia implements Serializable {

    private String id;

    private ICasella [][] campo;

    private List<ICasella> caselleMonodimensionali;

    public CampoBattaglia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ICasella[][] getCampo() {
        return campo;
    }

    public void setCampo(ICasella[][] campo) {
        this.campo = campo;
    }

    public List<ICasella> getCaselleMonodimensionali() {
        return caselleMonodimensionali;
    }

    public void setCaselleMonodimensionali(List<ICasella> caselleMonodimensionali) {
        this.caselleMonodimensionali = caselleMonodimensionali;
    }

    public CampoBattaglia(String id, int x, int y) {
        this.id = id;
        this.campo = new ICasella[x][y];
    }

    public void posizionaTank (ITank tank, Posizione posizione){
        Integer x = posizione.getX();
        Integer y = posizione.getY();
        campo[x][y].setTank(tank);
    }

    public int getDimensioneX(){
        return campo.length;
    }

    public int getDimensioneY(){
        return campo[0].length;
    }

    public void setCasella(ICasella casella, Posizione posizione){
        Integer x = posizione.getX();
        Integer y = posizione.getY();
        this.campo [x][y]  = casella;
    }

    public ICasella getCasella(Posizione posizione){
        Integer x = posizione.getX();
        Integer y = posizione.getY();
        return this.campo[x][y];
    }

    public Posizione getPosizioneCasella(ICasella casella) {
        Posizione posizione = casella.getPosizione();
        return posizione;
    }
}
