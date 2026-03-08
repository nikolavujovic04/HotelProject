/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.recepcionist;

import domain.Recepcionist;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class GetAllRecepcionists extends AbstractGenericOperation{

    List<Recepcionist> recepcionists;
    @Override
    protected void precondition(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        recepcionists = repository.getAll(new Recepcionist());
    }
    
    public List<Recepcionist> getRecepcionists(){
        return recepcionists;
    }
    
}
