/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   :  Support pour réaliser l'exercice 11.5 
#	Fichier    : Cercle.java
#	Class      : Cercle
*/


import java.awt.Graphics;
public class Cercle extends Forme {
 private int rayon ;
 
 public Cercle(int nx, int ny, int nr, int nc){
   super(nx, ny, nc);
   rayon = verifier(nr, 0, hauteurEcran);
 }
 public Cercle()	{
    rayon = verifier("Rayon : ", 0, hauteurEcran);
  }

public void dessiner(Graphics g) {
        super.dessiner(g);
	g.fillOval(x, y, rayon, rayon);
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