/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author Nikola
 */
public class DbConnectionFactory {
    public static DbConnectionFactory instance;

    public static DbConnectionFactory getInstance() {
        if(instance==null){
            instance = new DbConnectionFactory();
        }
        return instance;
    }
    
    
    
    public void getConnection(){
        
    }
    
    public void disconnect(){
        
    }

    public void close(){
    
    }
    
    public void commit(){
    }
    
    public void rollback(){
        
    }
}
