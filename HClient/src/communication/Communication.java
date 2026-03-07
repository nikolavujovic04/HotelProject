/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Nikola
 */
public class Communication {
    private static Communication instance;
    private Socket socket;
    
    private Communication(){
    }
    
    public static Communication getInstance() throws IOException{
        if(instance==null){
            instance = new Communication();
        }
        
        return instance;
    }
    
    public void setSocket(Socket socket){
        this.socket = socket;
    }
    
    public Response login(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat");
        return (Response)new Receiver(socket).receive();
    }
    
    public Response getAllCategories(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za kategorije je poslat");
        return (Response)new Receiver(socket).receive();
    }
    
    public Response addPerson(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za kreiranje osobe je poslat");
        return (Response)new Receiver(socket).receive();
    }
    
    public Response addPersonCategorie(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za kreiranje kategorije osobe je poslat");
        return (Response)new Receiver(socket).receive();
    }
    
    public Response addRecepcionist(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za kreiranje recepcionara je poslat");
        return (Response)new Receiver(socket).receive();
    }
    
}
