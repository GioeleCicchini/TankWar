package Shared.Domain;

import Shared.Domain.Caselle.ICasella;

/**
 * Created by gioele on 22/03/16.
 */
public class CampoBattaglia {

    private ICasella [][] campo;

    public void posizionaTank (ITank tank, int x, int y){

    }

    public int getDimensioneX(){
        return campo.length;
    }

    public int getDimensioneY(){
        return campo[0].length;
    }
}
