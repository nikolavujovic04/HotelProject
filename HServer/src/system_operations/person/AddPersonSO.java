/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.person;

import domain.Person;
import java.util.List;
import system_operations.AbstractGenericOperation;
import validation.Validator;

/**
 *
 * @author Nikola
 */
public class AddPersonSO extends AbstractGenericOperation{
    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Person)){
            throw new Exception("Invalid param");
        }
        
        Person person = (Person) param;
            Validator.startValidation()
            .validateNotNullOrEmpty(person.getFirstName(), "Ime je obavezno")
            .validateNotNullOrEmpty(person.getLastName(), "Prezime je obavezno")     
            .validateNotNullOrEmpty(person.getEmail(), "Email je obavezan")
            .validateNotNullOrEmpty(person.getPhoneNumber(), "Broj telefona je obavezan")
            .validateNotNull(person.getCategorie(), "Kategorija osobe je obavezna")
            .throwIfInvalide();
        
        checkValueConstraints(person);
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Person)param);
    }
    
    private void checkValueConstraints(Person person) throws Exception{
        boolean exists = checkIfExists(person);
        
        if(exists){
            throw new Exception("Person with that email or phone number alredy exists. Try again");
        }
    }
    
    private boolean checkIfExists(Person person) throws Exception{
        List<Person> persons = repository.getAll(person);
        
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
