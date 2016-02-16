package Domain;

import Domain.Creator.CodizioneCreator.DefaultCondizioneCreator;
import Domain.Creator.CodizioneCreator.ICondizioneCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoCondizioneCreator {

	public static CatalogoCondizioneCreator singletonInstance = null;

	private Map<String,ICondizioneCreator> condizioniCreators;

	private String defaultCreatorKey;


	private CatalogoCondizioneCreator() {
		this.condizioniCreators=new HashMap<>();
		ICondizioneCreator condizioneDefaultCreator=DefaultCondizioneCreator.getSingletonInstance();
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
	 * @param idCond id identificativo della generica condizione
	 */
	public ICondizioneCreator getCondizioneCreator(String idCond) {
		return null;
	}

	public ICondizioneCreator getCondizioneDeafultCreator(){
		return this.condizioniCreators.get(this.defaultCreatorKey);
	}

}