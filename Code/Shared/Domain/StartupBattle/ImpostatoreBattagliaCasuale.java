package Shared.Domain.StartupBattle;

import Shared.Domain.CampoBattaglia;
import Shared.Domain.ITank;

import java.io.IOException;

/**
 * Created by gioele on 22/03/16.
 */
public class ImpostatoreBattagliaCasuale implements IImpostatoreBattaglia {

    private IGeneratoreAvversario generatoreAvversario = new RandomAvversarioGenerator();
    private IGeneratoreCampoBattaglia generatoreCampoBattaglia = new RandomCampoBattagliaGenerator();

    public ITank getAvversario(String livello) throws IOException {
        return ((RandomAvversarioGenerator) this.generatoreAvversario).getAvversario(livello);
    }

    public CampoBattaglia getCampoBattaglia(String livello) throws IOException {
        return ((RandomCampoBattagliaGenerator) this.generatoreCampoBattaglia).getCampoBattaglia(livello);
    }

}
