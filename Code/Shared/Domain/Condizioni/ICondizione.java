package Shared.Domain.Condizioni;



import Shared.Domain.Azioni.IAzione;
import Shared.Domain.IStrategiaComponent;

import java.util.ArrayList;

public interface ICondizione {

	abstract boolean verificaSeVera();
	IAzione getAzione();

	String getName();
	void setName(String name);

	String getDescription();
	void setDescription(String description);

	String getIdType();
	void setIdType(String idType);

	String getId();
	void setId(String id);

	ArrayList<Integer> getValori();
	void setValori(ArrayList<Integer> valori);

	IStrategiaComponent getChild();
	void setChild(IStrategiaComponent child);



	/**
	 * 
	 * @param valori
	 */
	void create(String idCond, ArrayList<Integer> valori);

}