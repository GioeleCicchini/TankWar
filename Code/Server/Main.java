package Server;

import Server.Controller.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ControllerPrelevaStrategiaObserver prelevaStrategiaObserver = new ControllerPrelevaStrategiaObserver();
        ControllerRegistraPlayerObserver registraPlayerObserver = new ControllerRegistraPlayerObserver();
        ControllerRegistraStrategiaObserver registraStrategiaObserver = new ControllerRegistraStrategiaObserver();
        ControllerPrelevaPlayerObserver prelevaPlayerObserver = new ControllerPrelevaPlayerObserver();
        ControllerPrelevaRandomAvversarioObserver prelevaRandomAvversarioObserver = new ControllerPrelevaRandomAvversarioObserver();




        ControllerFacade controllerFacade = new ControllerFacade();
        ConnectionListner entrataServer = new ConnectionListner();

        entrataServer.setControllerFacade(controllerFacade);

        controllerFacade.Attach(prelevaStrategiaObserver);
        controllerFacade.Attach(registraPlayerObserver);
        controllerFacade.Attach(registraStrategiaObserver);
        controllerFacade.Attach(prelevaPlayerObserver);
        controllerFacade.Attach(prelevaRandomAvversarioObserver);


        GeneraCampoBattagliaDemo campoBattagliaDemo = new GeneraCampoBattagliaDemo();

        entrataServer.StartServer();







    }
}
