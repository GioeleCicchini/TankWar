package Server.ServerUtil;

import Shared.Util.DTO;
import org.hibernate.annotations.SourceType;

/**
 * Created by Gioele on 05/03/2016.
 */
public class RispostaMaker {

    private static RispostaMaker singletonInstance = null;
    private DTO risposta;

    public static RispostaMaker getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new RispostaMaker();
        }
        return singletonInstance;
    }

    private RispostaMaker(){

    }

    public void ImmettiRisposta(DTO dto){
        System.out.println("Immetto La risposta");

        this.risposta = dto;
    }

    public DTO PrelevaRisposta(){
        System.out.println("Prelevo La risposta");
        DTO risp = this.risposta;
        this.risposta = null;
        return risp;
    }


}
