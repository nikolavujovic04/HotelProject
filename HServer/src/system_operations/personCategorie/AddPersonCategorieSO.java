/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.personCategorie;

import domain.PersonCategorie;
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
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        
    }
    
}
