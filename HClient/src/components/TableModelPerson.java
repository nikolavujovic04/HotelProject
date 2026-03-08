/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Person;
import domain.PersonCategorie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelPerson extends AbstractTableModel{

    private List<Person> persons;
    private String[] columnNames = new String[]{"ID", "Ime", "Prezime", "Email", "Broj telefona", "Kategorija"};
    private Class[] columnClass = new Class[]{Long.class, String.class, String.class,String.class,String.class,PersonCategorie.class};
    
    public TableModelPerson(List<Person> persons){
        this.persons = persons;
    }
    @Override
    public int getRowCount() {
        if(persons == null){
            return 0;
        }else{
            return persons.size();
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
        Person person = persons.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return person.getId();
            case 1:
                return person.getFirstName();
            case 2: 
                return person.getLastName();
            case 3: 
                return person.getEmail();
            case 4: 
                return person.getPhoneNumber();
            case 5: 
                return person.getCategorie().getPersonType();
            default:
                    return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                person.setId((Long)aValue);
                break;
            case 1: 
                person.setFirstName(aValue.toString());
                break;
            case 2:
                person.setLastName(aValue.toString());
                break;
            case 3:
                person.setEmail(aValue.toString());
                break;
            case 4:
                person.setPhoneNumber(aValue.toString());
                break;
            case 5:
                person.setCategorie((PersonCategorie)aValue);
                break;
        }
    }
    
    public void addPerson(Person person){
        this.persons.add(person);
        fireTableRowsInserted(persons.size()-1, persons.size()-1);
    }
    
    public void removePerson(int row){
        persons.remove(row);
        fireTableDataChanged();
    }
    
    public Person getPerson(int row){
        return persons.get(row);
    }
    
    public List<Person> getPersons(){
        return persons;
    }
}
