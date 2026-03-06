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
public class GetAllCategoriesSO extends AbstractGenericOperation{

    private List<PersonCategorie> categories;
    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        categories = repository.getAll(new PersonCategorie());
    }
    
    public List<PersonCategorie> getCategories(){
        return categories;
    }
}
