package Interfaces;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import Systeme.*;
/**
 * Interface graphique de connexion au serveur
 * @author Alexander Remen et Tonya Vo Thanh
 * <p>Classe qui gère l'interface graphique de la connection au serveur.</p> 
 *
 */
public class Interface_Connexion {

	private JTextField TFlogin = new JTextField(15);
	private JTextField TFmdp = new JTextField(15);
	/*
     * Centre la fenetre au milieu de l'ecran
     * @param frame - la fenetre
     */
	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Dimension frameSize = frame.getSize();
	   frame.setLocation((screenSize.width / 2) - (frameSize.width / 2), (screenSize.height / 2) - (frameSize.height / 2));
	}
	
	/**
	 * Methode qui affiche la fenetre de connexion
	 *
	 */
	public void affiche_login_screen(final Client Classeclient) {
		/* La fenêtre */
		final JFrame fenetre = new JFrame("Connexion");
		fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Actions action = new Actions(Classeclient);
		fenetre.addWindowListener(action.getFermerWindows());
		fenetre.setSize(300,200);
		centerFrame(fenetre);
		
		/* Labels et Gridbaglayout */
		JLabel Llogin = new JLabel("Login");
		JLabel Lmdp = new JLabel("Mot de passe");
		JButton Valider = new JButton("Connexion");
		GridBagLayout layout = new GridBagLayout();
		JPanel pconnexion = new JPanel(layout);
				
		JMenuBar menu = new JMenuBar();
		JMenu mfichier = new JMenu("Fichier");
		JMenuItem quitter = new JMenuItem("Quitter");
				
		/* Action valider lorsqu'on clique sur le boutton valider */
		ActionListener valider = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//envoi un signal au serveur avec 2 parametres le nom et le mdp
				boolean test=false;
				try {
					test = Classeclient.Connexion(TFlogin.getText(), TFmdp.getText());
				} catch (IOException e1) {
					//e1.printStackTrace();
				} //retour de envoi_signal();
				catch (ClassNotFoundException e1) {
					//e1.printStackTrace();
				}
				if (test == false){
					JOptionPane.showMessageDialog(null,"Connexion echoue","Connexion echoue",JOptionPane.ERROR_MESSAGE);
				}
				else{
					try {
						Classeclient.Afficher_Emploi_du_temps();
					} catch (IOException e1) {
						//e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						//	e1.printStackTrace();
					}
					fenetre.setVisible(false);
					
				}
					
			}
		};
		Valider.addActionListener(valider);
		quitter.addActionListener(action.getFermerButton());
		mfichier.add(quitter);
		menu.add(mfichier);
		
		
		//fenetre.getContentPane().setLayout(layout);
		
		/*====================INSERTIONS DES ELEMENTS===================*/
		
		//Jlabel llogin
		GridBagConstraints gcLlogin = new GridBagConstraints();
		gcLlogin.gridx = 1;
		gcLlogin.gridy = 1;
		gcLlogin.gridheight = 5;
		gcLlogin.gridwidth= 2;
		gcLlogin.weightx =50;
		gcLlogin.weighty =10;
		gcLlogin.insets = new Insets(10, 10, 20, 10);
		gcLlogin.anchor = GridBagConstraints.CENTER;
		
		pconnexion.add(Llogin, gcLlogin);
		
		//JTextField TFlogin
		GridBagConstraints gcTFlogin = new GridBagConstraints();
		gcTFlogin.gridx = 3;
		gcTFlogin.gridy = 1;
		gcTFlogin.gridheight = 5;
		gcTFlogin.gridwidth= 2;
		gcTFlogin.weightx =50;
		gcTFlogin.weighty =10;
		gcTFlogin.insets = new Insets(10, 10, 20, 10);
		gcTFlogin.anchor = GridBagConstraints.CENTER;
		
		pconnexion.add(TFlogin, gcTFlogin);
		
		//Jlabel lmdp
		GridBagConstraints gcLmdp = new GridBagConstraints();
		gcLmdp.gridx = 1;
		gcLmdp.gridy = 7;
		gcLmdp.gridheight = 5;
		gcLmdp.gridwidth= 2;
		gcLmdp.weightx =50;
		gcLmdp.weighty =10;
		gcLmdp.insets = new Insets(1, 10, 20, 10);
		gcLmdp.anchor = GridBagConstraints.CENTER;
		
		pconnexion.add(Lmdp, gcLmdp);
		
		//JTextField TFmdp
		GridBagConstraints gcTFmdp = new GridBagConstraints();
		gcTFmdp.gridx = 3;
		gcTFmdp.gridy = 7;
		gcTFmdp.gridheight = 5;
		gcTFmdp.gridwidth= 2;
		gcTFmdp.weightx =50;
		gcTFmdp.weighty =10;
		gcTFmdp.insets = new Insets(1, 10, 20, 10);
		gcTFmdp.anchor = GridBagConstraints.CENTER;
		
		pconnexion.add(TFmdp, gcTFmdp);
		
		//JButton Valider
		GridBagConstraints gcval = new GridBagConstraints();
		gcval.gridx = 3;
		gcval.gridy = 14;
		gcval.gridheight = 5;
		gcval.gridwidth = 2;
		gcval.weightx = 50;
		gcval.weighty =10;
		gcval.insets = new Insets(1, 10, 10, 10);
		gcval.anchor = GridBagConstraints.SOUTH;
		
		pconnexion.add(Valider, gcval);
		
		pconnexion.setSize(50, 50);
				
		fenetre.getContentPane().add(pconnexion, BorderLayout.CENTER);
		fenetre.setJMenuBar(menu);
		
		//fenetre.pack();
		fenetre.setVisible(true);


	}

}
