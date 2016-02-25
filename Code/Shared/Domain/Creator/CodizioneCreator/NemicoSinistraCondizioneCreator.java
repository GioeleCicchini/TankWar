package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.NemicoSinistraCondizione;


import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoSinistraCondizioneCreator implements ICondizioneCreator, Shared.Domain.Creator.ICreator {

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
    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        NemicoSinistraCondizione nemicoSinistraCondizione = new NemicoSinistraCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return nemicoSinistraCondizione;
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
