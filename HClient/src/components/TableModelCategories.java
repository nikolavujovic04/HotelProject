/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.PersonCategorie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelCategories extends AbstractTableModel{
    private List<PersonCategorie> categories;
    private String[] columnNames = new String[]{"ID", "Tip osobe", "Popust"};
    private Class[] columnClass = new Class[]{Long.class, String.class, Double.class};
    
    public TableModelCategories(List<PersonCategorie> categories){
        this.categories = categories;
    }
    @Override
    public int getRowCount() {
        if(categories == null){
            return 0;
        }else{
            return categories.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if(column>columnNames.length){
            return "n/a";
        }else{
            return columnNames[column];
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>columnClass.length){
            return Object.class;
        }else{
            return columnClass[columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PersonCategorie categorie = categories.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return categorie.getId();
            case 1:
                return categorie.getPersonType();
            case 2: 
                return categorie.getDiscount();
            default:
                    return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PersonCategorie categorie = categories.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                categorie.setId((Long)aValue);
                break;
            case 1: 
                categorie.setPersonType(aValue.toString());
                break;
            case 2:
                categorie.setDiscount(Double.parseDouble(aValue.toString()));
                break;
        }
    }
    
    public void addCategorie(PersonCategorie categorie){
        this.categories.add(categorie);
        fireTableRowsInserted(categories.size()-1, categories.size()-1);
    }
    
    public void removeCategorie(int row){
        categories.remove(row);
        fireTableDataChanged();
    }
    
    public PersonCategorie getCategorie(int row){
        return categories.get(row);
    }
    
    public List<PersonCategorie> getCategories(){
        return categories;
    }
}
