package Shared.Controllers;


import Shared.Domain.Battaglia;
import Shared.Domain.Player;
import Shared.Domain.Tank;

/**
 * Created by gioele on 22/03/16.
 */
public class SimulareBattagliaHandler {
    private static SimulareBattagliaHandler singletonInstance = null;

    public static SimulareBattagliaHandler getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SimulareBattagliaHandler();
        }
        return singletonInstance;
    }



    private Player playerLoggato;
    private Battaglia battaglia = null;

    private SimulareBattagliaHandler() {
        this.playerLoggato = LoginHandler.getSingletonInstance().getPlayer();
    }



    public void iniziaImpostareBattaglia(){

       Tank tankPersonale = playerLoggato.getTank();
        this.battaglia = new Battaglia(tankPersonale);

    }


    public Player getPlayerLoggato() {
        return playerLoggato;
    }

    public void setPlayerLoggato(Player playerLoggato) {
        playerLoggato = playerLoggato;
    }
}
