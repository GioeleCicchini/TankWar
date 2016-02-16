package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;
import Domain.Condizioni.OstacoloAdiacenteDestraCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteDestraCondizioneCreator implements ICondizioneCreator {

    private static OstacoloAdiacenteDestraCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private OstacoloAdiacenteDestraCondizioneCreator() {
        this.name = "Muro adiacente destra";
        this.description = "Questa condizione controlla se c'è un muro alla destra del tank";
        this.idType = "007";
    }

    public static OstacoloAdiacenteDestraCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new OstacoloAdiacenteDestraCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        OstacoloAdiacenteDestraCondizione ostacoloAdiacenteDestraCondizione = new OstacoloAdiacenteDestraCondizione(this.name,this.description,this.idType,idCond,valori);
        return ostacoloAdiacenteDestraCondizione;
    }
}