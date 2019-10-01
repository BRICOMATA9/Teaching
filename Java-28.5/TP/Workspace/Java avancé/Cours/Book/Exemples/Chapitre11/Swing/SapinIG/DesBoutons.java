/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Modifier les modèles de présentation de l'interface
#	Fichier  : DesBoutons.java
#	Class    : DesBoutons
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class DesBoutons extends JPanel {
	public DesBoutons(Dessin d, JFrame j)  {
		setBackground(Color.lightGray); 
		// Les boutons
		JButton bPeindre = new JButton ("Nouveau");
		bPeindre.addActionListener(new GestionAction(1, d, j));
		this.add(bPeindre);
    JButton bModèle = new JButton ("Modele");
    bModèle.addActionListener(new GestionAction(3, d, j));
    this.add(bModèle);

    JButton bQuitter = new JButton ("Quitter");
    bQuitter.addActionListener(new GestionAction(2, d, j));
    this.add(bQuitter);
 	}
}