/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.util.Iterator;
import modele.*;

/**
 * Classe permettant l'affichage des differentes statistiques
 * @author sebas
 */


public abstract class Affichage {

    
    /**
     * Méthode permettant de trier et d'afficher les fonds d'un instrument
     * @param i 
     */
   
    public static void afficher_tri(Instrument i)
    {
      /*  i.ajoutFond(new Fonds(7777));
        i.ajoutFond(new Fonds(457));
        i.ajoutFond(new Fonds(9));
        i.ajoutFond(new Fonds(40000000));
        i.ajoutFond(new Fonds(34));
        i.ajoutFond(new Fonds(9999));
      */  System.out.println("Affichage de l'instrument avant d'opérer le tri :");
        i.afficher();
        i.tri();
        System.out.println("Affichage de l'instrument après avoir d'opéré le tri :");
        i.afficher();
    }
    
    /**
     * Affichage de l'ensemble des instruments, du combre de fonds qu'il comporte et de leur somme
     * @param p 
     */
        
    public static void afficher_tout(Portefeuille p)
    {
        
        for(Iterator i=p.getMapInstru().keySet().iterator(); i.hasNext();)
        {
            String cle =(String) i.next();
            System.out.println("L'instrument "+cle+ "comporte " +p.getMapInstru().size()+ " fonds");
            System.out.println("La somme des fonds de cet instrument vaut " +p.getMapInstru().get(i).calcul_fond());
           
        }
        
    }
    
    /**
     * Affichage d'un fond, du pourcentage qu'il represente dans chaque instrument
     * @param p
     * @param cle 
     */
    
    public static void afficher_fond(Portefeuille p, String cle)
    {
        double total=0;
        double val_fond;
        double pourcentage=0;
        if(p.recherche_fond(cle)<0)
            System.out.println("Le fond que vous avez saisi n'existe pas");
        else
        {
            for(Iterator i=p.getMapInstru().keySet().iterator(); i.hasNext();)
            {
                total=p.getMapInstru().get(i).calcul_fond();
                val_fond=p.recherche_fond(cle);
                pourcentage=(val_fond/total)*100;
                System.out.println("L'instrument " );
                p.getMapInstru().get(i).afficher();
                System.out.println(" est constitue a " +pourcentage+ "% du fond " +cle );
            }
        }
    }
    
    
}
