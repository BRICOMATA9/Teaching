/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   :  Support pour réaliser l'exercice 11.5 
#	Fichier    : DesBoutons.java
#	Class      : DesBoutons
*/

import java.awt.*;
import javax.swing.*;
public class DesBoutons extends JPanel {
 public DesBoutons(DessinFormes df, JFrame j)  {
   setBackground(Color.lightGray); 
   // Le bouton A gauche / Scene		
   JButton aGaucheScene = new JButton ("A gauche / scene");
   aGaucheScene.addActionListener(new GestionAction(1, df, j));
   this.add(aGaucheScene);
   // Le bouton A gauche / formes
   JButton aGaucheForme = new JButton ("A gauche / formes");
   aGaucheForme.addActionListener(new GestionAction(2, df, j));
   this.add(aGaucheForme);
  }
}