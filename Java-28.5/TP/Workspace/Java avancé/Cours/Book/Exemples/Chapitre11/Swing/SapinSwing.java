/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Un sapin en swing
#	Fichier  : SapinSwing.java
#	Class    : SapinSwing
*/

import javax.swing.*;
class SapinSwing{
 public	final static int HT = 300;
 public final static int LG = 300;
 public static void main(String [] arg) { 
  JFrame F = new JFrame("Une fenêtre Swing");
  F.setSize(HT, LG);     	// taille de la fenetre
  F.getContentPane().add(new Dessin()); 
  F.setVisible(true);         // affiche la fenetre

 }
}