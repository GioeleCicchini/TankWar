package Domain;

import Domain.Creator.CodizioneCreator.ICondizioneCreator;

import java.util.*;

public class Player {

	private ArrayList<Strategia> strategieList;

	public Strategia iniziaNuovaStrategia(ICondizioneCreator condizioneCreator) {
		Strategia strategia = new Strategia(condizioneCreator);
		this.strategieList.add(strategia);
		return strategia;
	}

}