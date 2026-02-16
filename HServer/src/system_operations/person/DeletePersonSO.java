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
        }else{
            Person person = (Person) param;
            checkValueConstraints(person);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Person)param);
    }
    
    private void checkValueConstraints(Person person) throws Exception{
        boolean exists = checkReservation(person);
        if(exists){
            throw new Exception("Member with that ID has created reservation and can not be deleted. Try again.");
        }
    }
    
    private boolean checkReservation(Person person) throws Exception{
        List<Reservation> reservations = repository.getAll(new Reservation());
        
        for (Reservation reservation : reservations) {
            if(reservation.getPerson().getId() == person.getId()){
                return true;
            }
        }
        
        return false;
    }
}
