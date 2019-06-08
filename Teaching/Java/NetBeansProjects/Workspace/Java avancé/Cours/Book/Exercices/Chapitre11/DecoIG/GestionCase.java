/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.1 et 11.2 
#	Fichier    : GestionCase.java
#	Class      : GestionCase
*/


import java.awt.*;
import java.awt.event.*;

public class GestionCase implements ItemListener
{

 private Dessin d;
 
 public GestionCase(Dessin d)
 {
  this.d = d;
 }
 
 public void itemStateChanged(ItemEvent e) {
   if(e.getStateChange() == ItemEvent.SELECTED)  d.nouveau(false);
   else d.nouveau(true);
 }

}