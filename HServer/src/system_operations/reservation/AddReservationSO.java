/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.reservation;

import domain.Reservation;
import domain.ReservationItem;
import java.util.List;
import system_operations.AbstractSo;

/**
 *
 * @author Nikola
 */
public class AddReservationSO extends AbstractSo{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Reservation)){
            throw new Exception("Invalid param");
        }else{
            Reservation reservation = (Reservation) param;
            reservation.checkValues();
        }
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Reservation) param);
    }
}
