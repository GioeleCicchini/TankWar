package Shared.Domain.Controllers;

import Shared.Domain.*;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Shared.Domain.Creator.ICreator;
import Shared.Util.DTO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
	public String scegliCondizione(String idTypeCond, boolean vera, List<Integer> valori) {
		ICatalogo ccc = StartUpHandler.getSingletonInstance().getCatalogoCondCreator();
		ICreator iCondizioneCreator = ccc.getCreator(idTypeCond);
		String idCondPadre = this.strategiaCorrente.aggiungiCondizione(iCondizioneCreator,vera,valori);
		return idCondPadre;
	}

	public String scegliCondizioneAnnidata(String idTypeCond, String idCondPadre, boolean vera, List<Integer> valori) {
        ICatalogo ccc = StartUpHandler.getSingletonInstance().getCatalogoCondCreator();
        ICreator iCondizioneCreator = ccc.getCreator(idTypeCond);//sta riga è poetica
        String NuovoIdCondPadre = this.strategiaCorrente.aggiungiCondizioneAnnidata(iCondizioneCreator, idCondPadre, vera, valori);
		return NuovoIdCondPadre;
	}

	/**
	 * 
	 * @param idTypeAz
	 * @param idCond
	 * @param valori
	 */
	public String associaAzione(String idTypeAz, String idCond, List<Integer> valori) {
		ICatalogo catalogoAzioneCreator= StartUpHandler.getSingletonInstance().getCatalogoAzCreator();
		ICreator ac = catalogoAzioneCreator.getCreator(idTypeAz);
		String idAzPadre = this.strategiaCorrente.aggiungiAzione(ac,valori,idCond);
		return idAzPadre;
	}

	public void iniziaNuovaStrategia() {
		ICatalogo catalogoCondizioneCreator = StartUpHandler.getSingletonInstance().getCatalogoCondCreator();
		ICreator condizioneDefaultCreator = ((CatalogoCondizioneCreator)catalogoCondizioneCreator).getCondizioneDefaultCreator();
		this.strategiaCorrente = currentPlayer.iniziaNuovaStrategia(condizioneDefaultCreator);
	}

	/**
	 * 
	 * @param idTypeAz
	 * @param valori
	 */
	public String scegliAzioneDefault(String idTypeAz, List<Integer> valori) {
		ICatalogo cac = StartUpHandler.getSingletonInstance().getCatalogoAzCreator();
		ICreator ac = cac.getCreator(idTypeAz);
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

	public void terminaStrategia() throws IOException {
		this.strategiaCorrente.setComplete(true);
		Socket clientSocket = new Socket("localhost",6789);


		try {

			ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());

			this.currentPlayer.setNome("Gioele");
			this.inserisciNomeStrategia("Prima Strategia");
			DTO dto = new DTO();
			dto.setFunzione("Registra");
			dto.aggiungiOggettoPersistente(this.currentPlayer);
			objectOutput.writeObject(dto);
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			clientSocket.close();
			System.out.println("Inviato al server");
		}
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