/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.room;

import domain.Room;
import java.awt.Robot;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class AddRoomSO extends AbstractGenericOperation{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Room)){
            throw new Exception("Invalid param");
        }else{
            Room room = (Room) param;
            //dodaj ovde proveru dal je null room tj svi njeni atributi
            checkValueConstraints(room);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Room) param);
    }
    
    private void checkValueConstraints(Room room) throws Exception{
        boolean exists = checkIfExists(room);
        
        if(exists){
            throw new Exception("That room alredy exists. Try again");
        }
    }
    
    private boolean checkIfExists(Room room) throws Exception{
        List<Room> rooms = repository.getAll(new Room());
        Robot robot = new Robot();
        for (Room check : rooms) {
            if(check!=null){
                if(check.getTipSobe().equals(room.getTipSobe())){
                    return true;
                }
            }
        }
        
        return false;
    }
}
