package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.OstacoloAdiacenteDietroCondizione;


import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteDietroCondizioneCreator implements ICondizioneCreator {

    private static OstacoloAdiacenteDietroCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private OstacoloAdiacenteDietroCondizioneCreator() {
        this.name = "Muro adiacente dietro";
        this.description = "Questa condizione controlla se c'è un muro dietro al tank";
        this.idType = "009";
    }

    public static OstacoloAdiacenteDietroCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new OstacoloAdiacenteDietroCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        OstacoloAdiacenteDietroCondizione ostacoloAdiacenteDietroCondizione = new OstacoloAdiacenteDietroCondizione(this.name,this.description,this.idType, idCond, valori);
        return ostacoloAdiacenteDietroCondizione;
    }

    @Override
    public String getIdType() {
        return null;
    }
}