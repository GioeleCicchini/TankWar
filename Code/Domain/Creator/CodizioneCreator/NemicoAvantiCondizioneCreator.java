package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;
import Domain.Condizioni.NemicoAvantiCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoAvantiCondizioneCreator implements ICondizioneCreator {

    private static NemicoAvantiCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private NemicoAvantiCondizioneCreator() {
        this.name = "Nemico Avanti";
        this.description = "Questa condizione controlla se c'è un nemico nel semicampo avanti a sè";
        this.idType = "001";
    }

    public static NemicoAvantiCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new NemicoAvantiCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        NemicoAvantiCondizione nemicoAvantiCondizione = new NemicoAvantiCondizione(this.name,this.description,idType,idCond,valori);
        return nemicoAvantiCondizione;
    }
}
