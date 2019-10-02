/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedular;

import DAO.SalleDAO;
import Entities.Salle;

/**
 *
 * @author hajji
 */
public class Schedular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Salle s=new Salle();
        s.setCapacite(40);
        s.setType("salle machine");
        s.setLibelle("c33");
        Salle s2=new Salle();
        s2.setId(2);
        s.setPredecesseur(s);
        s.setSuccesseur(s);
        if(SalleDAO.getInstance().insertSalle(s)) System.out.println("ajout success");
    
}
}