package Shared.TecnicalService;

import Shared.Util.DTO;

import java.io.IOException;

/**
 * Created by gioele on 04/03/16.
 */
public interface IComRemoteService {

    void Invia(DTO dto) throws IOException;
    void Ricevi(DTO dto);

}
