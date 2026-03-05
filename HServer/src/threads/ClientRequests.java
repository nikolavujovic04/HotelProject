/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Sender;
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

    public ClientRequests(ServerThread server, Socket socket) {
    }

    @Override
    public void run() {
        super.run(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
