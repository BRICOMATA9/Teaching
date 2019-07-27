package Interfaces;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import bdd.Personne;

import Systeme.Client;
/**
 * Interface graphique d'envoi d'email
 * @author Alexander Remen et Tonya Vo Thanh
 * <p>Cette classe devrait être instanciée en même temps que la classe {@link Interface_EDT} car elle n'est que caché lorsqu'elle n'est pas visible.
 * Ceci fait que lorsque l'utilisateur appuye sur "Envoi email" sur l'{@link Interface_EDT} elle met {@code setVisible=true}<p> 
 * @see Client
 */
public class Liste_Contacts {

	private final JFrame fenetre = new JFrame();
	private JTextField Sujet = new JTextField(35);
	private JTextArea Message= new JTextArea("",20,37);


	/**
     * Afficher la fenetre d'envoi d'email
     */
	public void affiche_interface_mail(){
		
		fenetre.setVisible(true);
		
	}
	/**
     * Centre la fenetre au milieu de l'ecran
     * @param frame - la fenetre
     */
	private static void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Dimension frameSize = frame.getSize();
	   frame.setLocation((screenSize.width / 2) - (frameSize.width / 2), (screenSize.height / 2) - (frameSize.height / 2));
	}
	
	/**
	 * @param liste_emails_nom - Vecteur de personnes auxquels on veut envoyer un mail
	 * @param Classeclient - Le client qui a crée cette classe
	 * @see Personne Client
	 */
	public void Init_fenetre_mail(Vector<Personne>liste_emails_nom,final Client Classeclient) {	
		fenetre.setTitle("Envoyer un message");
		fenetre.setSize(500,500);
		centerFrame(fenetre);
		
		
		
		/* Choix du nom NORD */
		JLabel LNom = new JLabel("Choix du destinataire");
		final JComboBox ListeContacts = new JComboBox(liste_emails_nom);
		JPanel pcontacts = new JPanel();
		
		/* Bouton SUD*/
		JButton Valider = new JButton("Valider");
		JButton Annuler = new JButton("Annuler");
		JPanel buttonspane = new JPanel();
		
		/* Message et Sujet CENTER */
		JLabel LSujet = new JLabel("Sujet: ");
		JLabel LMessage = new JLabel("Message: ");
		
		JPanel messagepane = new JPanel();
		JPanel messagenord = new JPanel();
		JPanel messagesud = new JPanel();

				
		JMenuBar menu = new JMenuBar();
		JMenu mfichier = new JMenu("Fichier");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		/* Action fermer*/
		ActionListener fermer = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int r = JOptionPane.showConfirmDialog(null,"Veux tu vraiment quitter?","Fermeture",JOptionPane.YES_NO_OPTION);
				if (r == JOptionPane.YES_OPTION){
					System.exit(1);
				}
				
			}
		};
		quitter.addActionListener(fermer);
		
		
		/* Action valider - envoyer mail */
		ActionListener envoyer = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/* On envoit un signal au serveur qui envoi ensuite le mail */
				//TODO
				
				try {
					if (Classeclient.Envoi_email(((Personne)(ListeContacts.getSelectedItem())).getEmail(),Sujet.getText(),Message.getText())==false)
					{
						JOptionPane.showMessageDialog(fenetre,"Envoi du mail echoué ","Mail pas envoyé",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(fenetre,"Mail envoyé");
						fenetre.setVisible(false);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		Valider.addActionListener(envoyer);
		
		/* Action annuler */
		ActionListener annuler = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fenetre.setVisible(false);				
			}
		};
		Annuler.addActionListener(annuler);
		
		mfichier.add(quitter);
		menu.add(mfichier);
		
		
		
		fenetre.getContentPane().setLayout(new BorderLayout());
		
		
		/*====================INSERTIONS DES ELEMENTS===================*/
				
		/* Labels et liste de contacts nord de la fenetre */
		
		pcontacts.add(LNom,BorderLayout.CENTER);		
		pcontacts.add(ListeContacts, BorderLayout.EAST);
		
		/* Le label sujet et textbox sujet au nord dans le centre de la fenetre */
		//messagenord.setLayout(new BorderLayout());
		messagenord.add(LSujet,BorderLayout.CENTER);
		Sujet.setText("[EDT]");
		messagenord.add(Sujet,BorderLayout.EAST);
		
		/* Les textbox sujet et message est sur la fenetre */
		//messagesud.setLayout(new BorderLayout());
		/*Message.setEditable(true);
		Message.setEnabled(true);*/
		Message.setLineWrap(true);
		messagesud.add(LMessage,BorderLayout.CENTER);
		messagesud.add(Message,BorderLayout.EAST);
		
		/* Le panel regroupant les 4 elements au centre de la fenetre */
		messagepane.setLayout(new BorderLayout());
		messagepane.add(messagenord,BorderLayout.NORTH);
		messagepane.add(messagesud,BorderLayout.SOUTH);
		
		
		/* Le panel regroupant les bouttons au sud de la fenetre */
		buttonspane.add(Annuler,BorderLayout.WEST);
		buttonspane.add(Valider,BorderLayout.EAST);

		/* Le panel principal */
		fenetre.getContentPane().add(pcontacts, BorderLayout.NORTH);
		fenetre.getContentPane().add(messagepane, BorderLayout.CENTER);
		fenetre.getContentPane().add(buttonspane,BorderLayout.SOUTH);
		fenetre.setJMenuBar(menu);	
	}
	
}
