package Shared.Domain;


import Shared.Domain.Creator.ICreator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player  implements Serializable{

	private String id;
	private String nome;
	private List<Strategia> strategieList;

	public Player() {
		this.strategieList = new ArrayList<>();
		//this.id =  UUID.randomUUID().toString(); alla fine

		this.id = new String("1");  // Provvisorio quando avremo il login da vedere
	}

	public Strategia iniziaNuovaStrategia(ICreator condizioneCreator) {
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

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(String id) {
		this.id = id;
	}



	public void aggiungiStrategia(Strategia strategia){

		this.strategieList.add(strategia);


	}

}