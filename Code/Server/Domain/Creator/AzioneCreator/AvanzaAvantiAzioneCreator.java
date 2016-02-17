package Domain.Creator.AzioneCreator;

import Domain.Azioni.AvanzaAvantiAzione;
import Domain.Azioni.IAzione;

import java.util.ArrayList;

public class AvanzaAvantiAzioneCreator implements IAzioneCreator {

	private static AvanzaAvantiAzioneCreator singletonInstance = null;

	private String idTypeAz;
	private String name;
	private String description;

	private AvanzaAvantiAzioneCreator() {
		this.name = "Avanza Avanti";
		this.description = "Quest'azione fa avanzare il Tank avanti";
		this.idTypeAz = "000";
	};

	public static AvanzaAvantiAzioneCreator getSingletonInstance ()
	{
		if (singletonInstance == null)
		{
			singletonInstance = new AvanzaAvantiAzioneCreator();
		}
		return singletonInstance;
	}

	public IAzione doMakeAzione(String idAz, ArrayList<Integer> valori) {
		IAzione avanzaAvantiAzione = new AvanzaAvantiAzione(this.name,this.description,this.idTypeAz,idAz,valori);
		return avanzaAvantiAzione;
	}
}