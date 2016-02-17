package Shared.Domain;

import Shared.Domain.Azioni.IAzione;
import Shared.Domain.Condizioni.ICondizione;
import Shared.Domain.Creator.AzioneCreator.IAzioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Strategia implements Serializable {
		private static final long serialVersionUID=1;
        private List<IStrategiaComponent> conditionBlock;
		private IStrategiaComponent defaultCondition;
        private String nome;
		private boolean isComplete;
        private AtomicInteger count;
		private String id;

    public List<IStrategiaComponent> getConditionBlock() {
        return conditionBlock;
    }

    public void setConditionBlock(List<IStrategiaComponent> conditionBlock) {
        this.conditionBlock = conditionBlock;
    }

    public IStrategiaComponent getDefaultCondition() {
        return defaultCondition;
    }

    public void setDefaultCondition(IStrategiaComponent defaultCondition) {
        this.defaultCondition = defaultCondition;
    }

    public String getNome() {
        return nome;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Strategia(ICondizioneCreator iCondizioneCreator) {
        this.count = new AtomicInteger(0);
        String idcond=((Integer)count.incrementAndGet()).toString();
        this.conditionBlock = new ArrayList<>();
        ArrayList<Integer> valori = new ArrayList<Integer>();
        this.defaultCondition = (IStrategiaComponent) iCondizioneCreator.doMakeCondizione(idcond,valori);
        this.nome = "";
        this.isComplete = false;

    }

	public Strategia() {
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

	public void aggiungiCondizioneAnnidata(ICondizioneCreator condizioneCreator, String idCondPadre, ArrayList<Integer> valori) {
		String idcond=((Integer)count.incrementAndGet()).toString();
		IStrategiaComponent condizione = (IStrategiaComponent) condizioneCreator.doMakeCondizione(idcond,valori);
		boolean trovato = false;
		ArrayList<IStrategiaComponent> foglie = this.getFoglie();
		IStrategiaComponent currentfoglia = null;
		for (int i=0; i<foglie.size() && !trovato; i++){
			currentfoglia=foglie.get(i);
			if (((ICondizione)currentfoglia).getIdCond().equals(idCondPadre)){
				trovato=true;
				currentfoglia.addChild(condizione);
			}
		}

	}

	public ArrayList<IStrategiaComponent> getFoglie(){
		ArrayList<IStrategiaComponent> result = new ArrayList<>();
		IStrategiaComponent currentLine = null;
		for (int i=0; i<conditionBlock.size(); i++){
			currentLine=conditionBlock.get(i);
			while (currentLine.getChild() != null){
				currentLine=currentLine.getChild();
			}
			result.add(currentLine);
		}
		return result;
	}

	/**
	 * 
	 * @param az
	 * @param valori
	 * @param idCond
	 */
	public void aggiungiAzione(IAzioneCreator az, int valori, String idCond) {
		ArrayList<IStrategiaComponent> foglie = this.getFoglie();

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