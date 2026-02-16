/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.person;

import domain.Person;
import java.util.List;
import system_operations.AbstractSo;

/**
 *
 * @author Nikola
 */
public class EditPersonSO extends AbstractSo{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Person)){
            throw new Exception("Invalid param. Try again");
        }
        else{
            Person person = (Person) param;
            checkValueConstraints(person);
        }     
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Person) param);
    }
    
    private void checkValueConstraints(Person person) throws Exception{
        boolean exists = checkIfExists(person);
        
        if(exists){
            throw new Exception("Person with that email or phone number alredy exists");
        }
    }
    
    private boolean checkIfExists(Person person) throws Exception{
        List<Person> persons = repository.getAll(new Person());
        
        for (Person check : persons) {
            if(check!=null){
                if(check.equalsWithoutID(person)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
