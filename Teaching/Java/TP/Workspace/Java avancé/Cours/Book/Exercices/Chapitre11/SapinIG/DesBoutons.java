/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.3 et 11.4 
#	Fichier    : DesBoutons.java
#	Class      : DesBoutons
*/

import java.awt.*;
import java.awt.event.*;
public class DesBoutons extends Panel {
 public DesBoutons(Dessin d)  {
  // initialisation
  setBackground(Color.lightGray); 
  // Les boutons
  Button bPeindre = new Button ("Nouveau");
  Button bQuitter = new Button ("Quitter");
  
  bPeindre.addActionListener(new GestionAction(1, d));
 	this.add(bPeindre);

 	bQuitter.addActionListener(new GestionAction(2, d));
  this.add(bQuitter);
	}
}