/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threads;
import constant.ServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class ServerThread extends Thread{
    ServerSocket serverSocket;
    List<ClientRequests> clients;

    public ServerThread() throws FileNotFoundException, IOException{
        Properties properties = new Properties();
        properties.load(new FileInputStream(ServerConstants.SERVER_CONFIG_FILE_PATH));
        String port = properties.getProperty(ServerConstants.SERVER_CONFIG_PORT);
        serverSocket = new ServerSocket(Integer.parseInt(port));
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        try{
            while(!serverSocket.isClosed()){
                System.out.println("Waiting for clients");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                
                ClientRequests clientRequest = new ClientRequests(this, socket);
                clients.add(clientRequest);
                clientRequest.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopServer(){
        for (ClientRequests client : clients) {
        }
    }
    
}
