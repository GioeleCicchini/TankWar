package Shared.Domain.TankDecorator;

import Shared.Domain.CampoBattaglia;
import Shared.Domain.Caselle.ICasella;
import Shared.Domain.ITank;
import Shared.Domain.Strategia;
import Shared.Domain.Tank;
import Shared.Util.OrientamentoEnum;

/**
 * Created by beniamino on 22/03/16.
 */
public class TankOnBattle extends TankDecorator {


    private static final Integer maxVisioneSparo = 3;
    private ICasella casellaPosizione;
    private Integer bombeRimanenti;
    private OrientamentoEnum orientamento;
    private Integer vita = 1;
    private Integer potenzaArma = 1;

    private boolean vivo = true;

    public TankOnBattle(ITank component) {
        super(component);
        this.bombeRimanenti = 10;
    }

    @Override
    public void setStrategia(Strategia strategia) {

    }

    @Override
    public Strategia getStrategia() {
        return null;
    }

    @Override
    public ITank getTank() {
        return null;
    }

    @Override
    public void setTank(Tank tank) {

    }

    @Override
    public Integer getLivello() {
        return super.getLivello();
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public ICasella getCasellaPosizione() {
        return casellaPosizione;
    }

    @Override
    public void setCasellaPosizione(ICasella casellaPosizione) {
        this.casellaPosizione = casellaPosizione;
        this.casellaPosizione.getPosizione().setX(casellaPosizione.getPosizione().getX());
        this.casellaPosizione.getPosizione().setY(casellaPosizione.getPosizione().getY());
    }

    @Override
    public Integer getBombeRimanenti() {
        return bombeRimanenti;
    }

    @Override
    public void setBombeRimanenti(Integer bombeRimanenti) {
        this.bombeRimanenti = bombeRimanenti;
    }

    @Override
    public OrientamentoEnum getOrientamento() {
        return orientamento;
    }

    @Override
    public void setOrientamento(OrientamentoEnum orientamento) {
        this.orientamento = orientamento;
    }

    @Override
    public void setOrientamento(Integer orientamento) {
        this.orientamento = OrientamentoEnum.getEnumByNumero(orientamento);
    }

    @Override
    public void faiMossa(ITank altroTank, CampoBattaglia campo) {
        this.getStrategia().faiMossa(this,altroTank,campo);
    }

    @Override
    public boolean seiMorto() {
        return !vivo;
    }

    @Override
    public Integer getMaxVisioneSparo() {
        return maxVisioneSparo;
    }

    @Override
    public void colpito(Integer danno) {
        vita = vita-danno;
        if (vita <= 0){
            vivo=false;
        }
    }

    public Integer getPotenzaArma(){
        return potenzaArma;
    }

}
