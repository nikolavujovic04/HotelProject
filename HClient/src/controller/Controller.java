/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import communication.Operation;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import domain.Person;
import domain.PersonCategorie;
import domain.Recepcionist;
import domain.Room;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Controller {
    private static Controller instance;
    private Recepcionist currentRecepcionist;

    private Controller() {
    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        
        return instance;
    }
    
    public Recepcionist login(String username, String password) throws IOException, Exception{
        Recepcionist recepcionist = new Recepcionist();
        recepcionist.setUsername(username);
        recepcionist.setPassword(password);
        
        Request request = new Request(Operation.LOGIN,recepcionist);
        Response response = Communication.getInstance().login(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            Recepcionist re = (Recepcionist) response.getResult();
            return re;
        }else{
            throw response.getException();
        }
    }
    
    public List<PersonCategorie> getAllCategories() throws Exception{
        Request request = new Request(Operation.GET_ALL_CATEGORIES,null);
        Response response = Communication.getInstance().getAllCategories(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            List<PersonCategorie> categories = (List<PersonCategorie>) response.getResult();
            return categories;
        }else{
            throw response.getException();
        }
    }
    
    public void addPerson(Person person) throws IOException, Exception{
        Request request = new Request(Operation.ADD_PERSON, person);
        Response response = Communication.getInstance().addPerson(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
    
    public void addPersonCategorie(PersonCategorie categorie) throws IOException, Exception{
        Request request = new Request(Operation.ADD_PERSON_CATEGORIE, categorie);
        Response response = Communication.getInstance().addPersonCategorie(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
    
    public void addRecepcionist(Recepcionist recepcionist) throws IOException, Exception{
        Request request = new Request(Operation.ADD_RECEPCIONIST, recepcionist);
        Response response = Communication.getInstance().addRecepcionist(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
    
    public void addRoom(Room room) throws IOException, Exception{
        Request request = new Request(Operation.ADD_ROOM, room);
        Response response = Communication.getInstance().addRecepcionist(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
    
    public List<Room> getAllRooms() throws Exception{
        Request request = new Request(Operation.GET_ALL_ROOMS,null);
        Response response = Communication.getInstance().getAllRooms(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            List<Room> rooms = (List<Room>) response.getResult();
            return rooms;
        }else{
            throw response.getException();
        }
    }
        
    public List<Person> getAllPersons() throws Exception{
        Request request = new Request(Operation.GET_ALL_PERSONS,null);
        Response response = Communication.getInstance().getAllPersons(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            List<Person> persons = (List<Person>) response.getResult();
            return persons;
        }else{
            throw response.getException();
        }
    }
    
    public List<Recepcionist> getAllRecepcionists() throws Exception{
        Request request = new Request(Operation.GET_ALL_RECEPCIONISTS,null);
        Response response = Communication.getInstance().getAllRecepcionists(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            List<Recepcionist> recepcionists = (List<Recepcionist>) response.getResult();
            return recepcionists;
        }else{
            throw response.getException();
        }
    }
    
    public void deletePerson(Person person) throws IOException, Exception{
        Request request = new Request(Operation.DELETE_PERSON,person);
        Response response = Communication.getInstance().deletePerson(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
    
    public void setCurrentUser(Recepcionist user){
        this.currentRecepcionist = user;
    }
}
