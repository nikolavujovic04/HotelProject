/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import db.DbRepository;
import domain.GenericEntity;
import java.util.List;
import java.sql.*;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Nikola
 */
public class RepositoryDbGeneric implements repository.db.DbRepository<GenericEntity, Long>{

    @Override
    public List<GenericEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(GenericEntity entity) throws Exception {
        try{
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INESERT INTO ")
                    .append(entity.getTableName())
                    .append(" ( ").append(entity.getColumnNameForInsert()).append(")")
                    .append(" VALUES (").append(entity.getInsertValues()).append(")");
            String query = sb.toString();
            System.out.println(query);
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if(rsKey.next()){
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            
            statement.close();
            rsKey.close();
        }catch (SQLException ex){
           ex.printStackTrace();
           throw ex;
        }
    }

    @Override
    public void edit(GenericEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(GenericEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
