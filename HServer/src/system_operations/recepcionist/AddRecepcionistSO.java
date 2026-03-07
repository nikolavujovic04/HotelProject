/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.recepcionist;

import domain.Recepcionist;
import domain.Room;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class AddRecepcionistSO extends AbstractGenericOperation{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Recepcionist)){
            throw new Exception("Invalid param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Recepcionist)param);
    }
    
    private void checkValueConstraints(Recepcionist recepcionist) throws Exception{
        boolean exists = checkIfExists(recepcionist);
        
        if(exists){
            throw new Exception("Recepcionar vec postoji. Pokusajte ponovo");
        }
    }
    
    private boolean checkIfExists(Recepcionist recepcionist) throws Exception{
        List<Recepcionist> recepcionists = repository.getAll(new Recepcionist());
        
        for (Recepcionist check : recepcionists) {
            if(check!=null){
                if(check.equalsWithoutID(recepcionist)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
