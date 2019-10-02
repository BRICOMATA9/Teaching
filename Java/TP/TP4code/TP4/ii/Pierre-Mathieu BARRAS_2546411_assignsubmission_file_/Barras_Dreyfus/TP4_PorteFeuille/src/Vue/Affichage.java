/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.FondsInexistants;
import java.util.HashMap;
import Modele.PorteFeuille;
import Modele.Instrument;
/**
 *
 * @author evadr
 */
public class Affichage {
    
    public void displayInstruments (PorteFeuille i)
    {
        
        
        for(HashMap.Entry<String,Instrument> entry : i.getInstrument().entrySet()){
            double count=0;
            
            for(int j=0;j<entry.getValue().getValeurFonds().size();j++){
                count = count + entry.getValue().getValeurFonds().get(j).getAmount();
            }
            
            System.out.println("Key : " + entry.getKey() + " Nombre total de fonds: " + entry.getValue().getValeurFonds().size() + " Montant total des fonds : " + count );
            
        }
       
        
        
        
       
       
    }
    
    public double displayPercentage (String cleFonds,PorteFeuille p) throws FondsInexistants
    {
        double percentage=0;
        double nbInstrument=0;
        
        double amount = p.rechercheFonds(cleFonds);
        
        for(HashMap.Entry<String,Instrument> entry : p.getInstrument().entrySet()){
            nbInstrument++;
            for(int i=0;i<entry.getValue().getValeurFonds().size();i++){
                if(amount==entry.getValue().getValeurFonds().get(i).getAmount()){
                    percentage++;
                }
            }
        }
        
        return (percentage/nbInstrument)*100;
    }
}
