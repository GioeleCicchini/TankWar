package Shared.Domain.Controllers;

import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.*;
import Shared.Domain.Creator.ICreator;
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

    private StartUpHandler() {
    }

    public void inizia(){
        Player player = Player.getSingletonInstance();
        CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();

        Map<String,ICreator> map = new HashMap<>();

        NemicoAvantiCondizioneCreator nemicoAvantiCondizioneCreator = NemicoAvantiCondizioneCreator.getSingletonInstance();
        DefaultCondizioneCreator defaultCondizioneCreator = DefaultCondizioneCreator.getSingletonInstance();
        NemicoDestraCondizioneCreator nemicoDestraCondizioneCreator = NemicoDestraCondizioneCreator.getSingletonInstance();
        NemicoDietroCondizioneCreator nemicoDietroCondizioneCreator = NemicoDietroCondizioneCreator.getSingletonInstance();
        NemicoSinistraCondizioneCreator nemicoSinistraCondizioneCreator = NemicoSinistraCondizioneCreator.getSingletonInstance();


        System.out.println("Debugging dentro al catalogo:");
        System.out.println("Id delle cc presenti:");
        System.out.println(nemicoAvantiCondizioneCreator.getIdType());
        System.out.println(defaultCondizioneCreator.getIdType());
        System.out.println(nemicoDestraCondizioneCreator.getIdType());
        System.out.println(nemicoDietroCondizioneCreator.getIdType());
        System.out.println(nemicoSinistraCondizioneCreator.getIdType());

        map.put(nemicoAvantiCondizioneCreator.getIdType(),nemicoAvantiCondizioneCreator);
        map.put(defaultCondizioneCreator.getIdType(),defaultCondizioneCreator);
        map.put(nemicoDestraCondizioneCreator.getIdType(),nemicoDestraCondizioneCreator);
        map.put(nemicoDietroCondizioneCreator.getIdType(),nemicoDietroCondizioneCreator);
        map.put(nemicoSinistraCondizioneCreator.getIdType(),nemicoSinistraCondizioneCreator);

        ccc.setCreators(map);

        for (String id : ccc.getCondizioniCreators().keySet()) {
            System.out.println(ccc.getCreator(id)); //Perchè solo 2?
        }


    }
}
