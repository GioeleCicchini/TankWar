package Shared.Domain.StartupBattle;

import Shared.Domain.Tank;

import java.io.IOException;

/**
 * Created by gioele on 22/03/16.
 */
public interface IImpostatoreBattaglia {
    public Tank getAvversario(String livello) throws IOException;
    public void posizionaTank();
}
