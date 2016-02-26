package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.OstacoloAdiacenteSinistraCondizione;
import Shared.Domain.Creator.ICreator;

import java.util.ArrayList;

/**
 * Created by beniamino on 16/02/16.
 */
public class OstacoloAdiacenteSinistraCondizioneCreator implements ICreator, ICondizioneCreator {

    private static OstacoloAdiacenteSinistraCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private OstacoloAdiacenteSinistraCondizioneCreator() {
        this.name = "Muro adiacente sinistra";
        this.description = "Questa condizione controlla se c'è un muro alla sinistra del tank";
        this.idType = "008";
    }

    public static OstacoloAdiacenteSinistraCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new OstacoloAdiacenteSinistraCondizioneCreator();
        }
        return singletonInstance;
    }


    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        OstacoloAdiacenteSinistraCondizione ostacoloAdiacenteSinistraCondizione = new OstacoloAdiacenteSinistraCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return ostacoloAdiacenteSinistraCondizione;
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
