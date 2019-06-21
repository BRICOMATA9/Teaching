import java.util.Scanner;
  
public class principale
{ 
 public static void main (String[] arguments)
 {
  int i;
  Citoyen c[]=new Citoyen[10];
  Adresse A=new Adresse();
  Scanner lire =new Scanner (System.in);
  for (i=0;i<3;i++) 
  {
   A.numero=(lire.nextInt());
   A.codep=(lire.nextInt());
   A.nom=(lire.next());  
   A.ville=(lire.next());
   c[i]=new Citoyen (lire.next(),lire.next(),A); 
  }
  for (i=0;i<3;i++) 
  {
   c[i].afficheCitoyen();
  }
 } 
}
