package Domain;

public class Strategia {

	private boolean isComplete;
	private string nome;

	public boolean getIsComplete() {
		return this.isComplete;
	}

	/**
	 * 
	 * @param isComplete
	 */
	public void setIsComplete(int isComplete) {
		// TODO - implement Strategia.setIsComplete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cc
	 * @param valori
	 */
	public void creaCondizione(ICondizioneCreator cc, int valori) {
		// TODO - implement Strategia.creaCondizione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param az
	 * @param valori
	 * @param idCond
	 */
	public void aggiungiAzione(IAzioneCreator az, int valori, string idCond) {
		// TODO - implement Strategia.aggiungiAzione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ac
	 * @param Valori
	 * @param idCond
	 */
	public void AggiungiAzione(IAzioneCreator ac, int Valori, string idCond) {
		// TODO - implement Strategia.AggiungiAzione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nomeStrategia
	 */
	public void setNome(string nomeStrategia) {
		this.nome = nomeStrategia;
	}

}