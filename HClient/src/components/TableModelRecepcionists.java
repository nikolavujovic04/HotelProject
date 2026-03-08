/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Recepcionist;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelRecepcionists extends AbstractTableModel{
    private List<Recepcionist> recepcionists;
    private String[] columnNames = new String[]{"ID", "Ime", "Prezime", "jmbg", "Korisnicko ime", "Broj telefona", "Ulogovan"};
    private Class[] columnClass = new Class[]{Long.class, String.class, String.class,String.class,String.class,String.class,String.class};
    
    public TableModelRecepcionists(List<Recepcionist> recepcionists){
        this.recepcionists = recepcionists;
    }
    @Override
    public int getRowCount() {
        if(recepcionists == null){
            return 0;
        }else{
            return recepcionists.size();
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
        if(columnIndex>=columnClass.length){
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
        Recepcionist recepcionist = this.recepcionists.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return recepcionist.getidRecepcionist();
            case 1:
                return recepcionist.getFirstName();
            case 2: 
                return recepcionist.getLastName();
            case 3: 
                return recepcionist.getJmbg();
            case 4: 
                return recepcionist.getUsername();
            case 5: 
                return recepcionist.getPhoneNumber();
            case 6:
                if(recepcionist.isLogged()){
                    return "DA";
                }else{
                    return "NE";
                }
            default:
                    return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Recepcionist recepcionist = recepcionists.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                recepcionist.setId(Long.valueOf(aValue.toString()));
                break;
            case 1: 
                recepcionist.setFirstName(aValue.toString());
                break;
            case 2:
                recepcionist.setLastName(aValue.toString());
                break;
            case 3:
                recepcionist.setJmbg(aValue.toString());
                break;
            case 4:
                recepcionist.setUsername(aValue.toString());
                break;
            case 5:
                recepcionist.setPhoneNumber(aValue.toString());
                break;
            case 6:
                if(aValue.toString().equals("DA")){
                    recepcionist.setLogged(true);
                }else{
                    recepcionist.setLogged(false);
                }
                break;
        }
    }
    
    public void addPerson(Recepcionist recepcionist){
        this.recepcionists.add(recepcionist);
        fireTableRowsInserted(recepcionists.size()-1, recepcionists.size()-1);
    }
    
    public void removeProduct(int row){
        recepcionists.remove(row);
        fireTableDataChanged();
    }
    
    public List<Recepcionist> getPersons(){
        return recepcionists;
    }
}
