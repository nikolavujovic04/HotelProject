/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Recepcionist;
import java.util.List;
import repository.Repository;
import repository.db.DatabaseBroker;
import repository.db.impl.RepositoryDbGeneric;
import repository.db.impl.RepositoryDbRecepcionist;

/**
 *
 * @author Nikola
 */
public class Controller {
    private RepositoryDbRecepcionist user;
    private Repository repositoryGeneric;
    private static Controller instance;
    

    public Controller() {
        this.user = new RepositoryDbRecepcionist();
    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    private Recepcionist login(Recepcionist recepcionist) throws Exception{
        List<Recepcionist> recepcionists = repositoryGeneric.getAll(new Recepcionist());
        
        for (Recepcionist check : recepcionists) {
            if(check!=null){
                if(check.getUsername().equals(recepcionist.getUsername())&&check.getPassword().equals(recepcionist.getPassword())){
                    user.setUserLoggedIn(recepcionist);
                    return check;
                }
            }
        }
        
        return null;
    }
    
}
