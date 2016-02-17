package Domain.Condizioni;


import Domain.Azioni.IAzione;

import java.util.ArrayList;

public interface ICondizione {

	abstract boolean verificaSeVera();

	IAzione getAzione();

	/**
	 * 
	 * @param valori
	 */
	void create(String idCond, ArrayList<Integer> valori);

	String getIdCond ();

}