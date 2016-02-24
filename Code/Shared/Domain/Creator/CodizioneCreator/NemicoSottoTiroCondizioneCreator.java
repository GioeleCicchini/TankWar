package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Condizioni.NemicoSottoTiroCondizione;


import java.util.ArrayList;

/**
 * Created by beniamino on 15/02/16.
 */
public class NemicoSottoTiroCondizioneCreator implements ICondizioneCreator {

    private static NemicoSottoTiroCondizioneCreator singletonInstance = null;

    private String name;
    private String description;
    private String idType;

    private NemicoSottoTiroCondizioneCreator() {
        this.name = "Nemico sotto tiro";
        this.description = "Questa condizione controlla se c'è un nemico nel raggio di sparo del proprio tank";
        this.idType = "005";
    }

    public static NemicoSottoTiroCondizioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new NemicoSottoTiroCondizioneCreator();
        }
        return singletonInstance;
    }

    @Override
    public ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori) {
        NemicoSottoTiroCondizione nemicoSottoTiroCondizione = new NemicoSottoTiroCondizione(this.name,this.description,this.idType,idCond,vera,valori);
        return nemicoSottoTiroCondizione;
    }

    @Override
    public String getIdType() {
        return null;
    }
}
