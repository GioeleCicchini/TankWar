package Shared.Domain.Controllers;

import Shared.Domain.CatalogoAzioneCreator;
import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.*;
import Shared.Domain.Creator.ICreator;
import Shared.Domain.ICatalogo;
import Shared.Domain.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by beniamino on 24/02/16.
 */
public class StartUpHandler {
    private static StartUpHandler singletonInstance=null;

    public static StartUpHandler getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new StartUpHandler();
        }
        return singletonInstance;
    }

    private Player player;
    private ICatalogo catalogoCondCreator;
    private ICatalogo catalogoAzCreator;

    private StartUpHandler() {
        this.player=
    }

    public void inizia(){
        Player player = Player.getSingletonInstance();
        ICatalogo ccc = CatalogoCondizioneCreator.getSingletonInstance();
        ICatalogo cac = CatalogoAzioneCreator.getSingletonInstance();
    }
}
