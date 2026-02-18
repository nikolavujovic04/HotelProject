/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations;

import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public abstract class AbstractGenericOperation {
    protected final Repository repository;
    
    public AbstractGenericOperation() {
        repository = new RepositoryDbGeneric();
    }
    
    public void execute(Object param) throws Exception {
        try {
            precondition(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();            
        } catch (Exception ex) {
            Logger.getLogger(AbstractGenericOperation.class.getName()).log(Level.SEVERE, null, ex);
            rollbackTransaction();
        }
    }
    
    protected abstract void precondition(Object param) throws Exception;
    
    protected abstract void executeOperation(Object param) throws Exception;
    
    private void startTransaction() throws Exception{
        ((DbRepository) repository).connect();
    }
    
    protected void commitTransaction() throws Exception {
        ((DbRepository) repository).commit();
    }

    protected void rollbackTransaction() throws Exception {
        ((DbRepository) repository).rollback();
    }
}
