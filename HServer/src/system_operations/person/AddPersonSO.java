/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.person;

import domain.Person;
import system_operations.AbstractSo;

/**
 *
 * @author Nikola
 */
public class AddPersonSO extends AbstractSo{

    public AddPersonSO() {
    }

    
    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Person)){
            
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
