package Shared.Domain;

import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player  implements Serializable{
	private static Player singletonInstance=null;

	public static Player getSingletonInstance()
	{
		if (singletonInstance == null)
		{
			singletonInstance = new Player();
		}
		return singletonInstance;
	}


	private int id;
	private String nome;
	private List<Strategia> strategieList = new ArrayList<Strategia>();

	private Player() {
	}

	public Strategia iniziaNuovaStrategia(ICondizioneCreator condizioneCreator) {
		Strategia strategia = new Strategia(condizioneCreator);
		this.strategieList.add(strategia);
		return strategia;
	}

	public List<Strategia> getStrategieList() {
		return strategieList;
	}

	public void setStrategieList(List<Strategia> strategieList) {
		this.strategieList = strategieList;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}
}