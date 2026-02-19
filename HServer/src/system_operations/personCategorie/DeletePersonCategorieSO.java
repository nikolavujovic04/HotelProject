/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.personCategorie;

import domain.Person;
import domain.PersonCategorie;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class DeletePersonCategorieSO extends AbstractGenericOperation{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof PersonCategorie)){
            throw new Exception("Invalid param");
        }else{
            PersonCategorie categorie = (PersonCategorie) param;
            checkConstraints(categorie);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((PersonCategorie) param);
    }
    
    private void checkConstraints(PersonCategorie categorie) throws Exception{
        boolean exist = checkExistent(categorie);
        boolean inPerson = checkInPerson(categorie);
        if(!exist){
            throw new Exception("Categorie does not exist");
        }
        else if(inPerson){
            throw new Exception("Can not delete categorie.");
        }
    }
    
    private boolean checkExistent(PersonCategorie categorie) throws Exception{
        PersonCategorie exist = (PersonCategorie) repository.getById(categorie);
        if(exist==null){
            return false;
        }
        return true;
    }
    
    private boolean checkInPerson(PersonCategorie categorie) throws Exception{
        List<Person> persons = repository.getAll(new Person());
        for (Person person : persons) {
            if(person.getCategorie()!=null&&person.getCategorie().getId()==categorie.getId()){
                return true;
            }
        }
        
        return false;
    }
    
}
