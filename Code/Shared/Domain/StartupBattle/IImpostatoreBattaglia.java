package Shared.Domain.StartupBattle;

import Shared.Domain.CampoBattaglia;
import Shared.Domain.ITank;

import java.io.IOException;

/**
 * Created by gioele on 22/03/16.
 */
public interface IImpostatoreBattaglia {
    public void posizionaTank();
    public ITank getAvversario(String livello) throws IOException;

    public CampoBattaglia getCampoBattaglia(String livello);
}
