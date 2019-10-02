/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author alexa
 */
public class Vue {
    
    public Vue()
    {
                
    }
    
    //affiche les fonds d'un instrument
    public void afficherfonds(ArrayList<Fonds> collectionFonds)
    {
         for(int j=0;j<collectionFonds.size();j++)
        {
          System.out.println(collectionFonds.get(j).getAmount());
        }
    }
    
    //Affiche la clé, le nombre de fond dans l'instrument
    public void affichage(Portefeuille t)
    {
        double somme=0;
        for (Map.Entry<String, Instrument> entry : t.getTableI().entrySet())
	{
            String a= entry.getKey();
            int b=t.getTableI().get(a).getCollectionFonds().size();
            System.out.println("La clé de l'instrument est: "+a);
            System.out.println("Le nombre de fonds: "+b);
            for(int j=0;j<b;j++)
            {
                somme=somme+t.getTableI().get(a).getCollectionFonds().get(j).getAmount();
            }
            System.out.println("La somme des fonds est: "+somme);
            somme=0;
        }
    }
    
    //affiche le pourcentage de chaque instrument pour un fond
    public void pourcentage(String key, Portefeuille p) throws FondINexistant
    {
        //Le but étant de rechercher le pourçentage du fonds donné en paramètre dans chaque collection de fonds de chaque instrument.
        int cpt=0;
        float pourcent;
       
        //Regarde si le fonds existent dans la collection de fond du portefeuille
        //si oui: 
        if(p.getTableF().containsKey(key)==true)
        {
            //on regarde chaque instrument
            for (Map.Entry<String, Instrument> it : p.getTableI().entrySet()) 
            {
                //On s'interesse à chaque fonds de l'instrument
                for(int j=0;j< it.getValue().getCollectionFonds().size();j++)
                { 
                    //Si l'amount du fonds recherché == amount du fonds de la collectionFonds.get(j)
                    if(p.getTableF().get(key).getAmount()== it.getValue().getCollectionFonds().get(j).getAmount())
                    {
                         cpt++;
                    }
                }
                // (nb de fonds recherché == fonds contenue dans la collection)/nb total de fonds de l'instrument.
                pourcent= ((float)cpt/ it.getValue().getCollectionFonds().size())*100; 
                
                System.out.println("Le pourcentage de chaque instrument pour ce fond est: "+ pourcent+"%");
                //réinitialise le cpt.
                cpt = 0; 
		//System.out.println(it.getKey() + " = " + it.getValue());
            }
        }
        else 
        {
            throw new FondINexistant();
        }
    }
}
