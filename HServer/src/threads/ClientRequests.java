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
import domain.Person;
import domain.PersonCategorie;
import domain.Recepcionist;
import domain.Room;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
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
            case GET_ALL_CATEGORIES:
                return getAllCategories(request);
            case ADD_PERSON:
                return addPerson(request);
            case ADD_PERSON_CATEGORIE:
                return addPersonCategorie(request);
            case ADD_RECEPCIONIST:
                return addRecepcionist(request);
            case ADD_ROOM:
                return addRoom(request); 
            case GET_ALL_ROOMS:
                return getAllRooms(request);
            case GET_ALL_PERSONS:
                return getAllPersons(request);
            case GET_ALL_RECEPCIONISTS:
                return getAllRecepcionists(request);
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
        try {      
            List<PersonCategorie> requestCategories = Controller.getInstance().getAllCategories();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(requestCategories);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        
        return response;
    }
    
    private Response addPerson(Request request) throws Exception{
        Response response = new Response();
        try{
            Person person = (Person)request.getArgument();
            Controller.getInstance().addPerson(person);
            response.setResponseType(ResponseType.SUCCESS);
        }catch(Exception ex){
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(new Exception(ex.getMessage()));
        }
        
        
        return response;
    }
    
    private Response addPersonCategorie(Request request){
        Response response = new Response();
        try {           
            PersonCategorie categorie = (PersonCategorie)request.getArgument();
            Controller.getInstance().addPersonCategorie(categorie);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(new Exception(ex.getMessage()));
        }
        
        return response;
    }
    
    private Response addRecepcionist(Request request){
        Response response = new Response();
        try {           
            Recepcionist recepcionist = (Recepcionist)request.getArgument();
            Controller.getInstance().addRecepcionist(recepcionist);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(new Exception(ex.getMessage()));
        }
        
        return response;
    }
    
    private Response addRoom(Request request){
        Response response = new Response();
        try {           
            Room room = (Room)request.getArgument();
            Controller.getInstance().addRoom(room);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(new Exception(ex.getMessage()));
        }
        
        return response;
    }
    
    private Response getAllRooms(Request request){
        Response response = new Response();
        try {      
            List<Room> requestRooms = Controller.getInstance().getAllRooms();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(requestRooms);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        
        return response;
    }
    
    private Response getAllPersons(Request request){
        Response response = new Response();
        try {      
            List<Person> requestPersons = Controller.getInstance().getAllPersons();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(requestPersons);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        
        return response;
    }
    
    private Response getAllRecepcionists(Request request){
        Response response = new Response();
        try {      
            List<Recepcionist> requestRecepcionists = Controller.getInstance().getAllRecepcionists();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(requestRecepcionists);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        
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
