package Shared.Domain.Creator.CodizioneCreator;

import Shared.Domain.Condizioni.ICondizione;

import java.util.ArrayList;

/**
 * Created by beniamino on 26/02/16.
 */
public interface ICondizioneCreator {
    ICondizione doMakeCondizione (String idCond, boolean vera, ArrayList<Integer> valori);
}
