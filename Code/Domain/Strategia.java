package Domain;

import Domain.Azioni.IAzione;
import Domain.Creator.CodizioneCreator.ICondizioneCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Strategia {
    
        private List<IStrategiaComponent> conditionBlock;
		private IStrategiaComponent defaultCondition;
        private String nome;
		private boolean isComplete;
        private AtomicInteger count;

    public Strategia(ICondizioneCreator iCondizioneCreator) {
        this.count = new AtomicInteger(0);
        String idcond=((Integer)count.incrementAndGet()).toString();
        this.conditionBlock = new ArrayList<>();
        ArrayList<Integer> valori = new ArrayList<Integer>();
        this.defaultCondition = (IStrategiaComponent) iCondizioneCreator.doMakeCondizione(idcond,valori);
        this.nome = "";
        this.isComplete = false;

    }

        

	public boolean getIsComplete() {
		return this.isComplete;
	}

	/**
	 * 
	 * @param isComplete
	 */
	public void setIsComplete(boolean isComplete) {
		this.isComplete=isComplete;
	}

	/**
	 * 
	 * @param condizionecreator
	 * @param valori
	 */
	public void aggiungiCondizione(ICondizioneCreator condizionecreator, ArrayList<Integer> valori) {
		String idcond=((Integer)count.incrementAndGet()).toString();
		IStrategiaComponent condizione = (IStrategiaComponent) condizionecreator.doMakeCondizione(idcond,valori);
		this.conditionBlock.add(condizione);
	}

	/**
	 * 
	 * @param az
	 * @param valori
	 * @param idCond
	 */
	public void aggiungiAzione(IAzione az, int valori, String idCond) {
		// TODO - implement Strategia.aggiungiAzione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ac
	 * @param Valori
	 * @param idCond
	 */
	public void AggiungiAzione(IAzione ac, int Valori, String idCond) {
		// TODO - implement Strategia.AggiungiAzione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nomeStrategia
	 */
	public void setNome(String nomeStrategia) {
		this.nome = nomeStrategia;
	}

}