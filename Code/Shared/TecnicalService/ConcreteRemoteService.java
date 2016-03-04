package Shared.TecnicalService;

import Shared.Util.DTO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by gioele on 04/03/16.
 */
public class ConcreteRemoteService implements IComRemoteService {


    private static ConcreteRemoteService singletonInstance = null;


    public static ConcreteRemoteService getSingletonInstance()
    {
        if (singletonInstance == null)
        {
            singletonInstance = new ConcreteRemoteService();
        }
        return singletonInstance;
    }


    @Override
    public void Invia(DTO dto) throws IOException {
        Socket clientSocket = new Socket("localhost",6789);

        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
            objectOutput.writeObject(dto);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            clientSocket.close();
            System.out.println("Inviato al server");
        }




    }

    @Override
    public void Ricevi(DTO dto) {

    }
}
