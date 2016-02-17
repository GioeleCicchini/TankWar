package Server;

import Server.Controller.ControllerFacade;
import Server.Controller.ControllerPrelevaStrategiaObserver;
import Server.Controller.ControllerRegistraStrategiaObserver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ControllerPrelevaStrategiaObserver prelevaStrategiaObserver = new ControllerPrelevaStrategiaObserver();
        ControllerRegistraStrategiaObserver registraStrategiaObserver = new ControllerRegistraStrategiaObserver();

        ControllerFacade controllerFacade = new ControllerFacade();
        ConnectionListner entrataServer = new ConnectionListner();

        entrataServer.setControllerFacade(controllerFacade);

        controllerFacade.Attach(prelevaStrategiaObserver);
        controllerFacade.Attach(registraStrategiaObserver);



        entrataServer.StartServer();






    }
}
