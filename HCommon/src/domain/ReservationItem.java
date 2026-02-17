/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nikola
 */
public class ReservationItem {
    private long rb;
    private long idRezervacija;
    private double iznos;
    private long idSoba;

    public ReservationItem() {
    }

    public ReservationItem(long rb, long idRezervacija, double iznos, long idSoba) {
        this.rb = rb;
        this.idRezervacija = idRezervacija;
        this.iznos = iznos;
        this.idSoba = idSoba;
    }

    public long getRb() {
        return rb;
    }

    public void setRb(long rb) {
        this.rb = rb;
    }

    public long getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(long idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public long getIdSoba() {
        return idSoba;
    }

    public void setIdSoba(long idSoba) {
        this.idSoba = idSoba;
    }
    
    
}
