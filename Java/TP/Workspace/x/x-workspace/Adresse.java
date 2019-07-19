public class Adresse
{
 public int numero;
 public String nom;
 public int codep;
 public String ville;
 public int getnumero()
  {
   return numero;
  }
 public void setnumero (int numero)
  { 
   this.numero=numero;
  }
 public String getnom()
  { 
   return nom;
  }
  public void setnom (String nom)
  {
   this.nom=nom;
  }
  public int getcodep()
  { 
   return codep;
  }
  public void setcodep (int codep)
  {
   this.codep=codep;
  }
  public String getville()
  { 
   return ville;
  }
  public void setville (String ville)
  {
   this.ville=ville;
  }
  public void afficheAdresse ()
  {
   System.out.println(numero);
   System.out.println(nom);
   System.out.println(codep);
   System.out.println(ville);
  }
}
