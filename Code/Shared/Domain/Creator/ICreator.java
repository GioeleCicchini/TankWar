package Shared.Domain.Creator;

import Shared.Domain.IStrategiaComponent;

import java.util.ArrayList;

/**
 * Created by beniamino on 25/02/16.
 */
public interface ICreator {
    public String getIdType();
    public void setIdType(String idType);
    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);
    //TODO QUESTO è UN ALTRO PUNTO DI POCA FLESSIBILITà
    /*
    public IStrategiaComponent doMake (String idCond, boolean vera, ArrayList<Integer> valori);
    public IStrategiaComponent doMake (String idAz, ArrayList<Integer> valori);
    */
}
