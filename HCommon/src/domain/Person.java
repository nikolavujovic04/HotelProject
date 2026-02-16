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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nikola
 */
public class Person implements GenericEntity{
    
    private long id;
    private String imePrezime;
    private String email;
    private String brojTelefona;
    private PersonCategorie kategorija;

    public Person() {
    }

    public Person(long id, String imePrezime, String email, String brojTelefona, PersonCategorie kategorija) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public Person(String imePrezime, String email, String brojTelefona, PersonCategorie kategorija) {
        this.imePrezime = imePrezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public PersonCategorie getKategorija() {
        return kategorija;
    }

    public void setKategorija(PersonCategorie kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return this.imePrezime;
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
                .append("'").append(imePrezime).append("'").append(",")
                .append("'").append(email).append("'").append(",")
                .append("'").append(brojTelefona).append("'").append(",")
                .append(kategorija.getId());
        
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
            return new Person(rs.getLong("idOsoba"),rs.getString("imePrezime"), rs.getString("email"), rs.getString("brojTelefona"), categorie);
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    
    
}
