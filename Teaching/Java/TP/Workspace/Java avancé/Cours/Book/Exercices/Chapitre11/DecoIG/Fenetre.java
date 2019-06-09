/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.1 et 11.2 
#	Fichier    : Fenetre.java
#	Class      : Fenetre
*/

import java.awt.*;
class Fenetre {
public	final static int HT = 300;
public 	final static int LG = 300;
 public static void main(String [] arg) {
  
 	Frame F = new Frame();
 	Dessin page = new Dessin();
 	F.setTitle("Un sapin de Noel"); // met le titre
	F.setSize(HT, LG);     // taille de la fenetre
	F.setBackground(Color.darkGray);
 	F.addWindowListener(new GestionFenetre());
 	F.add(page , "Center"); 
        F.add(new DesBoutons(page), "South"); 

 	F.setVisible(true);              // affiche la fenetre

 
 }
}