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
public class PersonCategorie{
    private long id;
    private String tipOsobe;
    private double popust;

    public PersonCategorie() {
    }

    public PersonCategorie(long id, String tipOsobe, double popust) {
        this.id = id;
        this.tipOsobe = tipOsobe;
        this.popust = popust;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipOsobe() {
        return tipOsobe;
    }

    public void setTipOsobe(String tipOsobe) {
        this.tipOsobe = tipOsobe;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    @Override
    public String toString() {
        return this.tipOsobe;
    }
}
