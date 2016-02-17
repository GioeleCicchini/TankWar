package Server;

import Server.Controller.ControllerFacade;
import Shared.Util.DTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gioele on 16/02/16.
 */
public class ConnectionListner {

    private ControllerFacade controllerFacade;
    private ServerSocket welcomeSocket = null;

    public  ConnectionListner(){

    }

    public void StartServer()  throws IOException {

        try {
            welcomeSocket = new ServerSocket(6789);
            System.out.println("Apertura Server");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){

            Socket connectionSocket = null;
            try {
                connectionSocket = welcomeSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ObjectInputStream objectInput = new ObjectInputStream(connectionSocket.getInputStream());
            DTO dto = null;
            try {
                dto = (DTO)objectInput.readObject();
                controllerFacade.ArrivaRichiesta(dto);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {

            }

        }


    }

    public void setControllerFacade(ControllerFacade controllerFacade) {
        this.controllerFacade = controllerFacade;
    }
}
