package Server;

import Server.Controller.ControllerFacade;
import Server.Controller.ControllerPrelevaStrategiaObserver;
import Server.Controller.ControllerRegistraPlayerObserver;

public class Main {

    public static void main(String[] args) throws Exception {

        ControllerPrelevaStrategiaObserver prelevaStrategiaObserver = new ControllerPrelevaStrategiaObserver();
        ControllerRegistraPlayerObserver registraStrategiaObserver = new ControllerRegistraPlayerObserver();

        ControllerFacade controllerFacade = new ControllerFacade();
        ConnectionListner entrataServer = new ConnectionListner();

        entrataServer.setControllerFacade(controllerFacade);

        controllerFacade.Attach(prelevaStrategiaObserver);
        controllerFacade.Attach(registraStrategiaObserver);

        entrataServer.StartServer();






    }
}
