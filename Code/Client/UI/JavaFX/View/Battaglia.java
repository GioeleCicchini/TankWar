package Client.UI.JavaFX.View;

import Client.UI.UIUtils.ViewTransaction;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gioele on 22/03/16.
 */
public class Battaglia implements Initializable {

    public Button indietroButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }




    public void indietro(Event event){
        ViewTransaction.getSingletonInstance().goToHome(indietroButton);

    }
}
