import Controller.ControllerFacade;
import Controller.ControllerPrelevaStrategiaObserver;
import Controller.ControllerRegistraStrategiaObserver;
import Domain.Strategia;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ControllerPrelevaStrategiaObserver  prelevaStrategiaObserver = new ControllerPrelevaStrategiaObserver();
        ControllerRegistraStrategiaObserver registraStrategiaObserver = new ControllerRegistraStrategiaObserver();

        ControllerFacade controllerFacade = new ControllerFacade();
        ConnectionListner entrataServer = new ConnectionListner();

        entrataServer.setControllerFacade(controllerFacade);

        controllerFacade.Attach(prelevaStrategiaObserver);
        controllerFacade.Attach(registraStrategiaObserver);



        entrataServer.StartServer();






    }
}
