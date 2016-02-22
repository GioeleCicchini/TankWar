package Shared.Domain;

public interface IStrategiaComponent {

	/**
	 *
	 * @param c
	 */
	void addChild(IStrategiaComponent c);

	void removeChild();

	IStrategiaComponent getChild();
	String getId();
    void setId(String id);

}
