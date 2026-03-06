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
public class Recepcionist implements GenericEntity{
    private long idRecepcionist;
    private String firstName;
    private String lastName;
    private String jmbg;
    private String username;
    private String password;
    private String phoneNumber;
    private boolean logged;

    public Recepcionist() {
    }

    public Recepcionist(long idRecepcionar, String firstName, String lastName, String jmbg, String username, String password, String phoneNumber, boolean logged) {
        this.idRecepcionist = idRecepcionar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.logged = logged;
    }

    public long getidRecepcionist() {
        return idRecepcionist;
    }

    public void setidRecepcionist(long idRecepcionist) {
        this.idRecepcionist = idRecepcionist;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public String getTableName() {
        return "recepcionist";
    }

    @Override
    public String getColumnNameForSelect() {
        return "idRecepcionist,firstName,lastName,jmbg,username,password,phoneNumber,logged";
    }

    @Override
    public String getColumnNameForInsert() {
        return "idRecepcionist,firstName,lastName,jmbg,username,password,phoneNumber,logged";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(idRecepcionist).append(",")
                .append("'").append(firstName).append("'").append(",")
                .append("'").append(lastName).append("'").append(",")
                .append("'").append(jmbg).append("'").append(",")
                .append("'").append(username).append("'").append(",")
                .append("'").append(password).append("'").append(",")
                .append("'").append(phoneNumber).append("'").append(",")
                .append(logged);
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
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean equalsWithoutID(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
