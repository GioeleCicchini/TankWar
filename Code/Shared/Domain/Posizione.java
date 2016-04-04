package Shared.Domain;

/**
 * Created by emanuele on 03/04/16.
 */
public class Posizione {

    private Integer x;
    private Integer y;

    public Posizione(Integer x, Integer y) {
        if (x>=0 && y>=0) {
            this.x = x;
            this.y = y;
        }
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
