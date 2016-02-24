package Shared.Domain.Controllers;

import Shared.Domain.CatalogoAzioneCreator;
import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.*;
import Shared.Domain.Player;

import java.util.ArrayList;
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

    private StartUpHandler() {
    }

    public void inizia(){
        Player player = Player.getSingletonInstance();
        CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();

        Map<String,ICondizioneCreator> map = new HashMap<String, ICondizioneCreator>();

        NemicoAvantiCondizioneCreator nemicoAvantiCondizioneCreator = NemicoAvantiCondizioneCreator.getSingletonInstance();
        DefaultCondizioneCreator defaultCondizioneCreator = DefaultCondizioneCreator.getSingletonInstance();
        NemicoDestraCondizioneCreator nemicoDestraCondizioneCreator = NemicoDestraCondizioneCreator.getSingletonInstance();
        NemicoDietroCondizioneCreator nemicoDietroCondizioneCreator = NemicoDietroCondizioneCreator.getSingletonInstance();
        NemicoSinistraCondizioneCreator nemicoSinistraCondizioneCreator = NemicoSinistraCondizioneCreator.getSingletonInstance();


        map.put(nemicoAvantiCondizioneCreator.getIdType(),nemicoAvantiCondizioneCreator);
        map.put(defaultCondizioneCreator.getIdType(),defaultCondizioneCreator);
        map.put(nemicoDestraCondizioneCreator.getIdType(),nemicoDestraCondizioneCreator);
        map.put(nemicoDietroCondizioneCreator.getIdType(),nemicoDietroCondizioneCreator);
        map.put(nemicoSinistraCondizioneCreator.getIdType(),nemicoSinistraCondizioneCreator);

        ccc.setCondizioniCreators(map);


    }
}
