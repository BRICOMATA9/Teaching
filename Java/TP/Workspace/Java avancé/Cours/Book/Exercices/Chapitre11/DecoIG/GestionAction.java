/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.1 et 11.2 
#	Fichier    : GestionAction.java
#	Class      : GestionAction
*/

import java.awt.*;
import java.awt.event.*;
public class GestionAction implements ActionListener, ItemListener {
 private int n;
 private Dessin d;
 private static boolean OK = true;
 public GestionAction( int n, Dessin d) {
	this.n = n;
	this.d = d;
 }
public void actionPerformed(ActionEvent e) {
	switch (n) {
	case 2 : System.exit(0);
	break;
	case 1 : d.nouveau(OK); 
	break;
	}
 }
public void itemStateChanged(ItemEvent e) {
	if(e.getStateChange() == ItemEvent.SELECTED)  OK = false;
	 else OK = true;
 }
}