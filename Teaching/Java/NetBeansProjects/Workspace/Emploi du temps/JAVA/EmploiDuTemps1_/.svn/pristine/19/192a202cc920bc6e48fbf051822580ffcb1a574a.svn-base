package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import Systeme.*;

/**
 * Classe qui gere la fermeture des interfaces graphiques
 * @author Tonya Vo Thanh et Alexander Remen
 * <p>Classe qui s'occuppe de l'action fermer de chaque interface graphique</p>
 */
public class Actions {

	private Client Classeclient;
	
	
	
	ActionListener fermer1 = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			fermeture();
		}
	};
	
	WindowAdapter fermer2 = new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			fermeture();
		}
	};
	
	private void fermeture()
	{
		int r = JOptionPane.showConfirmDialog(null,"Veux tu vraiment quitter?","Fermeture",JOptionPane.YES_NO_OPTION);
		if (r == JOptionPane.YES_OPTION){
			Classeclient.FermerConnexion();
			System.exit(1);
		}
		
	}

	/**
	 * Constructeur de la classe Actions
	 * @param classeclient - La classe qui a instanciée l'interface graphique à fermer
	 * On a besoin de la classe client parce qu'on doit fermer la connection (méthode dans la classe client).
	 */
	public Actions(Client classeclient) {
		Classeclient = classeclient;
	}


	/**
	 * Action utilisé lorsqu'on veux fermer la fenêtre avec le bouton dans le menu.
	 * @return l'action a faire
	 */
	public ActionListener getFermerButton() {
		return fermer1;
	}


	/**
	 * Action utilisé lorsqu'on veux fermer la fenêtre avec la croix en haut à droite.
	 * @return l'action a faire
	 */
	public WindowAdapter getFermerWindows() {
		return fermer2;
	}

	
	
}
