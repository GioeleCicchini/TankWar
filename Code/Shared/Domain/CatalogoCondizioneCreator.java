package Shared.Domain;


import Shared.Domain.Creator.CodizioneCreator.DefaultCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Shared.Domain.Creator.ICreator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CatalogoCondizioneCreator implements ICatalogo {

	private static CatalogoCondizioneCreator singletonInstance = null;

	private Map<String,ICreator> condizioniCreators;

	private String defaultCreatorKey;


	private CatalogoCondizioneCreator() {
		this.condizioniCreators=new HashMap<>();


        /*
        Reflections reflections = new Reflections("Code.Shared.Domain.Creator.CondizioneCreator");

        Set<Class<? extends ICondizioneCreator>> subTypes = reflections.getSubTypesOf(ICondizioneCreator.class);
        */

        ICreator condizioneDefaultCreator= DefaultCondizioneCreator.getSingletonInstance();
		this.defaultCreatorKey = condizioneDefaultCreator.getIdType();
		this.condizioniCreators.put(this.defaultCreatorKey, condizioneDefaultCreator);
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
	 * @param idType id identificativo della generica condizione
	 */
	public ICreator getCreator(String idType) {
		return this.condizioniCreators.get(idType);
	}

	@Override
	public Map<String, ICreator> getCreators() {
		return this.condizioniCreators;
	}

	public ICreator getCondizioneDefaultCreator(){
		return this.condizioniCreators.get(this.defaultCreatorKey);
	}

	public String getDefaultCreatorKey() {
		return defaultCreatorKey;
	}

	public void setDefaultCreatorKey(String defaultCreatorKey) {
		this.defaultCreatorKey = defaultCreatorKey;
	}

	public Map<String, ICreator> getCondizioniCreators() {
		return condizioniCreators;
	}

	public void setCreators(Map<String, ICreator> creators) {
		this.condizioniCreators = creators;
	}
}