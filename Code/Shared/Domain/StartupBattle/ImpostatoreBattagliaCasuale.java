package Shared.Domain.StartupBattle;


import Shared.Domain.ITank;
import Shared.Domain.Tank;
import Shared.Domain.CampoBattaglia;
import Shared.Util.RandomMinMax;

import java.io.IOException;
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

        int dimX=campo.getDimensioneX();
        int dimY=campo.getDimensioneY();

        int posX=RandomMinMax.randInt(0,dimX-1);
        int posY=RandomMinMax.randInt(0,dimY-1);

        
        campo.posizionaTank(tankCasa,posX,posY);
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
