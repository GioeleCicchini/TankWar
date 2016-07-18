package Server.UI.View;

import Server.ConnectionListner;
import Server.Controller.*;
import Server.GeneraCampoBattagliaDemo;
import Server.ServerUtil.HibernateUtil;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gioele on 14/07/2016.
 */
public class ControlloreMainView implements Initializable {


    public TextField UsernameDB;
    public TextField PasswordDB;
    public TextField IndirizzoIp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }




    public void StabilisciConnessione(){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); //hibernate config xml file name
        cfg.getProperties().setProperty("hibernate.connection.password",PasswordDB.getText());
        cfg.getProperties().setProperty("hibernate.connection.username",UsernameDB.getText());
        cfg.getProperties().setProperty("hibernate.connection.url","jdbc:mysql://"+IndirizzoIp.getText());
        HibernateUtil.sessionFactory = cfg.buildSessionFactory();



    }





    public void ApriServer(Event event) throws IOException {

        StabilisciConnessione();

        ControllerPrelevaStrategiaObserver prelevaStrategiaObserver = new ControllerPrelevaStrategiaObserver();
        ControllerRegistraPlayerObserver registraPlayerObserver = new ControllerRegistraPlayerObserver();
        ControllerRegistraStrategiaObserver registraStrategiaObserver = new ControllerRegistraStrategiaObserver();
        ControllerPrelevaPlayerObserver prelevaPlayerObserver = new ControllerPrelevaPlayerObserver();
        ControllerPrelevaRandomAvversarioObserver prelevaRandomAvversarioObserver = new ControllerPrelevaRandomAvversarioObserver();
        ControllerPrelevaCampoBattagliaRandomObserver prelevaCampoBattagliaRandomObserver = new ControllerPrelevaCampoBattagliaRandomObserver();




        ControllerFacade controllerFacade = new ControllerFacade();
        ConnectionListner entrataServer = new ConnectionListner();

        entrataServer.setControllerFacade(controllerFacade);

        controllerFacade.Attach(prelevaStrategiaObserver);
        controllerFacade.Attach(registraPlayerObserver);
        controllerFacade.Attach(registraStrategiaObserver);
        controllerFacade.Attach(prelevaPlayerObserver);
        controllerFacade.Attach(prelevaRandomAvversarioObserver);
        controllerFacade.Attach(prelevaCampoBattagliaRandomObserver);

          //  GeneraCampoBattagliaDemo campoBattagliaDemo = new GeneraCampoBattagliaDemo();

        entrataServer.StartServer();


    }
}
