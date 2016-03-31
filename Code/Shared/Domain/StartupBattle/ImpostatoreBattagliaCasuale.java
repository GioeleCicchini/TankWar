package Shared.Domain.StartupBattle;


import Shared.Domain.ITank;
import Shared.Domain.Tank;
import Shared.Domain.CampoBattaglia;

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

        Random r = new Random();

        int posX=r.nextInt()
        campo.posizionaTank(tankCasa);
    }
    public CampoBattaglia getCampoBattaglia(Integer livello) throws IOException {
        return ((RandomCampoBattagliaGenerator) this.generatoreCampoBattaglia).getCampoBattaglia(livello);
    }

}
