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

    private ICasella casellaPosizione;
    private Integer bombeRimanenti;
    private OrientamentoEnum orientamento;

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
    public void setOrientamento(int orientamento) {
        switch (orientamento) {
            case 0: this.orientamento = OrientamentoEnum.N;
                break;
            case 1: this.orientamento = OrientamentoEnum.E;
                break;
            case 2: this.orientamento = OrientamentoEnum.S;
                break;
            case 3: this.orientamento = OrientamentoEnum.O;
                break;
        }
    }

    @Override
    public void faiMossa(ITank altroTank, CampoBattaglia campo) {
        this.getStrategia().faiMossa(this,altroTank,campo);
    }

    @Override
    public boolean seiMorto() {
        return !vivo;
    }

}
