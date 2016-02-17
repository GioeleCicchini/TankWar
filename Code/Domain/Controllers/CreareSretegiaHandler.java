package Domain.Controllers;

import Domain.CatalogoCondizioneCreator;
import Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Domain.Player;
import Domain.Strategia;

import java.util.ArrayList;

public class CreareSretegiaHandler {

	private static CreareSretegiaHandler singletonInstance = null;

	private Player currentPlayer;
	private Strategia strategiaCorrente;

	private CreareSretegiaHandler() {

	}

	public static CreareSretegiaHandler getSingletonInstance()
	{
		if (singletonInstance == null)
		{
			singletonInstance = new CreareSretegiaHandler();
		}
		return singletonInstance;
	}

	/**
	 * 
	 * @param idTypeCond
	 * @param valori
	 */
	public void scegliCondizione(String idTypeCond, ArrayList<Integer> valori) {
		CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();
		ICondizioneCreator iCondizioneCreator = ccc.getCondizioneCreator(idTypeCond);
		this.strategiaCorrente.aggiungiCondizione(iCondizioneCreator,valori);
	}

	public void scegliCondizioneAnnidata(String idTypeCond, String idCondPadre, ArrayList<Integer> valori) {
        CatalogoCondizioneCreator ccc = CatalogoCondizioneCreator.getSingletonInstance();
        ICondizioneCreator iCondizioneCreator = ccc.getCondizioneCreator(idTypeCond);
        this.strategiaCorrente.aggiungiCondizioneAnnidata(iCondizioneCreator, idCondPadre, valori);
	}

	/**
	 * 
	 * @param idTypeAz
	 * @param idCond
	 * @param valori
	 */
	public void associaAzione(String idTypeAz, String idCond, int valori) {
		// TODO - implement CreareSretegiaHandler.associaAzione
		throw new UnsupportedOperationException();
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
	public void scegliAzioneDefault(String idTypeAz, int valori) {
		// TODO - implement CreareSretegiaHandler.scegliAzioneDefault
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nomeStrategia
	 */
	public void inserisciNomeStrategia(String nomeStrategia) {
		// TODO - implement CreareSretegiaHandler.inserisciNomeStrategia
		throw new UnsupportedOperationException();
	}

	public void terminaStrategia() {
		// TODO - implement CreareSretegiaHandler.terminaStrategia
		throw new UnsupportedOperationException();
	}

}