/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote_;
import java.util.ArrayList;

/**
 *
 * @author Jean Leroy
 */
public class Personnel {
    

    public Personnel() {
        liste = new ArrayList<Employe>();
    }
        private ArrayList<Employe> liste;

    
    public void ajouteEmploye(Employe e)
    {
        char test = e.getType();
                            System.out.println(test);

        
        switch (test) {
            case 'P':
                {
                    Production p = new Production(e.getNom(), e.getPrenom(), e.getAge(), e.getDate());
                    liste.add(p);
                                        System.out.print(p.getFullNom());
liste.add(p);
                    break;
                }
            case 'V':
                {
                    Vente v = new Vente(e.getNom(), e.getPrenom(), e.getAge(), e.getDate());
                    System.out.print(v.getFullNom());
                  
liste.add(v);
                    break;
                }
            case 'M':
                {
                    Manutention m = new Manutention(e.getNom(), e.getPrenom(), e.getAge(), e.getDate());
                    liste.add(m);
                    break;
                }
            default:
                break;
        }
        
        
    }
    
    public void calculerHoraires(int i)
    {
        for (Employe e : liste)
        {
            System.out.print(e.getFullNom() + "travaille tant d'heures : ");
            System.out.println(e.calculerHoraire(i));
        }
    }
    
    public int HoraireMensuel()
    {
        int total = 0;
       
        for (Employe e : liste)
        {
            for (int i = 1; i<5; i++)
            {
                total = total + e.calculerHoraire(i);
            }
        }
        
        return total;
    }
    public void verifierPrimes()
    {
        
    }
}
