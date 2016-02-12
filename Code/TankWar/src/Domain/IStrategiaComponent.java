package Domain;

public interface IStrategiaComponent {

	/**
	 * 
	 * @param c
	 */
	void add(IStrategiaComponent c);

	/**
	 * 
	 * @param c
	 */
	void remove(IStrategiaComponent c);

	IStrategiaComponent getChild();

}