package Shared.Domain.Creator.CodizioneCreator;


import Shared.Domain.Condizioni.ICondizione;

import java.util.ArrayList;

public interface ICondizioneCreator {

	/**
	 * 
	 * @param valori
	 */
	 ICondizione doMakeCondizione(String idCond, ArrayList<Integer> valori);

	String getIdType();
}