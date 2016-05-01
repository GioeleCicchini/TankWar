package Client.UI.JavaFX.View;

import Shared.Controllers.SimulareBattagliaHandler;

/**
 * Created by gioele on 01/05/16.
 */
public class Runnable implements java.lang.Runnable {
    @Override
    public void run() {

        SimulareBattagliaHandler.getSingletonInstance().faiMossa();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
