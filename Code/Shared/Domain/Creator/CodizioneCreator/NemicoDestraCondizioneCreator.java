package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.NemicoDestraCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoDestraCondizioneCreator implements ICondizioneCreator {

    private static NemicoDestraCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private NemicoDestraCondizioneCreator() {
        this.name = "Nemico a destra";
        this.idType = "002";
        this.description = "Questa condizione controlla se c'è un nemico nel semicampo alla destra del tank";
    }

    public static NemicoDestraCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new NemicoDestraCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        NemicoDestraCondizione nemicoDestraCondizione = new NemicoDestraCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return nemicoDestraCondizione;
    }

    @Override
    public String getIdType() {
        return null;
    }
}
