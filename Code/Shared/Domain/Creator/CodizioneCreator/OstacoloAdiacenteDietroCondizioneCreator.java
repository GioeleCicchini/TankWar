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
    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        OstacoloAdiacenteDietroCondizione ostacoloAdiacenteDietroCondizione = new OstacoloAdiacenteDietroCondizione(this.name,this.description,this.idType, idCond, vera, valori);
        return ostacoloAdiacenteDietroCondizione;
    }

    @Override
    public String getIdType() {
        return this.idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}
