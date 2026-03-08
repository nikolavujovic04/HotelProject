/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Room;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelRooms extends AbstractTableModel{
    private List<Room> rooms;
    private String[] columnNames = new String[]{"ID", "Tip sobe", "Cena", "Kolicina"};
    private Class[] columnClass = new Class[]{Long.class, String.class, Double.class, Integer.class};
    
    public TableModelRooms(List<Room> rooms){
        this.rooms = rooms;
    }
    @Override
    public int getRowCount() {
        if(rooms == null){
            return 0;
        }else{
            return rooms.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if(column>columnNames.length){
            return "n/a";
        }else{
            return columnNames[column];
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>columnClass.length){
            return Object.class;
        }else{
            return columnClass[columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room room = rooms.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return room.getId();
            case 1:
                return room.getType();
            case 2: 
                return room.getPrice();
            case 3:
                return room.getQuantity();
            default:
                    return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Room room = rooms.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                room.setId((Long)aValue);
                break;
            case 1: 
                room.setType(aValue.toString());
                break;
            case 2:
                room.setPrice(Double.valueOf(aValue.toString()));
            case 3:
                room.setQuantity(Integer.parseInt(aValue.toString()));
                break;
        }
    }
    
    public void addPerson(Room room){
        this.rooms.add(room);
        fireTableRowsInserted(rooms.size()-1, rooms.size()-1);
    }
    
    public void removeProduct(int row){
        rooms.remove(row);
        fireTableDataChanged();
    }
    
    public List<Room> getPersons(){
        return rooms;
    }
}
