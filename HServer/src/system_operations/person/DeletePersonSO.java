/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.person;

import domain.Person;
import domain.Reservation;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class DeletePersonSO extends AbstractGenericOperation{ 
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Person)) {
            throw new Exception("Invalid param");
        } else {
            Person person = (Person) param;
            checkConstraints(person);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Person) param);
    }

    private void checkConstraints(Person person) throws Exception {
        boolean exist = checkExistent(person);
        boolean hasReservation = checkReservation(person);

        if (!exist) {
            throw new Exception("Person does not exist.");
        }

        if (hasReservation) {
            throw new Exception("Person has reservations and cannot be deleted.");
        }
    }

    private boolean checkExistent(Person person) throws Exception {
        Person exist = (Person) repository.getById(person);
        return exist != null;
    }

    private boolean checkReservation(Person person) throws Exception {
        List<Reservation> reservations = repository.getAll(new Reservation());

        for (Reservation reservation : reservations) {
            if (reservation.getPerson() != null &&
                reservation.getPerson().getId() == person.getId()) {
                return true;
            }
        }

        return false;
    }
}
