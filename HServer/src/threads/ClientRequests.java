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
                Request request = (Request) receiver.receive();
                Response response = new Response();
                
                switch (request.getOperation()) {
                    case LOGIN:
                        recepcionist = (Recepcionist)request.getArgument();
                        recepcionist = Controller.getInstance().login(recepcionist);
                        response.setResult(recepcionist);
                        break;
                    default:
                        throw new AssertionError();
                }
                
                sender.send(response);
            } catch (Exception ex) {
                Logger.getLogger(ClientRequests.class.getName()).log(Level.SEVERE, null, ex);
            }         
            
        }
    }
    
    public Socket getSocket(){
        return socket;
    }
    
    
    void stopThread(){
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
