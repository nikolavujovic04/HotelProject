/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.db.DatabaseBroker;

/**
 *
 * @author Nikola
 */
public class Controller {
    private DatabaseBroker dbbr;
    
    public Controller(){
        dbbr=new DatabaseBroker();
    }
}
