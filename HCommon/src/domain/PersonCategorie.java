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
public class PersonCategorie implements GenericEntity{
    private long id;
    private String personType;
    private double discount;

    public PersonCategorie() {
    }

    public PersonCategorie(long id, String personType, double discount) {
        this.id = id;
        this.personType = personType;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String getTableName() {
        return "personcategorie";
    }

    @Override
    public String getColumnNameForSelect() {
        return "idCategorie,type,discount";
    }

    @Override
    public String getColumnNameForInsert() {
        return "type,discount";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(personType).append("'").append(",")
                .append(discount);
        
        return sb.toString();
    }

    @Override
    public String getIdName() {
        return "idCategorie";
    }

    @Override
    public Long getIdValue() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet rs) {
        try {
            return new PersonCategorie(rs.getLong("idCategorie"), rs.getString("type"), rs.getDouble("discount"));
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
        
        final PersonCategorie categorie = (PersonCategorie) object;
        
        return Objects.equals(this.personType,categorie.personType);
    }

    @Override
    public String toString() {
        return this.personType;
    } 

    @Override
    public String getJoinCondition() {
        return "";
    }
}
