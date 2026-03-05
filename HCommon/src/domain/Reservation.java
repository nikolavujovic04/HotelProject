/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalDate;
/**
 *
 * @author Nikola
 */
public class Reservation implements GenericEntity{
    private long id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int dayNumber;
    private double discountPrice;
    private String reservationType;
    private Recepcionist recepcionist;
    private Person person;

    public Reservation() {
    }

    public Reservation(long id, LocalDate dateFrom, LocalDate dateTo, int dayNumber, double discountPrice, String reservationType, Recepcionist recepcionist, Person person) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.dayNumber = dayNumber;
        this.discountPrice = discountPrice;
        this.reservationType = reservationType;
        this.recepcionist = recepcionist;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public double getDiscountPrise() {
        return discountPrice;
    }

    public void setDiscountPrise(double discountPrise) {
        this.discountPrice = discountPrise;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public Recepcionist getRecepcionist() {
        return recepcionist;
    }

    public void setRecepcionist(Recepcionist recepcionist) {
        this.recepcionist = recepcionist;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String getTableName() {
        return "reservation";
    }

    @Override
    public String getColumnNameForSelect() {
        return "idReservation,dateFrom,dateTo,dayNumber,totalCost,discountPrice,type,idRecepcionist,idPerson";
    }

    @Override
    public String getColumnNameForInsert() {
        return "dateFrom,dateTo,dayNumber,totalCost,discountPrice,type,idRecepcionist,idPerson";
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean checkValues() throws Exception {
        return false;
    }

    @Override
    public boolean equalsWithoutID(Object object) {
        return false;
    }
    
    
    
    
}
