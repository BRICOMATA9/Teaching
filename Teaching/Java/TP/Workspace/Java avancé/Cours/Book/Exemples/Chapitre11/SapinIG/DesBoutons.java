/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les événements
#	Fichier  : DesBoutons.java
#	Class    : DesBoutons
*/
import java.awt.*;
import java.awt.event.*;
public class DesBoutons extends Panel {
	public DesBoutons(Dessin d)  {
		setBackground(Color.lightGray); 
		// Les boutons
		Button bPeindre = new Button ("Nouveau");
		bPeindre.addActionListener(new GestionAction(1, d));
		this.add(bPeindre);
		Button bQuitter = new Button ("Quitter");
		bQuitter.addActionListener(new GestionAction(2, d));
		this.add(bQuitter);
	}
}