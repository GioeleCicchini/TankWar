package Shared.Domain;

import Shared.Domain.Creator.AzioneCreator.IAzioneCreator;
import Shared.Domain.Creator.CodizioneCreator.DefaultCondizioneCreator;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Shared.Domain.Creator.ICreator;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Strategia implements Serializable {
		private static final long serialVersionUID=1;
        private List<IStrategiaComponent> conditionBlock;
		private IStrategiaComponent defaultCondition;
        private String nome;
		private boolean isComplete;

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

    public Strategia(ICreator iCondizioneCreator) {

        String idcond= UUID.randomUUID().toString();
		System.out.println(idcond);
		this.id = UUID.randomUUID().toString();
        this.conditionBlock = new ArrayList<IStrategiaComponent>();
        ArrayList<Integer> valori = new ArrayList<Integer>();
		//TODO Poca flessibilità
        this.defaultCondition = (IStrategiaComponent) ((DefaultCondizioneCreator)iCondizioneCreator).doMakeCondizione(idcond,true,valori);
        this.nome = "";
        this.isComplete = false;

    }

	public Strategia() {
	}

	public String aggiungiAzioneDefault(ICreator iAzioneCreator, ArrayList<Integer> valori) {
        String idAzione = UUID.randomUUID().toString();
        IStrategiaComponent azione = (IStrategiaComponent) ((IAzioneCreator)iAzioneCreator).doMakeAzione(idAzione,valori);
        this.defaultCondition.addChild(azione);
        return idAzione;
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
	public String aggiungiCondizione(ICreator condizionecreator, boolean vera, ArrayList<Integer> valori) {
		String idcond= UUID.randomUUID().toString();
		System.out.println(idcond);


		IStrategiaComponent condizione = (IStrategiaComponent) ((ICondizioneCreator)condizionecreator).doMakeCondizione(idcond,vera,valori);
		System.out.println(condizione.getId());

		this.conditionBlock.add(condizione);
		return idcond;
	}

	public String aggiungiCondizioneAnnidata(ICreator condizioneCreator, String idCondPadre, boolean vera, ArrayList<Integer> valori) {
		String idcond= UUID.randomUUID().toString();
		IStrategiaComponent condizione = (IStrategiaComponent) ((ICondizioneCreator)condizioneCreator).doMakeCondizione(idcond,vera,valori);
		boolean trovato = false;
		ArrayList<IStrategiaComponent> padriFoglie = this.getPadriFoglie();
		IStrategiaComponent currentfoglia = null;
		IStrategiaComponent padre = null;
		for (int i=0; i<padriFoglie.size() && !trovato; i++){
			padre = padriFoglie.get(i);
			currentfoglia=padre.getChild();
			if (currentfoglia != null) {
				if (currentfoglia.getId().equals(idCondPadre)){
					trovato=true;
					currentfoglia.addChild(condizione);
				}
			} else {
				if (padre.getId().equals(idCondPadre)) {
					trovato = true;
					padre.addChild(condizione);
				}
			}

		}
		return idcond;
	}

    public ArrayList<IStrategiaComponent> getPadriFoglie(){ //It doesn't work
        ArrayList<IStrategiaComponent> result = new ArrayList<>();
        IStrategiaComponent padreCurrentLine = null;
		IStrategiaComponent currentLine = null;
        for (int i=0; i<conditionBlock.size(); i++){
            padreCurrentLine=conditionBlock.get(i);
			currentLine = padreCurrentLine;
            while (currentLine.getChild() != null){
                currentLine=currentLine.getChild();
				if (currentLine.getChild() != null) {
					padreCurrentLine = currentLine;
				}
            }
            result.add(padreCurrentLine);
        }
        return result;
    }

	/**
	 * 
	 * @param az
	 * @param valori
	 * @param idCond
	 */
	public String aggiungiAzione(ICreator az, ArrayList<Integer> valori, String idCond) {
		ArrayList<IStrategiaComponent> padriFoglie = this.getPadriFoglie();
		String idAz = UUID.randomUUID().toString();
		IStrategiaComponent azione = (IStrategiaComponent) ((IAzioneCreator)az).doMakeAzione(idAz,valori);
		boolean trovato = false;
		IStrategiaComponent currentfoglia = null;
		for (int i=0; i<padriFoglie.size() && !trovato; i++){
			currentfoglia = padriFoglie.get(i).getChild();
			if (currentfoglia.getId().equals(idCond)){
				trovato=true;
				currentfoglia.addChild(azione);
			}
		}
		return idAz;

	}


	/**
	 * 
	 * @param nomeStrategia
	 */
	public void setNome(String nomeStrategia) {
		this.nome = nomeStrategia;
	}

	public void rimuoviComponente(String id) {
		IStrategiaComponent currentPadreFoglia = null;
        IStrategiaComponent currentFoglia = null;
        ArrayList<IStrategiaComponent> padriFoglie = this.getPadriFoglie();
        boolean trovato = false;
        for (int i=0; i<padriFoglie.size() && !trovato; i++) {
            currentPadreFoglia = padriFoglie.get(i);
            currentFoglia = currentPadreFoglia;
            if (currentPadreFoglia.getChild() != null) {
                currentFoglia = currentPadreFoglia.getChild();
                if (currentFoglia.getId().equals(id)) {
                    trovato = true;
                    currentPadreFoglia.removeChild();
                }
            } else {
                if (currentFoglia.getId().equals(id)) {
                    trovato = true;
                    this.conditionBlock.remove(i);
                }
            }
        }
	}
}