/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.1 et 11.2 
#	Fichier    : DesBoutons.java
#	Class      : DesBoutons
*/

import java.awt.*;
import java.awt.event.*;
public class DesBoutons extends Panel {
 public DesBoutons(Dessin d)  {
  setBackground(Color.lightGray); 
  Checkbox CaseCoche = new Checkbox("Taille Fixe");
  CaseCoche.addItemListener(new GestionAction(0, d));
  this.add(CaseCoche);
  Button bPeindre = new Button ("Nouveau");
  bPeindre.addActionListener(new GestionAction(1, d));
  this.add(bPeindre);
  Button bQuitter = new Button ("Quitter");
  bQuitter.addActionListener(new GestionAction(2, d));
  this.add(bQuitter);
 }
}