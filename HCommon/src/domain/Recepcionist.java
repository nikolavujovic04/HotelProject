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
    private long idRecepcionar;
    private String imePrezime;
    private String prezime;
    private String jmbg;
    private String korisnickoIme;
    private String sifra;
    private String brojTelefona;

    public Recepcionist() {
    }

    public Recepcionist(long idRecepcionar, String imePrezime, String prezime, String jmbg, String korisnickoIme, String sifra, String brojTelefona) {
        this.idRecepcionar = idRecepcionar;
        this.imePrezime = imePrezime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.brojTelefona = brojTelefona;
    }

    public long getIdRecepcionar() {
        return idRecepcionar;
    }

    public void setIdRecepcionar(long idRecepcionar) {
        this.idRecepcionar = idRecepcionar;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return this.imePrezime;
    }
}
