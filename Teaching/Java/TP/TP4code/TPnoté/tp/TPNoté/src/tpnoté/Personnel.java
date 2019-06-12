/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnoté;
import java.util.*;

/**
 *
 * @author David
 */
public class Personnel extends Employe{
    
    ArrayList<Employe> listEmp = new ArrayList<Employe>();
    
    
    public Personnel(String pprenom, String pnom, int page, int pdate_recrutement)
    {
        super(pprenom, pnom, page, pdate_recrutement);
    }
    
    public void ajouterEmploye(Employe emp)
    {
        listEmp.add(emp);
    }
    
    public void calculerHoraires(int semaine)
    {   
        for(int i = 0; i<listEmp.size(); i++)
        {
            if(listEmp.get(i) instanceof Vente)
            {
                System.out.println("Vendeur " + listEmp.get(i).prenom + " " + listEmp.get(i).nom + " " + listEmp.get(i).calculerHoraire(semaine) + " heures." );
            }
            
            if(listEmp.get(i) instanceof Production)
            {
                System.out.println("Technicien " + listEmp.get(i).prenom + " " + listEmp.get(i).nom + " " + listEmp.get(i).calculerHoraire(semaine) + " heures." );
            }
            
            if(listEmp.get(i) instanceof Manutention)
            {
                System.out.println("Manutentionnaire " + listEmp.get(i).prenom + " " + listEmp.get(i).nom + " " + listEmp.get(i).calculerHoraire(semaine) + " heures." );
            }
        }
    }
    
    public int HoraireMensuel()
    {
        int empMensuel = 0;
        int listMensuel = 0;
        int moyenneEmp;
  
        for(int i=0 ; i<listEmp.size(); i++)
        {
            for(int sem = 1; sem<5; sem++)
            {
                empMensuel += listEmp.get(i).calculerHoraire(sem);
                System.out.println(empMensuel);
            }
            listMensuel += empMensuel;
        }
        moyenneEmp = listMensuel/listEmp.size();
        return moyenneEmp;
    }

    @Override
    public int calculerHoraire(int semaine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
