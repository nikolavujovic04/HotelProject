/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.Recepcionist;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Nikola
 */
public class RepositoryDbRecepcionist implements DbRepository<Recepcionist, Object>{

    private RepositoryDbGeneric repositoryDBGeneric;

    public RepositoryDbRecepcionist() {
        repositoryDBGeneric = new RepositoryDbGeneric();
    }
    
    @Override
    public List<Recepcionist> getAll(Recepcionist t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Recepcionist t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Recepcionist t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Recepcionist t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Recepcionist getById(Object k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setUserLoggedIn(Recepcionist currentRecepcionist) throws SQLException, IOException{
        String query = "UPDATE recepcionist SET logged=1 WHERE id=" + currentRecepcionist.getidRecepcionist();
        Statement statement = DbConnectionFactory.getInstance().getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
    
    public void setUserLoggedOut(Recepcionist currentRecepcionist) throws SQLException, IOException{
        String query = "UPDATE recepcionist SET logged=0 WHERE id=" + currentRecepcionist.getidRecepcionist();
        Statement statement = DbConnectionFactory.getInstance().getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
}
