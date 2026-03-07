/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class Room implements GenericEntity{
    private Long id;
    private String type;
    private Double price;
    private int quantity;

    public Room() {
    }

    public Room(Long id, String type, Double price, int quantity) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Room(String type, Double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getTableName() {
        return "room";
    }

    @Override
    public String getColumnNameForSelect() {
        return "idRoom,type,price,quantity";
    }

    @Override
    public String getColumnNameForInsert() {
        return "type,price,quantity";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(type).append("'").append(",")
                .append(price).append(",")
                .append(quantity);
        
        return sb.toString();
    }

    @Override
    public String getIdName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long getIdValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet rs) {
        try {
            return new Room(rs.getLong("idRoom"), rs.getString("type"), rs.getDouble("price"), rs.getInt("quantity"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equalsWithoutID(Object object) {
        if(this == object){
            return true;
        }
        
        if(object == null){
            return false;
        }
        
        if(getClass() != object.getClass()){
            return false;
        }
        
        final Room room = (Room) object;
        
        return Objects.equals(this.type, room.type);
    }

    @Override
    public String toString() {
        return this.type;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }
    
    
    
}
