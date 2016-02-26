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
        this.player=new Player();
        this.catalogoCondCreator=new CatalogoCondizioneCreator();
        this.catalogoAzCreator=new CatalogoAzioneCreator();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ICatalogo getCatalogoCondCreator() {
        return catalogoCondCreator;
    }

    public void setCatalogoCondCreator(ICatalogo catalogoCondCreator) {
        this.catalogoCondCreator = catalogoCondCreator;
    }

    public ICatalogo getCatalogoAzCreator() {
        return catalogoAzCreator;
    }

    public void setCatalogoAzCreator(ICatalogo catalogoAzCreator) {
        this.catalogoAzCreator = catalogoAzCreator;
    }
}
