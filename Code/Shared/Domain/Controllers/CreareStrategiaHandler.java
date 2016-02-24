package Shared.Domain.Controllers;

import Shared.Domain.CatalogoAzioneCreator;
import Shared.Domain.CatalogoCondizioneCreator;
import Shared.Domain.Creator.AzioneCreator.IAzioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Shared.Domain.Player;
import Shared.Domain.Strategia;

import java.util.ArrayList;

public class CreareStrategiaHandler {

	private static CreareStrategiaHandler singletonInstance = null;

	private Player currentPlayer;
	private Strategia strategiaCorrente;

	private CreareStrategiaHandler() {

	}

	public static CreareStrategiaHandler getSingletonInstance()
	{
		if (singletonInstance == null)
		{
			singletonInstance = new CreareStrategiaHandler();
		}
		return singletonInstance;
	}

	/**
	 * 
	 * @param idTypeCond
	 * @param valori
	 */
	public String scegliCondizione(String idTypeCond, boolean vera, ArrayList<Integer> valori) {
		CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();
		ICondizioneCreator iCondizioneCreator = ccc.getCondizioneCreator(idTypeCond);
		String idCondPadre = this.strategiaCorrente.aggiungiCondizione(iCondizioneCreator,vera,valori);
		return idCondPadre;
	}

	public String scegliCondizioneAnnidata(String idTypeCond, String idCondPadre, boolean vera, ArrayList<Integer> valori) {
        CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();
        ICondizioneCreator iCondizioneCreator = ccc.getCondizioneCreator(idTypeCond);
        String NuovoIdCondPadre = this.strategiaCorrente.aggiungiCondizioneAnnidata(iCondizioneCreator, idCondPadre, vera, valori);
		return NuovoIdCondPadre;
	}

	/**
	 * 
	 * @param idTypeAz
	 * @param idCond
	 * @param valori
	 */
	public String associaAzione(String idTypeAz, String idCond, ArrayList<Integer> valori) {
		CatalogoAzioneCreator catalogoAzioneCreator= CatalogoAzioneCreator.getSingletonInstance();
		IAzioneCreator ac = catalogoAzioneCreator.getAzioneCreator(idTypeAz);
		String idAzPadre = this.strategiaCorrente.aggiungiAzione(ac,valori,idCond);
		return idAzPadre;
	}

	public void iniziaNuovaStrategia() {
		CatalogoCondizioneCreator catalogoCondizioneCreator = CatalogoCondizioneCreator.getSingletonInstance();
		ICondizioneCreator iCondizioneCreator = catalogoCondizioneCreator.getCondizioneDefaultCreator();
		this.strategiaCorrente = currentPlayer.iniziaNuovaStrategia(iCondizioneCreator);
	}

	/**
	 * 
	 * @param idTypeAz
	 * @param valori
	 */
	public String scegliAzioneDefault(String idTypeAz, ArrayList<Integer> valori) {
		CatalogoAzioneCreator cac = CatalogoAzioneCreator.getSingletonInstance();
		IAzioneCreator ac = cac.getAzioneCreator(idTypeAz);
		String idAzDefault = this.strategiaCorrente.aggiungiAzioneDefault(ac,valori);
		return idAzDefault;
	}

	/**
	 * 
	 * @param nomeStrategia
	 */
	public void inserisciNomeStrategia(String nomeStrategia) {
		this.strategiaCorrente.setNome(nomeStrategia);
	}

	public void rimuoviComponente(String id) {
		this.strategiaCorrente.rimuoviComponente(id);
	}

	public void terminaStrategia() {
		this.strategiaCorrente.setComplete(true);
	}


	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Strategia getStrategiaCorrente() {
		return strategiaCorrente;
	}

	public void setStrategiaCorrente(Strategia strategiaCorrente) {
		this.strategiaCorrente = strategiaCorrente;
	}
}