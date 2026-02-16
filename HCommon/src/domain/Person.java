/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nikola
 */
public class Person implements GenericEntity{
    
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private PersonCategorie categorie;

    public Person() {
    }

    public Person(long id, String firstName, String lastName, String email, String phoneNumber, PersonCategorie categorie) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.categorie = categorie;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PersonCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(PersonCategorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String getTableName() {
        return "osoba";
    }

    @Override
    public String getColumnNameForInsert() {
        return "imePrezime,email,brojTelefona,idKategorije";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(firstName).append("'").append(",")
                .append("'").append(lastName).append("'").append(",")
                .append("'").append(email).append("'").append(",")
                .append("'").append(phoneNumber).append("'").append(",")
                .append(categorie.getId());
        
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long getIdValue() {
        return this.id;
    }

    @Override
    public String getColumnNameForSelect() {
        return "ime,prezime,email,brojTelefona,idKategorijaOsobe";
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet rs) {
        try {
            PersonCategorie categorie = new PersonCategorie();
            categorie.setId(rs.getLong("idKategorijaOsobe"));
            return new Person(rs.getLong("idOsoba"),rs.getString("ime"), rs.getString("prezime"),rs.getString("email"), rs.getString("brojTelefona"), categorie);
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public boolean checkValues() throws Exception {
        if(this.firstName.isEmpty()){
            throw new Exception("Person name is empty!");
        }
        
        if(this.lastName.isEmpty()){
            throw new Exception("Person lastname is empty!");
        }
        
        if(this.email.isEmpty()){
            throw new Exception("Person email is empty!");
        }
        
        if(this.phoneNumber.isEmpty()){
            throw new Exception("Person phone number is empty!");
        }
        
        return true;
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
        
        final Person person = (Person) object;
        
        if(!Objects.equals(this.firstName, person.firstName)){
            return false;
        }
        
        if(!Objects.equals(this.lastName, person.lastName)){
            return false;
        }
        
        if(!Objects.equals(this.email, person.email)){
            return false;
        }
        
        if(!Objects.equals(this.phoneNumber, person.phoneNumber)){
            return false;
        }
        
        if(!Objects.equals(this.categorie.getTipOsobe(), person.getCategorie().getTipOsobe())){
            return false;
        }
        
        return true;
    }


    
    
}
