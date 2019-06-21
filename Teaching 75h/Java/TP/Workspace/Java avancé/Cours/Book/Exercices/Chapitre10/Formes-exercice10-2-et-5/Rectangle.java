/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.2 et 10.5 
#	Fichier    : Rectangle.java
#	Class      : Rectangle
*/

public class Rectangle extends Forme {

 private int largeur, hauteur  ; 
 public Rectangle(int nx, int ny, int nl, int nh, int nc)	{
   super(nx, ny, nc);
   largeur = verifier(nl, 0, largeurEcran);
   hauteur = verifier(nh, 0, hauteurEcran);
 }
 
 public Rectangle()	{
    largeur = verifier("Largeur", 0, largeurEcran);
    hauteur = verifier("Hauteur", 0, hauteurEcran);
  }
 
 public void afficher()  {
  super.afficher();
  System.out.println("Largeur du rectangle : " + largeur);
  System.out.println("Hauteur du rectangle : " + hauteur);
 }
public String getInfos() {
        String tmp = super.getInfos();
 	return "R;"+tmp+";"+largeur+";"+hauteur;
 }
 

} // Fin de la classe Rectangle