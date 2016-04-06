package Server.Controller;

/**
 * Created by Gioele on 06/04/2016.
 */
public class ControllerPrelevaCampoBattagliaRandomObserver implements Observer {
    @Override
    public void update(ControllerFacade controller) {
        if (controller.getFunzione().equals("PrelevaCampoBattagliaRandom")) {

            System.out.println("Prelevo un campo random");

        }
    }
}
