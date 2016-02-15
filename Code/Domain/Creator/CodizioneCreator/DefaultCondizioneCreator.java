package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 * Questa classe è un Singleton
 */
public class DefaultCondizioneCreator implements ICondizioneCreator {

    private static DefaultCondizioneCreator singletonInstance = null;

    private String name;

    private DefaultCondizioneCreator () {}

    public static DefaultCondizioneCreator getSingletonInstance ()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new DefaultCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori) {
        return null;
    }
}
