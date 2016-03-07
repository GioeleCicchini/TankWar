package Shared.Domain;

import Shared.Domain.Creator.ICreator;

import java.util.Map;

/**
 * Created by beniamino on 25/02/16.
 */
public interface ICatalogo {
    public ICreator getCreator(String idType);
    public Map<String, ICreator> getCreators();
    public void setCreators(Map<String, ICreator> creators);
    public Map getMap();

}
