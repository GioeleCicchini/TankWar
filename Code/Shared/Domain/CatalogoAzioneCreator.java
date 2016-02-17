package Shared.Domain;

import Shared.Domain.Creator.AzioneCreator.IAzioneCreator;

import java.util.HashMap;
import java.util.Map;

public class CatalogoAzioneCreator {

	public static CatalogoAzioneCreator singletonInstance = null;

    private Map<String,IAzioneCreator> azioniCreators;

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

	/**
	 * 
	 * @param idTypeAz
	 */
	public IAzioneCreator getAzioneCreator(String idTypeAz) {
        return this.azioniCreators.get(idTypeAz);
	}

}