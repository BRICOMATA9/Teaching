public class Citoyen  
{ 
 public String nom;
 public String prenom;
 public Adresse adr;
 public Citoyen (String nom ,String prenom ,Adresse adr)
 { 
  this.nom=nom;
  this.prenom=prenom;
  this.adr=adr;
 }
 public void afficheCitoyen()
 { 
   System.out.println (nom);
   System.out.println (prenom);
   adr.afficheAdresse ();
 }
}

