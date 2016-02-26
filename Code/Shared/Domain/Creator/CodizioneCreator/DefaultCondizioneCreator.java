package Shared.Domain.Creator.CodizioneCreator;


import Shared.Domain.Condizioni.DefaultCondizione;
import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Creator.ICreator;


import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 * Questa classe è un Singleton
 */
public class DefaultCondizioneCreator implements ICondizioneCreator, ICreator {

    private static DefaultCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private DefaultCondizioneCreator() {
        this.name="Condizione di Default";
        this.description="Questa è una condizione sempre vera";
        this.idType="000";
    }

    public static DefaultCondizioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new DefaultCondizioneCreator();
        }
        return singletonInstance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIdType() {
        return idType;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        DefaultCondizione defaultCondizione = new DefaultCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return defaultCondizione;
    }
}
