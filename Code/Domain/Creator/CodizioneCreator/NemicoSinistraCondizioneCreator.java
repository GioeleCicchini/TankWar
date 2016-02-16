package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;
import Domain.Condizioni.NemicoSinistraCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoSinistraCondizioneCreator implements ICondizioneCreator {

    private static NemicoSinistraCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private NemicoSinistraCondizioneCreator() {
        this.name = "Nemico a sinistra";
        this.description = "Questa condizione controlla se c'è un nemico nel semicampo alla sinistra del tank";
        this.idType = "003";
    }

    public static NemicoSinistraCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new NemicoSinistraCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        NemicoSinistraCondizione nemicoSinistraCondizione = new NemicoSinistraCondizione(this.name,this.description,this.idType,idCond,valori);
        return nemicoSinistraCondizione;
    }
}