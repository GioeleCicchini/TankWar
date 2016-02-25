package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.NemicoAvantiCondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoAvantiCondizioneCreator implements ICondizioneCreator, Shared.Domain.Creator.ICreator {

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
    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        NemicoAvantiCondizione nemicoAvantiCondizione = new NemicoAvantiCondizione(this.name,this.description,idType,idCond,vera,valori);
        return nemicoAvantiCondizione;
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
