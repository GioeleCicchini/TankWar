package Shared.Domain.Condizioni;



import Shared.Domain.Azioni.IAzione;

import java.util.ArrayList;

public interface ICondizione {

	abstract boolean verificaSeVera();

	IAzione getAzione();

	/**
	 * 
	 * @param valori
	 */
	void create(String idCond, ArrayList<Integer> valori);

	void setIdCond(String idCond);

	String getIdCond ();

}