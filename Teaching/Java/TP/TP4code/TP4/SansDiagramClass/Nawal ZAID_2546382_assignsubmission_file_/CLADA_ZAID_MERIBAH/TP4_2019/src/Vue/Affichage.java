package Vue;

import Modèle.*;
import Contrôleur.*;
import java.util.Map;

/**
 *
 * @author Idris MERIBAH , Nawal ZAID
 */
public class Affichage 
{
    public void afficherTri()
    {
        Instrument i = new Instrument();
        
        i.ajouterFonds(new Fonds(500.d));
        i.ajouterFonds(new Fonds(200.d));
        
        i.sortByAmount();

        i.getValeursFonds().forEach((f) -> {
            System.out.println(f.getAmount());
        });
    } 
     
    public void afficherInstrument()
    {
        Fonds f1 = new Fonds(200.d);
        Fonds f2 = new Fonds(300.d);
        Fonds f3 = new Fonds(400.d);
        
        Instrument i = new Instrument();
        i.getValeursFonds().add(f1);
        i.getValeursFonds().add(f2);
        i.getValeursFonds().add(f3);
        
        Portefeuille p = new Portefeuille();
        Instrument put = p.InstrumentMap().put("Toto", i);
        
        int j = 1;
        
        for (Map.Entry<String, Instrument> entry : p.InstrumentMap().entrySet()) 
        {
            System.out.println("Affichage des informations de l'instrument numéro " + j);
            System.out.println("Clé : " + entry.getKey());
            System.out.println("Nombre total de fonds : " + entry.getValue().getValeursFonds().size());
            System.out.println("Somme totale des montants des fonds : " + entry.getValue().totalAmount() + "\n");
            j++;
        }
    }
    
    public void afficherPourcentages(String key, Portefeuille p)
    {
        boolean exists = true;
        
        try
        {
            double amount = p.rechercherFonds(key);
        }
        
        catch(FondsInexistant fi)
        {
            System.out.println("Erreur : Le fonds recherché n'existe pas.");
            exists = false;
        }
        
        finally
        {
            if (exists)
            {
                // Afficher le pourcentage de chaque instrument pour ce fonds
            }
        }
    }
    
    public static void main(String[] args) 
    {
        Affichage a = new Affichage();
        // a.afficherTri();  
        // a.afficherInstrument();
        // a.afficherPourcentages(key, p);
    }  
}
