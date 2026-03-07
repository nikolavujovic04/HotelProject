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
        
    public void setCurrentUser(Recepcionist user){
        this.currentRecepcionist = user;
    }
}
