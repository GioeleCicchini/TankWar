package Shared.Domain.Condizioni;



import Shared.Domain.Azioni.IAzione;
import Shared.Domain.IStrategiaComponent;

import java.util.ArrayList;
import java.util.List;

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

	List<Integer> getValori();

	void setValori(List<Integer> valori);

	IStrategiaComponent getChild();

	void setChild(IStrategiaComponent child);

	void setVera(boolean vera);

	boolean getVera();
}