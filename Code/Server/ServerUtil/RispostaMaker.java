package Server.ServerUtil;

import Shared.Util.DTO;

/**
 * Created by Gioele on 05/03/2016.
 */
public class RispostaMaker {

    private static RispostaMaker singletonInstance = null;
    private DTO risposta;

    private RispostaMaker() {

    }

    public static RispostaMaker getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new RispostaMaker();
        }
        return singletonInstance;
    }

    public void ImmettiRisposta(DTO dto) {
        System.out.println("Immetto La risposta");

        this.risposta = dto;
    }

    public DTO PrelevaRisposta() {
        System.out.println("Prelevo La risposta");
        DTO risp = this.risposta;
        this.risposta = null;
        return risp;
    }


}
