/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package delgay_melloul;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Portefeuille {
    
    //attributs
    private HashMap<String,Fonds> fonds;
    private HashMap<String,Instrument> instruments;
    
    
    //ctors
    public Portefeuille(){
        fonds = new HashMap<String,Fonds>();
        instruments = new HashMap<String,Instrument>();
    }
    public Portefeuille(HashMap<String,Fonds> hashMapFonds, HashMap<String,Instrument> hashMapInstrument){
        fonds = hashMapFonds;
        instruments = hashMapInstrument;
    }
    
    
    //methodes
    public double chercherFond(String cleFond) throws FondsInexistant{
        if(!fonds.containsKey(cleFond))
            throw new FondsInexistant();
        else
            return fonds.get(cleFond).GetMontant();
    }
    
    public ArrayList<Fonds> chercherInstrument(String cleInstru) throws InstrumentInexistant{
        if(!instruments.containsKey(cleInstru))
            throw new InstrumentInexistant();
        else
            return instruments.get(cleInstru).getMontants();
    }
    
    public void ajouterFondHashMap(String cleFond, double montant) throws FondsExistant{
        if(fonds.containsKey(cleFond))
            throw new FondsExistant();
        else{
            Fonds f = new Fonds(montant);
            fonds.put(cleFond, f);
            System.out.println("Add '"+ cleFond +"' successfull");
        }
    }
    
    public void ajouterFondInstrument(String cleInstru, Fonds f){
        instruments.get(cleInstru).ajouterFond(f);
        System.out.println("Add '"+ cleInstru +"' successfull");
    }
    
    public void supprimerFond(String cleFond){
        try{
            chercherFond(cleFond);
            fonds.remove(cleFond);
            System.out.println("Remove '"+ cleFond +"' successfull");
        }
        catch(FondsInexistant e){
            System.out.println("Fond inexistant, echec de la suppression");
        }
    }
    
    public void supprimerInstrument(String cleInstru){
        try{
            chercherInstrument(cleInstru);
            instruments.get(cleInstru).getMontants().clear(); //vider l'ArrayList de Fonds en premier
            instruments.remove(cleInstru);
            System.out.println("Remove '"+ cleInstru +"' successfull");
        }
        catch(InstrumentInexistant e){
            System.out.println("Instrument inexistant, echec de la suppression");
        }
    }
    
    public void afficherInstruments(){
        for (Map.Entry mapentry : instruments.entrySet()) {
            double somme = 0;
            System.out.println("clé :" + mapentry.getKey() );
            System.out.println("nombre total de fond : " + instruments.get(mapentry.getKey()).getMontants().size() );
            for(Fonds f : instruments.get(mapentry.getKey()).getMontants()){
                somme += f.GetMontant();
            }
            System.out.println("somme totale des montants : " + somme);
        }
    }
    
    public void afficherPourcentage(String cleFond){
        try{
            this.chercherFond(cleFond);
            for (Map.Entry mapentry : instruments.entrySet()) {
                System.out.println("clé :" + mapentry.getKey() );
                boolean present = false;
                for(Fonds f : instruments.get(mapentry.getKey()).getMontants()){
                    if(f.GetMontant() ==  fonds.get(cleFond).GetMontant())
                        present = true;
                }
                if(present)
                    System.out.println("pourcentage du fond " + cleFond + " : " + 1 / instruments.get(mapentry.getKey()).getMontants().size() * 100 + "%" );
                else
                    System.out.println("pourcentage du fond " + cleFond + " : 0%" );
            }
        } catch(FondsInexistant e){
            
        }
    }
    
    
    //accesseurs
    public HashMap<String,Fonds> getFonds(){return fonds;}
    public HashMap<String,Instrument> getInstruments(){return instruments;}
    
}
