package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;
import Domain.Condizioni.NemicoDietroCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoDietroCondizioneCreator implements ICondizioneCreator {

    private static NemicoDietroCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private NemicoDietroCondizioneCreator() {
        this.name = "Nemico dietro";
        this.description = "Questa condizione controlla se c'è un nemico nel semicampo dietro al tank";
        this.idType = "004";
    }

    public static NemicoDietroCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new NemicoDietroCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        NemicoDietroCondizione nemicoDietroCondizione = new NemicoDietroCondizione(this.name,this.description,this.idType,idCond,valori);
        return nemicoDietroCondizione;
    }
}
