/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Controller;
import domain.Recepcionist;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class ClientRequests extends Thread{
    private Socket socket;
    private Recepcionist recepcionist;

    public ClientRequests(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {   
            
            try {
                Request request = (Request) new Receiver(socket).receive();
                System.out.println("STIGAO ZAHTEV: " + request.getOperation());
                Response response = handleRequest(request);
                new Sender(socket).send(response);
            } catch (Exception ex) {
                Logger.getLogger(ClientRequests.class.getName()).log(Level.SEVERE, null, ex);
            }         
            
        }
    }
    
    public Socket getSocket(){
        return socket;
    }
    
    private Response handleRequest(Request request) throws Exception{
        switch (request.getOperation()) {
            case LOGIN:
                return login(request);
            }
        
        return null;
    }
    
    private Response login(Request request) throws Exception{
        Response response = new Response();
        Recepcionist requestRecepcionist = (Recepcionist)request.getArgument();
        try{
            Recepcionist login = Controller.getInstance().login(requestRecepcionist);
            System.out.println("Uspesna prijava na sistem...");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(login);
            this.recepcionist = login;
        }catch(Exception ex){
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);    
        }
        
        return response;
    }
    
    private Response getAllCategories(Request request){
        Response response = new Response();
    }
    
    
    void stopThread(){
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
