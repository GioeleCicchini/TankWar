package Shared.Domain;

import Shared.Domain.Creator.ICreator;

import java.util.HashMap;
import java.util.Map;

public class CatalogoAzioneCreator implements ICatalogo {

	private static CatalogoAzioneCreator singletonInstance = null;

    private Map<String,ICreator> azioniCreators;

    private CatalogoAzioneCreator() {
        this.azioniCreators=new HashMap<>();

    }

    public static CatalogoAzioneCreator getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance= new CatalogoAzioneCreator();
        }
        return singletonInstance;
    }


    @Override
    public ICreator getCreator(String idType) {
        return this.azioniCreators.get(idType);
    }

    @Override
    public Map<String, ICreator> getCreators() {
        return this.azioniCreators;
    }

    @Override
    public void setCreators(Map<String, ICreator> creators) {
        this.azioniCreators=creators;
    }
}