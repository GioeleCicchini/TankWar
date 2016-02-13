package Domain.Condizioni;

import Domain.IAzione;

public class NemicoAvantiCondizione implements ICondizione {

	private int aParameter;
	/**
	 * Questo attributo rappresenta l'ordine di questa condizione all'interno della strategia.
	 */
	private int cardinalità;
	private int idCond;

    @Override
    public boolean verificaSeVera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAzione getAzione() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(int valori) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}