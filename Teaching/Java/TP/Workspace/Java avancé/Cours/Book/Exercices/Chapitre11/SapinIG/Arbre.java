/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.3 et 11.4 
#	Fichier    : Arbre.java
#	Class      : Arbre
*/


import java.awt.*;
class Arbre {
  private int milieuSapinX ; 
  private int milieuSapinY ; 

  int [][] sapin ;
  private Color décoration = Color.red;
 
 public Arbre(int nl, Color c) {  
  int nc = 2*nl-1;
 	milieuSapinX = nc / 2;
 	milieuSapinY = nl / 2;
 	décoration = c;
 	sapin = new int[nl][nc];
	int milieu = sapin[0].length/2;
	for ( int j = 0 ; j < nl ; j++) {
	 for ( int i = -j; i <= j; i++) {
	 	sapin[j][milieu+i] = (int ) (5*Math.random()+1);
	 }
	}	
 }
 
 public void dessine(Graphics g)
 {
  Color Vert = Color.green;
 	for (int i = 0; i < sapin.length; i++) {	 
		for (int j = 0; j < sapin[0].length; j++) {
			  int   posX = i - milieuSapinX;
			  int   posY = j - milieuSapinY;
			  switch(sapin[i][j]) {
     	 	 	case 1 : new Triangle(posX, posY, g, décoration);
     	 	 	break;
			    	case 2 : Vert = Vert.brighter();		
			    new Triangle(posX, posY, g, Vert);  
     	 	 	break;
          	case 3 :	Vert = Vert.darker();
          		new Triangle(posX, posY, g, Vert); 
     	 	 	break;
			    	case 4 :	Vert = Vert.brighter();
			    	new Triangle(posX, posY, g, Vert);
     	 	 	break;
			    	case 5 :	Vert = Vert.darker();
			    new Triangle(posX, posY, g, Vert); 
     	 	 	break;
			    	case 6 :	Vert = Vert.brighter();
     	 	 new Triangle(posX, posY, g, Vert); 
     	 	 	break;
     	 	 }
		}
	}
 }
 
}
  