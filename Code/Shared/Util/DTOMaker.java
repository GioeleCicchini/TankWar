package Shared.Util;

import Shared.Controllers.CreareStrategiaHandler;
import Shared.Domain.Player;

/**
 * Created by gioele on 04/03/16.
 */
public class DTOMaker {

    private static DTOMaker singletonInstance = null;


    private DTOMaker() {


    }

    public static DTOMaker getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new DTOMaker();
        }
        return singletonInstance;
    }

    public DTO getDatiLoginServerResponce(boolean trovato, Player player) {
        DTO dto = new DTO();
        if (trovato == true) {
            dto.setFunzione("UtenteTrovato");
            dto.aggiungiOggettoPersistente(player);
        } else {
            dto.setFunzione("UtenteNonTrovato");
        }

        return dto;
    }


    public DTO getEffettuaLoginDTO(String username, String password) {
        DTO dto = new DTO();
        dto.setFunzione("PrelevaPlayer");
        dto.aggiungiOggettoPersistente(username);
        dto.aggiungiOggettoPersistente(password);
        return dto;
    }


    public DTO getPlayerDTO() {

        DTO dto = new DTO();
        dto.setFunzione("RegistraPlayer");
        dto.aggiungiOggettoPersistente(CreareStrategiaHandler.getSingletonInstance().getCurrentPlayer());

        return dto;

    }

    public DTO getStrategiaDTO() {
        DTO dto = new DTO();
        dto.setFunzione("RegistraStrategia");
        Player player = CreareStrategiaHandler.getSingletonInstance().getCurrentPlayer();
        dto.aggiungiOggettoPersistente(player.getId());
        dto.aggiungiOggettoPersistente(player.getStrategieList().get(player.getStrategieList().size() - 1));
        return dto;

    }

    public DTO getStrategiaServerResponceDTO() {
        DTO dto = new DTO();
        dto.setFunzione("StrategiaRegistrata");

        return dto;

    }

    public DTO getPlayerAvversarioRandomDTO(String livello){
        DTO dto= new DTO();
        dto.setFunzione("PrelevaPlayerAvversarioRandom");
        dto.aggiungiOggettoPersistente(livello);
        return dto;
    }


    public DTO getCampoBattagliaRandomDTO(String livello) {
        DTO dto= new DTO();
        dto.setFunzione("PrelevaCampoBattagliaRandom");
        dto.aggiungiOggettoPersistente(livello);
        return dto;
    }
}
