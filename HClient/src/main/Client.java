/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import communication.Communication;
import form.FormLogin;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private void connect() throws IOException{
        Socket socket = new Socket("localhost",9000);
        System.out.println("Klijent je povezan...");
        Communication.getInstance().setSocket(socket);
        new FormLogin().setVisible(true);
    }
    
}
