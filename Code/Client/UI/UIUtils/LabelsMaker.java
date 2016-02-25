package Client.UI.UIUtils;

import Client.UI.JavaFX.CustomWidget.ConditionCreatorLabel;
import Client.UI.JavaFX.CustomWidget.ICustomLabel;
import Shared.Domain.Creator.CodizioneCreator.ICondizioneCreator;
import Shared.Domain.Creator.ICreator;
import Shared.Domain.ICatalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by beniamino on 25/02/16.
 */
public class LabelsMaker {

    //TODO Il metodo seguente non è flessibile, nw vorrei uno unico per Condition e Action. Occorrono pattern?

    public List<ICustomLabel> getConditionLabels (ICatalogo catalogo){
        List<ICustomLabel> customLabels = new ArrayList<>();
        Map<String, ICreator> creators = catalogo.getCreators();
        for (String id: creators.keySet()) {
            ICreator currentCreator = creators.get(id);
            String name = currentCreator.getName();
            String description = currentCreator.getDescription();
            ICustomLabel myLabel = new ConditionCreatorLabel(id,name,description);
            ((ConditionCreatorLabel)myLabel).setText(currentCreator.getName());
            ((ConditionCreatorLabel)myLabel).setDescription(currentCreator.getDescription());
            ((ConditionCreatorLabel)myLabel).setVisible(true);
            //TODO diamogli un colore
            customLabels.add(myLabel);
        }
        return customLabels;
    }

}
