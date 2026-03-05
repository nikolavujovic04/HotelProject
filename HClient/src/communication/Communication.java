/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Recepcionist;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Nikola
 */
public class Communication {
    private static Communication instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    
    private Communication() throws IOException{
        this.socket = new Socket("localhost",9000);
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }
    
    public static Communication getInstance() throws IOException{
        if(instance==null){
            instance = new Communication();
        }
        
        return instance;
    }
    
    public Recepcionist login(Recepcionist check) throws Exception{
        Recepcionist recepcionist = new Recepcionist();
        recepcionist.setUsername(check.getUsername());
        recepcionist.setPassword(check.getPassword());
        
        Request request = new Request(Operation.LOGIN,recepcionist);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (Recepcionist) response.getResult();
        }else{
            throw response.getException();
        }
    }
}
