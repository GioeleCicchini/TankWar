package Domain.Creator.AzioneCreator;

import Domain.Azioni.IAzione;

import java.util.ArrayList;

public interface IAzioneCreator {

	/**
	 * 
	 * @param valori
	 */
	IAzione doMakeAzione(String idAz, ArrayList<Integer> valori);

}