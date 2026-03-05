/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Request;
import communication.Response;
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
    Socket socket;
    Sender sender;
    Receiver receiver;
    ServerThread server;
    Recepcionist recepcionist;

    public ClientRequests(ServerThread server, Socket socket) {
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {   
            
            try {
                Request request = (Request) new Receiver(socket).receive();
                Response response = new Response();
                sender.send(response);
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
                default:
                throw new AssertionError();
            }
    }
    
    private Response login(Request request) throws Exception{
        Response response = new Response();
        recepcionist = (Recepcionist)request.getArgument();
        try{
            recepcionist = Controller.getInstance().login(recepcionist);
            System.out.println("Uspesna prijava na sistem...");
            response.setResult(recepcionist);
            this.recepcionist = recepcionist;
        }catch(Exception ex){
            ex.printStackTrace();
            response.setException(ex);
            
        }
        
                
        response.setResult(recepcionist);
        return response;
    }
    
    
    void stopThread(){
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
