package p1;

import java.util.ArrayList;
import java.util.HashMap;

public class Portefeuille {

	HashMap<String, Fond> mapFond;
	HashMap<String, Instrument> mapInstru;
	
	public Portefeuille() {
            mapFond= new HashMap<String,Fond>();
            mapInstru= new HashMap<String,Instrument>();
	
	}
	
        public Portefeuille( HashMap<String, Fond> fonds, HashMap<String, Instrument> instruments){
            mapFond = fonds;
            mapInstru = instruments;
        }
	
	public Portefeuille(String a, Fond b) {
            mapFond= new HashMap<String,Fond>();
            mapFond.put(a, b);
            mapInstru= new HashMap<String,Instrument>();
	}
	 public Portefeuille(String a,  Instrument z) {
            mapFond= new HashMap<String,Fond>();
            mapInstru= new HashMap<String,Instrument>();
            mapInstru.put(a, z);
	 }
			
	 
	public ArrayList<Fond> chercher_i( String a) throws InstumentINexistant
        {
            if ( this.mapInstru.containsKey(a) )
            {
                return mapInstru.get(a).collec;    
            }
            else 
            {
                throw new InstumentINexistant("L'instrument " + a +" n'exite pas dans ce portefeuille " );
            }            
        }
	 
	public double chercher_f( String a) throws FondNexistant 
        {
            double res=0.0;
            if ( this.mapFond.containsKey(a))
            {
                res = this.mapFond.get(a).getMontant(); 
                return res; 
            }
            else 
            {
                throw new FondNexistant("Le fond "+ a + " n'existe pas");
            }            
        }
	 
	public void ajout_f(String a,double o) throws FondExistant
	{
            try{
                ///si ça le trouve ça va lancer une exception
                double t = chercher_f(a);
                
                    throw new FondExistant("Le fond " + a + " existe déjà");
                                
            }catch( FondNexistant fe ){
                ///si l'a pas trouvé, nickel, on peut procéder
                /// if t est false
                Fond deb= new Fond(o);
                mapFond.put(a, deb);
            }  
	}
	
        public void ajout_f(String a, Fond o) throws FondExistant
        {
            try{
                ///si ça le trouve ça va lancer une exception
                double t = chercher_f(a);
                
                throw new FondExistant("Le fond " + a + " existe déjà");
                                
            }catch( FondNexistant fe ){
                ///si l'a pas trouvé, nickel, on peut procéder
                /// if t est false                
                mapFond.put(a, o);
            }
        }
	 
	 public void supp_f(String a) 
	{
            try{                
                ///si ça le trouve pas ,ça va lancer une exception
                chercher_f(a);
                mapFond.remove(a);
                // on remove de la map le fond a 

            }catch( FondNexistant fe ){
                System.out.println(fe.getMessage());
            }  
	}
	 
        public void ajout_new_i(String a)
        {
            try{
                /// génère l'éxception si'il trouve pas
                ArrayList<Fond> inst = chercher_i(a);
                System.out.println("L'instrument existe déjà");
            }
            catch( InstumentINexistant e )
            {
                System.out.println(e.getMessage());
                System.out.println( " Creation de l'instrument "+ a + " dans le portefeuille");
                Instrument deb= new Instrument();
                mapInstru.put(a, deb);
                
            } 
            
            
        }
         //ajoute à un instrument un fond
	 public void ajout_i(String a,Fond b)
	{
            
            try{
                /// génère l'éxception si'il trouve pas
                ArrayList<Fond> inst = chercher_i(a);
                inst.add(b);
            }
            catch( InstumentINexistant e )
            {
                System.out.println(e.getMessage());
                System.out.println( " Creation de l'instrument "+ a + " dans le portefeuille et ajout du fond");
                Instrument deb= new Instrument(b);
                mapInstru.put(a, deb);
//                Instrument inst = mapInstru.get(a);
//                inst.ajout(b);
            } 
	}
		
	public void supp_i(String a) throws InstumentINexistant
	{
            try{
                /// génère l'éxception si'il trouve pas
                ArrayList<Fond> inst = chercher_i(a);
                Instrument u= mapInstru.get(a);
		u.collec.clear(); // on vide l'array
                inst.remove(a);
            }
            catch( InstumentINexistant e )
            {
                System.out.println(e.getMessage());
                System.out.println( " On ne peut donc pas supprimer "+ a + " du portefeuille");
            } 
	}
        
        public void afficher_instr(String key )
        {
            mapInstru.get(key).affiche();
        }
        
        public void afficher_inf_instrus(){
            
            for(String key : mapInstru.keySet())
            {
                System.out.println("    Instrument : " + key );
                afficher_instr(key);
            }
            
        }
        
        public void afficher_hash_fond(){
            for(String key : mapFond.keySet())
            {
                System.out.println("    Fond : " + key );
                System.out.println("        montant : " + mapFond.get(key).getMontant() );
               
            }
        }
         
        
	 
	
}
		
	
	

