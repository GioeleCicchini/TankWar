package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.SullaBombaCondizione;
import Shared.Domain.Creator.ICreator;

import java.util.ArrayList;

/**
 * Created by emanuele on 16/02/16.
 */
public class SullaBombaCondizioneCreator implements ICreator {

    private static SullaBombaCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private SullaBombaCondizioneCreator() {
        this.name = "Sto su una bomba";
        this.description = "Questa condizione controlla se c'è una propria bomba sotto al tank";
        this.idType = "011";
    }

    public static SullaBombaCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new SullaBombaCondizioneCreator();
        }
        return singletonInstance;
    }

    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        SullaBombaCondizione sullaBombaCondizione = new SullaBombaCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return sullaBombaCondizione;
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
