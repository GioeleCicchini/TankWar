package Domain.Creator.CodizioneCreator;

import Domain.Condizioni.ICondizione;
import java.util.ArrayList;

public class NemicoAvantiCondizioneCreator implements ICondizioneCreator {

	private static String idType = "001";
	private static String name;
	private static String description;

    @Override
    public ICondizione doMakeCondizione(ArrayList<Integer> valori) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}