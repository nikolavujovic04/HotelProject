/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.personCategorie;

import domain.PersonCategorie;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class AddPersonCategorieSO extends AbstractGenericOperation{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof PersonCategorie)){
            throw new Exception("Invalid param");
        }
        
        PersonCategorie categorie = (PersonCategorie) param;
        checkValueConstraints(categorie);
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((PersonCategorie) param);
    }
    
    private void checkValueConstraints(PersonCategorie categorie) throws Exception{
        boolean exists = checkIfExists(categorie);
        
        if(exists){
            throw new Exception("Kategorija vec postoji. Pokusajte ponovo");
        }
    }
    
    private boolean checkIfExists(PersonCategorie categorie) throws Exception{
        List<PersonCategorie> categories = repository.getAll(new PersonCategorie());
        
        for (PersonCategorie check : categories) {
            if(check!=null){
                if(check.equalsWithoutID(categorie)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
