/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Person;
import domain.PersonCategorie;
import domain.Recepcionist;
import java.util.List;
import repository.Repository;
import repository.db.impl.RepositoryDbRecepcionist;
import system_operations.AbstractGenericOperation;
import system_operations.person.AddPersonSO;
import system_operations.person.DeletePersonSO;
import system_operations.person.EditPersonSO;
import system_operations.personCategorie.AddPersonCategorieSO;
import system_operations.personCategorie.GetAllCategoriesSO;
import system_operations.recepcionist.AddRecepcionistSO;
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
    
    public Recepcionist login(Recepcionist recepcionist) throws Exception{
        AbstractGenericOperation operation = new LoginSo();
        operation.execute(recepcionist);
        return ((LoginSo)operation).returnLogged();
    }
    
    public void logout(Recepcionist recepcionist) throws Exception{
        AbstractGenericOperation operation = new LogutSo();
        operation.execute(recepcionist);
    }
    
    public List<PersonCategorie> getAllCategories() throws Exception{
        AbstractGenericOperation operation = new GetAllCategoriesSO();
        operation.execute(new PersonCategorie());
        return ((GetAllCategoriesSO)operation).getCategories();
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
    
    public void addPersonCategorie(PersonCategorie categorie) throws Exception{
        AbstractGenericOperation operation = new AddPersonCategorieSO();
        operation.execute(categorie);
    }
    
    public void addRecepcionist(Recepcionist recepcionist) throws Exception{
        AbstractGenericOperation operation = new AddRecepcionistSO();
        operation.execute(recepcionist);
    }
}
