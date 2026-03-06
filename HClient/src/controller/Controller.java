/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import communication.Operation;
import communication.Request;
import communication.Response;
import domain.Recepcionist;
import java.io.IOException;

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
        
    }
}
