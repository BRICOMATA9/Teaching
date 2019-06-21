/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplaige_fritel;
import java.util.ArrayList;

/**
 *
 * @author ludov
 */
public class Personnel{
    
    private ArrayList<Employé> personnel;
    
    public Personnel()
    {
        
    }
    
    public void ajouteEmploye(Employé e)
    {
        
        personnel.add(e);
        
    }
//    public void calculerHoraires()
//            
//    {
//        for(int i=0;i<personnel.size();i++)
//        {
//        System.out.println( personnel[i].GetNom());
//        }
//    }
//    
}
