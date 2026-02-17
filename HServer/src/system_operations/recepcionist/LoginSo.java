/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_operations.recepcionist;

import domain.Recepcionist;
import java.util.List;
import repository.db.impl.RepositoryDbRecepcionist;
import system_operations.AbstractSo;

/**
 *
 * @author Nikola
 */
public class LoginSo extends AbstractSo{

    Recepcionist currentRecepcionist;
    RepositoryDbRecepcionist repositoryRecepcionist;
    @Override
    protected void precondition(Object param) throws Exception {
        if(param!=null && param instanceof Recepcionist){
            throw new Exception("Inalid param");
        }
        if(((Recepcionist)param).getUsername().equals(null) || ((Recepcionist)param).getPassword().equals(null)){
            throw new Exception("No credentials sent!");
        }
    }   

    @Override
    protected void executeOperation(Object param) throws Exception {
        boolean exist = false;
        List<Recepcionist> recepcionists;
        Recepcionist recepcionist = (Recepcionist) param;
        recepcionists = (List<Recepcionist>)repository.getAll(new Recepcionist());
        
        for (Recepcionist loggin : recepcionists) {
            if(loggin.getUsername().equals(recepcionist.getUsername()) && loggin.getPassword().equals(recepcionist.getPassword())){
                currentRecepcionist = loggin;
                System.out.println(loggin);
                exist = true;
                
                if(currentRecepcionist.isLogged()==true){
                    throw new Exception("Recepcionist alredy logged in");
                }
                
                repositoryRecepcionist.setUserLoggedIn(currentRecepcionist);
            }
        }
        if(exist==false){
            throw new Exception("This recepcionist doesn't exists");
        }
    }
    
}
