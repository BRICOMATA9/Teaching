/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimon_brunelle;

import java.util.ArrayList;
/**
 *
 * @author sebas
 */
public class Personnel 
{
    private int total=0;
    private ArrayList<Employe> liste= new ArrayList();
    
    public void ajouterEmploye(Employe e)
    {
        liste.add(e);
    }
    
    public void calculerHoraire(int i)
    {
        for(int j=0; j<liste.size(); j++)
        {
            liste.get(j).getNom();
           liste.get(j).calculerHoraire(i);
           System.out.print("\n");
        }
    }
    
    public int HoraireMensuel()
    {
        for(int j=0; j<liste.size(); j++)
        {
            for(int sem=0; sem<5; sem++)
            {
                liste.get(j).calculerHoraire(sem);
                total=total+liste.get(j).getHoraire();
            }
        }
        return total/liste.size()*4;
        
    }
    
    public static void main(String[] args)
    {
        Personnel p=new Personnel();
    p.ajouterEmploye(new Vente("Pierre","Buisiness",45,"2005"));
    p.ajouterEmploye(new Vente("leon","bosseur",25,"2011"));
    p.ajouterEmploye(new Production("yves","vendtouts",45,"2000"));
    p.ajouterEmploye(new Manutention("jeanne","stockout",45,"2008"));
    p.calculerHoraire(2);
    System.out.println("L'horaire moyen dans cette entreprise est de "+p.HoraireMensuel()+"heures");
    }
}
