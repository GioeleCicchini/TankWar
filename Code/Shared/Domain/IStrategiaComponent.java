package Shared.Domain;

public interface IStrategiaComponent {

	/**
	 *
	 * @param c
	 */
	void addChild(IStrategiaComponent c);

	void removeChild();

	IStrategiaComponent getChild();
	void setChild(IStrategiaComponent child);
	String getId();
    void setId(String id);

}
