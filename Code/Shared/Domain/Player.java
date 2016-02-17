package Shared.Domain;

import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;


import java.io.Serializable;
import java.util.ArrayList;

public class Player  implements Serializable{

	private ArrayList<Strategia> strategieList;

	public Player() {
	}

	public Strategia iniziaNuovaStrategia(ICondizioneCreator condizioneCreator) {
		Strategia strategia = new Strategia(condizioneCreator);
		this.strategieList.add(strategia);
		return strategia;
	}

	public ArrayList<Strategia> getStrategieList() {
		return strategieList;
	}

	public void setStrategieList(ArrayList<Strategia> strategieList) {
		this.strategieList = strategieList;
	}
}