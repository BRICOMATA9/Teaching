/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.2 et 10.5
#	Fichier    : Cercle.java
#	Class      : Cercle
*/

public class Cercle extends Forme {
 private int rayon ;
 
 public Cercle(int nx, int ny, int nr, int nc){
   super(nx, ny, nc);
   rayon = verifier(nr, 0, hauteurEcran);
 }
 public Cercle()	{
    rayon = verifier("Rayon : ", 0, hauteurEcran);
  }
 
 public void afficher()  {
  super.afficher();
  System.out.println("Rayon : " + rayon);
 }

public String getInfos() {
        String tmp = super.getInfos();
 	return "C;"+tmp+";"+rayon+";";
 }
} // Fin de la classe Cercle