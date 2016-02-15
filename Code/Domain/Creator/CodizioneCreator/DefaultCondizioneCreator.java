package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.DefaultCondizione;
import Domain.Condizioni.ICondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 * Questa classe è un Singleton
 */
public class DefaultCondizioneCreator implements ICondizioneCreator {

    private static DefaultCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private DefaultCondizioneCreator () {
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

    @Override
    public DefaultCondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        DefaultCondizione defaultCondizione = new DefaultCondizione(this.name,this.description,this.idType,idCond,valori);
        return defaultCondizione;
    }
}
