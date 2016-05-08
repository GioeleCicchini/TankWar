package Shared.Domain;

import Shared.Domain.Caselle.ICasella;
import Shared.Domain.Caselle.MuroCasella;
import Shared.Domain.Caselle.PlainCasella;
import Shared.Domain.Eventi.IEvento;
import Shared.Domain.Eventi.TogliMuroEvento;
import Shared.Util.OrientamentoEnum;
import Shared.Util.RandomMinMax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gioele on 22/03/16.
 */
public class CampoBattaglia implements Serializable {

    private String id;

    private ICasella [][] campo;

    private Integer DimesioneCampo;
    private List<ICasella> caselleMonodimensionali;
    private List<ICasella> muri;

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
        this.muri = this.getMuri();
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

    public List getCaselleByOrientamento(ICasella casella, OrientamentoEnum orientamento) {
        Posizione posizioneCasella = casella.getPosizione();
        ICasella [] colonnaAttuale;
        ICasella [] rigaAttuale = new ICasella[this.campo.length];
        List campoAttuale = new ArrayList();
        switch (orientamento.toString()) {
            case "N":
              colonnaAttuale = this.campo[posizioneCasella.getX()];
                for (int y = posizioneCasella.getY()-1;y>=0;y--) {
                    campoAttuale.add(colonnaAttuale[y]);
                }
                break;
            case "E":
                for (int x = 0;x<this.campo.length;x++) {
                    rigaAttuale[x] = this.campo[x][posizioneCasella.getY()];
                }
                for (int x = posizioneCasella.getX()+1;x<rigaAttuale.length;x++) {
                    campoAttuale.add(rigaAttuale[x]);
                }
                break;
            case "S":
                colonnaAttuale = this.campo[posizioneCasella.getX()];
                for (int y = posizioneCasella.getY()+1;y<colonnaAttuale.length;y++) {
                    campoAttuale.add(colonnaAttuale[y]);
                }
                break;
            case "O":
                for (int x = 0;x<this.campo.length;x++) {
                    rigaAttuale[x] = this.campo[x][posizioneCasella.getY()];
                }
                for (int x = posizioneCasella.getX()-1;x>=0;x--) {
                    campoAttuale.add(rigaAttuale[x]);
                }
                break;
        }
        return campoAttuale;
    }


    public void ConvertiDaArrayListAdArray(){

        this.campo = new ICasella[DimesioneCampo][DimesioneCampo];
        for(int i=0;i<(this.DimesioneCampo*this.DimesioneCampo);i++){
             Integer x = i % this.DimesioneCampo;
             Integer y = (i-x)/this.DimesioneCampo;
            campo[x][y] = caselleMonodimensionali.get(i);
        }

    }

    public Integer getDimesioneCampo() {
        return DimesioneCampo;
    }

    public void setDimesioneCampo(Integer dimesioneCampo) {
        DimesioneCampo = dimesioneCampo;
    }


    public Map getMap(){
        Map CampoBattaglia = new HashMap();

        List caselle = new ArrayList<>();
        for(ICasella cas : caselleMonodimensionali){
            caselle.add(cas.getMap());
        }

        CampoBattaglia.put("DimensioneCampo",this.DimesioneCampo);
        CampoBattaglia.put("Id",this.id);
        CampoBattaglia.put("CampoBattaglia",caselle);


        return CampoBattaglia;
    }

    public List<ICasella> getMuri() {
        List<ICasella> muri = new ArrayList<>();
        for (int x=0;x<this.campo.length;x++) {
            ICasella [] colonnaAttuale = this.campo[x];
            for (int y=0;y<colonnaAttuale.length;y++) {
                ICasella casellaAttuale = colonnaAttuale[y];
                if (casellaAttuale instanceof MuroCasella) {
                    muri.add(casellaAttuale);
                }
            }
        }
        return muri;
    }

    public IEvento rimuoviMuroCasuale() {
        IEvento evento = null;
        if (this.muri != null) {
            Integer grandezza = this.muri.size();
            Integer togliere = RandomMinMax.randInt(0,grandezza-1);
            ICasella muroDaTogliere = this.muri.get(togliere);
            Posizione posizioneMuro = muroDaTogliere.getPosizione();
            this.muri.remove(muroDaTogliere);
            ICasella plainCasella = new PlainCasella(posizioneMuro);
            this.campo[posizioneMuro.getX()][posizioneMuro.getY()] = plainCasella;
            evento = new TogliMuroEvento(muroDaTogliere);
        } else {
            evento = new TogliMuroEvento();
        }
        return evento;
    }
}
