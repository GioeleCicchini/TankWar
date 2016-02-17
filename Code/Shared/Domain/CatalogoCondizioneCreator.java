package Shared.Domain;


import Shared.Domain.Creator.CodizioneCreator.DefaultCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;

import java.util.HashMap;
import java.util.Map;

public class CatalogoCondizioneCreator {

	public static CatalogoCondizioneCreator singletonInstance = null;

	private Map<String,ICondizioneCreator> condizioniCreators;

	private String defaultCreatorKey;


	private CatalogoCondizioneCreator() {
		this.condizioniCreators=new HashMap<>();
		ICondizioneCreator condizioneDefaultCreator= DefaultCondizioneCreator.getSingletonInstance();
		this.defaultCreatorKey = condizioneDefaultCreator.getIdType();
		this.condizioniCreators.put(this.defaultCreatorKey,condizioneDefaultCreator);
	}

	public static CatalogoCondizioneCreator getSingletonInstance()
	{
		if (singletonInstance == null)
		{
			singletonInstance= new CatalogoCondizioneCreator();
		}
		return singletonInstance;
	}

	/**
	 * 
	 * @param idTypeCond id identificativo della generica condizione
	 */
	public ICondizioneCreator getCondizioneCreator(String idTypeCond) {
		return this.condizioniCreators.get(idTypeCond);
	}

	public ICondizioneCreator getCondizioneDefaultCreator(){
		return this.condizioniCreators.get(this.defaultCreatorKey);
	}

}