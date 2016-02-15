package Domain;

import Domain.Condizioni.ICondizione;
import Domain.Creator.CodizioneCreator.ICondizioneCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Strategia {
    
        private List<IStrategiaComponent> conditionBlock;
        private String nome;
	private boolean isComplete;
        private AtomicInteger count;

    public Strategia() {
        this.conditionBlock = new ArrayList<>();
        this.nome = "";
        this.isComplete = false;
        this.count= new AtomicInteger(0);
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
	 * @param cc
	 * @param valori
	 */
	public void aggiungiCondizione(ICondizioneCreator condizionecreator, ArrayList<Integer> valori) {
                String idcond=((Integer)count.incrementAndGet()).toString();
		ICondizione condizione = condizionecreator.doMakeCondizione(idcond,valori);
                this.conditionBlock.add((IStrategiaComponent) condizione);
	}

	/**
	 * 
	 * @param az
	 * @param valori
	 * @param idCond
	 */
	public void aggiungiAzione(IAzioneCreator az, int valori, String idCond) {
		// TODO - implement Strategia.aggiungiAzione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ac
	 * @param Valori
	 * @param idCond
	 */
	public void AggiungiAzione(IAzioneCreator ac, int Valori, String idCond) {
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