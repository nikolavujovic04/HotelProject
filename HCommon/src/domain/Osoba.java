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
/**
 *
 * @author Nikola
 */
public class Osoba implements GenericEntity{
    
    private long id;
    private String imePrezime;
    private String email;
    private String brojTelefona;
    private KategorijaOsobe kategorija;

    public Osoba() {
    }

    public Osoba(long id, String imePrezime, String email, String brojTelefona, KategorijaOsobe kategorija) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public Osoba(String imePrezime, String email, String brojTelefona, KategorijaOsobe kategorija) {
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

    public KategorijaOsobe getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaOsobe kategorija) {
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

    
    
}
