package Server;

import Server.Controller.ControllerFacade;
import Server.Controller.ControllerPrelevaStrategiaObserver;
import Server.Controller.ControllerRegistraPlayerObserver;
import Server.Controller.ControllerRegistraStrategiaObserver;

public class Main {

    public static void main(String[] args) throws Exception {

        ControllerPrelevaStrategiaObserver prelevaStrategiaObserver = new ControllerPrelevaStrategiaObserver();
        ControllerRegistraPlayerObserver registraPlayerObserver = new ControllerRegistraPlayerObserver();
        ControllerRegistraStrategiaObserver registraStrategiaObserver = new ControllerRegistraStrategiaObserver();

        ControllerFacade controllerFacade = new ControllerFacade();
        ConnectionListner entrataServer = new ConnectionListner();

        entrataServer.setControllerFacade(controllerFacade);

        controllerFacade.Attach(prelevaStrategiaObserver);
        controllerFacade.Attach(registraPlayerObserver);
        controllerFacade.Attach(registraStrategiaObserver);

        entrataServer.StartServer();






    }
}
