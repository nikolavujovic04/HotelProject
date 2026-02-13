/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import constant.ServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class DbConnectionFactory {
    private Connection connection;
    private static DbConnectionFactory instance;

    public static DbConnectionFactory getInstance() {
        if(instance==null){
            instance = new DbConnectionFactory();
        }
        return instance;
    }
    
    
    
    public Connection getConnection() throws SQLException, IOException{
        if(connection==null || connection.isClosed()){
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                
                String url = properties.getProperty(ServerConstants.DB_CONFIG_URL);
                String user = properties.getProperty(ServerConstants.DB_CONFIG_USERNAME);
                String password = properties.getProperty("password");
                
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DbConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
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
