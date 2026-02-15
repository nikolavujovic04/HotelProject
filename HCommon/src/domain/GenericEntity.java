/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author Nikola
 */
public interface GenericEntity extends Serializable{
    String getTableName();
    String getColumnNameForSelect();
    String getColumnNameForInsert();
    String getInsertValues();
    String getIdName();
    Long getIdValue();
    void setId(Long id);
    GenericEntity getEntityFromResultSet(ResultSet rs);
    
    /*String selectColumns();
    String alijas();
    String insertColumns();
    String vrednostiZaInsert();
    String join();
    String uslov();
    String deleteUslov();
    String updateVrednosti();
    String updateUslov();
    void popuniPreparedStatement(PreparedStatement ps) throws SQLException;
    GenericEntity napuni(ResultSet rs) throws SQLException;*/
}
