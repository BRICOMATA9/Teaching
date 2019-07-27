/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   :  Support pour réaliser l'exercice 11.5 
#	Fichier    : Forme.java
#	Class      : Forme
*/
import java.util.*;
import java.awt.Graphics;
import java.awt.Color;
public class Forme {
 public final static int largeurEcran = 800 ;
 public final static int hauteurEcran = 600 ;

 public final static   Color [] couleurDessin = {Color.green, Color.red, Color.blue, Color.pink, Color.orange, Color.gray};
 public final static int couleurMax = couleurDessin.length;
 protected int x, y, couleur ;
 
 public Forme(int nx, int ny, int nc) {	
 	x = verifier(nx, 0, largeurEcran) ;	
        y = verifier(ny, 0, hauteurEcran) ;
        couleur = verifier(nc, 0, couleurMax);
 }
 
 public Forme() {	
 	x = verifier("en X", 0, largeurEcran);
        y = verifier("en Y", 0, hauteurEcran);
	couleur = verifier("couleur", 0, couleurMax);;
	 }

 public void dessiner(Graphics g) {

	g.setColor(couleurDessin[couleur]);
  }

 public void afficher() {
 	System.out.println("Couleur : " + couleur);
 	System.out.println("Position en " + x + ", " + y); 
 }

 public  int verifier(String s, int a, int b) {
    int resultat=0;
    Scanner lectureClavier = new Scanner(System.in);
    do  {
	System.out.print(s+"          :  ");
    	lectureClavier.nextInt();
    } while ( resultat < a || resultat > b) ;
    return resultat ;
}

 
 public  int verifier(int tmp, int a, int b) {
	if (tmp < a) return a;
	else if ( tmp > b) return b ; 
	else return tmp;
}
 
 
 public void deplacer(int nx, int ny)   {						
 	x = verifier(x+nx, 0, largeurEcran) ;	
    y = verifier(y+ny, 0, hauteurEcran) ;
 }
 
 public void colorier(int nc)   {						
    couleur = verifier(nc, 0, couleurMax);					
 }

public String getInfos() {
 	return couleur+";"+x+";"+y;
 }


public int trouverLeXMin(){
  return x;
}


} // Fin de la classe Forme