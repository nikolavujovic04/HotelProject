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
public class Recepcionist{
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

    
}
