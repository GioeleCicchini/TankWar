package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;
import Domain.Condizioni.OstacoloAdiacenteAvantiCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class OstacoloAdiacenteAvantiCondizioneCreator implements ICondizioneCreator{

    private static OstacoloAdiacenteAvantiCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private OstacoloAdiacenteAvantiCondizioneCreator() {
        this.name = "Muro adiacente davanti";
        this.description = "Questa condizione controlla se c'è un muro avanti al tank";
        this.idType = "006";
    }

    public static OstacoloAdiacenteAvantiCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new OstacoloAdiacenteAvantiCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        OstacoloAdiacenteAvantiCondizione ostacoloAdiacenteAvantiCondizione = new OstacoloAdiacenteAvantiCondizione(this.name,this.description,this.idType,idCond,valori);
        return ostacoloAdiacenteAvantiCondizione;
    }
}
