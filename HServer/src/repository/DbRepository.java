/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author Nikola
 */
public interface DbRepository<T, K> extends Repository<T, K> {
    
    default public void connect(){
        DbConnectionFactory.getInstance().getConnection();
    }
    
    default public void disconnect(){
        DbConnectionFactory.getInstance().disconnect();
    }
    
    default public void commit(){
        DbConnectionFactory.getInstance().commit();
    }
    
    default public void rollback(){
        DbConnectionFactory.getInstance().rollback();
    }
}
