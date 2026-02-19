/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Person;
import domain.Recepcionist;
import java.util.List;
import repository.Repository;
import repository.db.impl.RepositoryDbGeneric;
import repository.db.impl.RepositoryDbRecepcionist;
import system_operations.AbstractGenericOperation;
import system_operations.person.AddPersonSO;
import system_operations.person.DeletePersonSO;
import system_operations.person.EditPersonSO;
import system_operations.recepcionist.LoginSo;
import system_operations.recepcionist.LogutSo;

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
    
    public void login(Recepcionist recepcionist) throws Exception{
        AbstractGenericOperation operation = new LoginSo();
        operation.execute(recepcionist);
    }
    
    public void logout(Recepcionist recepcionist) throws Exception{
        AbstractGenericOperation operation = new LogutSo();
        operation.execute(recepcionist);
    }
    
    public void addPerson(Person person) throws Exception{      
        AbstractGenericOperation operation = new AddPersonSO();
        operation.execute(person);
    }
    
    public void deletePerson(Person person) throws Exception{
        AbstractGenericOperation operation = new DeletePersonSO();
        operation.execute(person);
    }
    
    public void editPerson(Person person) throws Exception{
        AbstractGenericOperation operation = new EditPersonSO();
        operation.execute(person);
    }
}
