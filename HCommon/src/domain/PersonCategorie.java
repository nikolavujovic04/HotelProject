/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return "person_categorie";
    }

    @Override
    public String getColumnNameForSelect() {
        return "idCategorie,personType,discount";
    }

    @Override
    public String getColumnNameForInsert() {
        return "personType,discount";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(personType).append("'").append(",")
                .append(discount);
        
        return sb.toString();
    }

    @Override
    public String getIdName() {
        return "idPersonCategorie";
    }

    @Override
    public Long getIdValue() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkValues() throws Exception {
        if(this.personType.isEmpty()){
            throw new Exception("Categorie type is empty!");
        }
        
        if(this.discount==0){
            throw new Exception("Discount is empty!");
        }
        
        return true;
    }

    @Override
    public boolean equalsWithoutID(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
