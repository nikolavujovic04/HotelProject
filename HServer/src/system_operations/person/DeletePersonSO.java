/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.person;

import domain.Person;
import domain.Reservation;
import java.util.List;
import system_operations.AbstractSo;

/**
 *
 * @author Nikola
 */
public class DeletePersonSO extends AbstractSo{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param==null || !(param instanceof Person)){
            throw new Exception("Invalid param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private boolean checkReservation(Person person) throws Exception{
        List<Reservation> reservations = repository.getAll(new Reservation());
        
        for (Reservation reservation : reservations) {
            if(reservation.)
        }
    }
}
