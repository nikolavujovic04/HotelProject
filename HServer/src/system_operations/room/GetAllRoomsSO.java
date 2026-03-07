/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.room;

import domain.Room;
import java.util.List;
import system_operations.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class GetAllRoomsSO extends AbstractGenericOperation{

    List<Room> rooms;
    @Override
    protected void precondition(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        rooms = repository.getAll(new Room());
    }
    
    public List<Room> getRooms(){
        return rooms;
    }
}
