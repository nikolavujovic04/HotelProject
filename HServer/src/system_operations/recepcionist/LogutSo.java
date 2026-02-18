/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.recepcionist;

import domain.Recepcionist;
import repository.db.impl.RepositoryDbRecepcionist;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class LogutSo extends AbstractGenericOperation{

    RepositoryDbRecepcionist repositoryRecepcionist;

    public LogutSo() {
        repositoryRecepcionist = new RepositoryDbRecepcionist();
    }
    
    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Recepcionist)){
            throw new Exception("Invalid param");
        }else{
            if(((Recepcionist)param).getUsername().equals(null)||((Recepcionist)param).getPassword().equals(null)){
                throw new Exception("No credintials sent");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Recepcionist recepcionist = (Recepcionist) param;
        repositoryRecepcionist.setUserLoggedOut(recepcionist);
    }
    
}
