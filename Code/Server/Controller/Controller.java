
package  Server.Controller;
/**
 * Created by gioele on 16/02/16.
 */
public interface Controller {

    public void Attach(Observer o);
    public void Detach(Observer o);
    public void Notify();

}
