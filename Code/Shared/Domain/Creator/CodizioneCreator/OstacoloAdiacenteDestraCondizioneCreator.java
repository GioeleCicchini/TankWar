package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.OstacoloAdiacenteDestraCondizione;
import Shared.Domain.Creator.ICreator;


import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteDestraCondizioneCreator implements ICreator, ICondizioneCreator {

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

    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        OstacoloAdiacenteDestraCondizione ostacoloAdiacenteDestraCondizione = new OstacoloAdiacenteDestraCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return ostacoloAdiacenteDestraCondizione;
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
