/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.5 
#	Fichier    : DesBoutons.java
#	Class      : DesBoutons
*/

import java.awt.*;
import javax.swing.*;
public class DesBoutons extends JPanel {
	public DesBoutons(DessinFormes df, JFrame j)  {
		setBackground(Color.lightGray); 
		// Les boutons
		
		JButton aGaucheScene = new JButton ("A gauche / scene");
		aGaucheScene.addActionListener(new GestionAction(1, df, j));
		this.add(aGaucheScene);
                JButton aGaucheForme = new JButton ("A gauche / formes");
                aGaucheForme.addActionListener(new GestionAction(2, df, j));
                this.add(aGaucheForme);

 	}
}