package p1;
import java.util.*;

public class Instrument {
	
    ArrayList<Fond> collec;

    public Instrument()
    {
        collec= new ArrayList<Fond>();
    }

    public Instrument(Fond a)
    {
        collec = new ArrayList<Fond>();
        collec.add(a);
    }

    public void ajout(Fond a)
    {
        collec.add(a);
    }
    
    public void affiche(){
        System.out.println("                     nombre de fonds : " + nb_fond() );
        System.out.println("                     somme totale des fonds : " + somme_fond_tot() );
    }
    
    
    public int nb_fond(){ return collec.size(); }
    public double somme_fond_tot()
    {
        double somme = 0;
        for (Fond aze : collec) {
            somme += aze.getMontant();
        }
        return somme;
    }
    
    public void tri()
    {
        double tempo, tempi, tempj;
        for (int i = 0; i < collec.size(); i++) {
            
            for (int j = i+1; j < collec.size(); j++) {
                if( collec.get(i).compareTo( collec.get(j) ) == 1 ){
                    tempo = collec.get(i).getMontant();
                    tempj = collec.get(j).getMontant();
                    
                    
//                    System.out.println("i : " +i +" j "+ j+" " + " size : "+ collec.size()+ "  ");
//                    System.out.println("  got : " +tempo +"  " + tempj +" ");
                    
                    Fond f1 = collec.get(i);
                    Fond f2 = collec.get(j);
                    f1.setMontant(tempj);
                    f2.setMontant(tempo);
//                    System.out.println("  done : " + f1.getMontant()+" " + f2.getMontant() );   
                }
//                else System.out.println(" boucle  i j " + i +" "+ j);
            }           
        }
        
        
        
//        
//        ArrayList temp = new  ArrayList();
//
//        for(int i=0;i<collec.size();i++)
//        {
//                temp.add(collec.get(i).getMontant());
//
//        }
//
//        Collections.sort(temp);
//
//        for(int i=0;i<collec.size();i++)
//        {
//            //temp.add(collec.get(i).getMontant());
//
//            collec.get(i).setMontant( (double) temp.get(i));
//
//        }
    }

}
