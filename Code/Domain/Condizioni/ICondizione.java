package Domain;

public interface ICondizione {

	abstract boolean verificaSeVera();

	Azione getAzione();

	/**
	 * 
	 * @param valori
	 */
	void create(int valori);

}