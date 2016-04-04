package Shared.Domain.StartupBattle;


import Shared.Domain.Caselle.ICasella;
import Shared.Domain.ITank;
import Shared.Domain.Tank;
import Shared.Domain.CampoBattaglia;
import Shared.Util.RandomMinMax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gioele on 22/03/16.
 */
public class ImpostatoreBattagliaCasuale implements IImpostatoreBattaglia {

    private IGeneratoreAvversario generatoreAvversario = new RandomAvversarioGenerator();
    private IGeneratoreCampoBattaglia generatoreCampoBattaglia = new RandomCampoBattagliaGenerator();

    public ITank getAvversario(Integer livello) throws IOException {
        return ((RandomAvversarioGenerator) this.generatoreAvversario).getAvversario(livello);
    }

    @Override
    public void posizionaTank(ITank tankCasa, ITank tankTrasferta, CampoBattaglia campo) {

        List<ITank> tank = new ArrayList<>();
        tank.add(tankCasa);
        tank.add(tankTrasferta);
        int dimX=campo.getDimensioneX();
        int dimY=campo.getDimensioneY();
        ICasella casellaAttuale;
        int posX;
        int posY;
        for (ITank t: tank) {
            do {
                posX=RandomMinMax.randInt(0,dimX-1);
                posY=RandomMinMax.randInt(0,dimY-1);
                casellaAttuale = campo.getCasella(posX,posY);
            } while(!casellaAttuale.isDisponibile());
            campo.posizionaTank(t,posX,posY);
            t.setCasellaPosizione(casellaAttuale);
            Integer or = RandomMinMax.randInt(0,3);
            t.setOrientamento(or);
        }
    }
    public CampoBattaglia getCampoBattaglia(Integer livello) throws IOException {
        return ((RandomCampoBattagliaGenerator) this.generatoreCampoBattaglia).getCampoBattaglia(livello);
    }

    @Override
    public String decidiTurno(String idTankPersonale, String idTankAvversario) {
        Integer random = RandomMinMax.randInt(0,1);
        String idInizio;
        if (random == 1) {
            idInizio = idTankAvversario;
        } else {
            idInizio = idTankPersonale;
        }
        return idInizio;
    }

}
