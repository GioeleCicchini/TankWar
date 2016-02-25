package Shared.Domain.Creator.CodizioneCreator;


import Shared.Domain.Condizioni.ICondizione;

import java.util.ArrayList;

public interface ICondizioneCreator {

	/**
	 * 
	 * @param valori
	 */
	 ICondizione doMakeCondizione(String idCond, boolean vera, ArrayList<Integer> valori);

	String getIdType();

	String getName();

	String getDescription();
}