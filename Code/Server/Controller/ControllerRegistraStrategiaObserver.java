package Server.Controller;

import Server.ServerUtil.HibernateUtil;
import Shared.Domain.Strategia;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by gioele on 16/02/16.
 */
public class ControllerRegistraStrategiaObserver implements Observer{

    public ControllerRegistraStrategiaObserver(){



    }

    @Override
    public void update(ControllerFacade controller) {

        if(controller.getFunzione().equals("Registra")){

            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                session.save(((Strategia)controller.getOggettiPersistenti().get(0)));
                session.getTransaction().commit();
            }
            catch (HibernateException e) {
                e.printStackTrace();
                session.getTransaction().rollback();

            }


            System.out.println("registro la strategia");
           System.out.println(((Strategia)controller.getOggettiPersistenti().get(0)).getDefaultCondition().getId());

        }

    }
}
