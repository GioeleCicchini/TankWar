package Shared.Util;

import Shared.Domain.Controllers.CreareStrategiaHandler;

/**
 * Created by gioele on 04/03/16.
 */
public class DTOMaker {

    private static DTOMaker singletonInstance = null;


    public static DTOMaker getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new DTOMaker();
        }
        return singletonInstance;
    }




    private DTOMaker(){


    }

    public DTO getPlayerDTO(){

        DTO dto = new DTO();
        dto.setFunzione("RegistraPlayer");
        dto.aggiungiOggettoPersistente(CreareStrategiaHandler.getSingletonInstance().getCurrentPlayer());

        return dto;

    }



}
