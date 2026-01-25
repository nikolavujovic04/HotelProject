/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;

/**
 *
 * @author Nikola
 */
public class Rezervacija {
    private long idRezervacija;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private int brojDana;
    private double cenaSaPopustom;
    private String tipRezervacije;
    private long idRecepcionar;
    private long idOsoba;

    public Rezervacija() {
    }

    public Rezervacija(long idRezervacija, LocalDate datumOd, LocalDate datumDo, int brojDana, double cenaSaPopustom, String tipRezervacije, long idRecepcionar, long idOsoba) {
        this.idRezervacija = idRezervacija;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.brojDana = brojDana;
        this.cenaSaPopustom = cenaSaPopustom;
        this.tipRezervacije = tipRezervacije;
        this.idRecepcionar = idRecepcionar;
        this.idOsoba = idOsoba;
    }

    public long getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(long idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public double getCenaSaPopustom() {
        return cenaSaPopustom;
    }

    public void setCenaSaPopustom(double cenaSaPopustom) {
        this.cenaSaPopustom = cenaSaPopustom;
    }

    public String getTipRezervacije() {
        return tipRezervacije;
    }

    public void setTipRezervacije(String tipRezervacije) {
        this.tipRezervacije = tipRezervacije;
    }

    public long getIdRecepcionar() {
        return idRecepcionar;
    }

    public void setIdRecepcionar(long idRecepcionar) {
        this.idRecepcionar = idRecepcionar;
    }

    public long getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(long idOsoba) {
        this.idOsoba = idOsoba;
    }
    
    
}
