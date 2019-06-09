package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modele.API_YahooFinance;
import modele.Gestion_Entreprises_Interdites_achat;
import modele.Gestion_base_de_donnee;
import modele.ModeleDynamiqueObjet;
import modele.Portefeuille;
import modele.jcomboboxachatvente;
import modele.jcomboboxajout;
import vue.Panel_interface;
import vue.Renderer_combobox_ajout;

public class bouton_ajouter extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JLabel  Labelquantite;
	private JTextField champ_nombreaction ;
	private   JComboBox<?> jcb;
	private JLabel affichage_valeur;
	private static ArrayList<String> listeentreprise_copie;
	private static ArrayList<String> listeentreprise ;
	private static ArrayList<String> listeIDcorrespondant1 ;
	private static ArrayList<String> listeIDcorrespondant;
	private static String nombre_actions_entreprise_a_ajouter;
	private static 	double valeur_action ;
	private static JButton okBouton = new JButton("OK");
	private static JButton cancelBouton = new JButton("Annuler");
	public bouton_ajouter(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
	}



	@SuppressWarnings("unchecked")
	private void initComponent(){
			
		listeentreprise = jcomboboxajout.recupererlisteentrepriseajouter();
		listeIDcorrespondant1 = jcomboboxajout.recupererlisteIDajout();
		listeIDcorrespondant=listeIDcorrespondant1;
		listeentreprise_copie=listeentreprise;
		
		//TextField nombreaction
		JPanel paneltextfieldnombreaction = new JPanel();
		paneltextfieldnombreaction.setBackground(Color.white);
		paneltextfieldnombreaction.setPreferredSize(new Dimension(450, 90));
		champ_nombreaction = new JTextField();
		champ_nombreaction .setPreferredSize(new Dimension(100, 25));
		paneltextfieldnombreaction.setBorder(BorderFactory.createTitledBorder("Nombre d'actions dans l'entreprise :"));
		Labelquantite = new JLabel("Quantite :");
		paneltextfieldnombreaction.add( Labelquantite);
		paneltextfieldnombreaction.add(champ_nombreaction );

		//Panneau Combobox entreprises
		JPanel panelcombobox = new JPanel();
		panelcombobox.setBackground(Color.white);
		panelcombobox.setPreferredSize(new Dimension(450, 90));
		panelcombobox.setBorder(BorderFactory.createTitledBorder("Selection de l'entreprise"));
		jcb = new JComboBox<Object>(listeentreprise_copie.toArray());
		 affichage_valeur = new JLabel();
		 Renderer_combobox_ajout renderer = new Renderer_combobox_ajout();
		 jcb.setRenderer(renderer);
		 jcb.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(jcb.getSelectedItem().toString())==true){
					bouton_ajouter.okBouton.setEnabled(false);
				}
				else{
					bouton_ajouter.okBouton.setEnabled(true);
				}
			}
		 });
		 
			jcb.addActionListener(new ActionListener(){
				@Override
				 public void actionPerformed(ActionEvent e) {
					String IDcorrespondant = null;
			        String entreprise = (String)jcb.getSelectedItem();
			        for( int i=0;i<listeIDcorrespondant.size();i++){
						if(i==listeentreprise_copie.indexOf(entreprise)){
							IDcorrespondant = listeIDcorrespondant.get(i);
						}
					}
			       try {
					valeur_action = API_YahooFinance.valeuraction(IDcorrespondant);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			       affichage_valeur.setText("Valeur de l'action de "+entreprise+ " : "+valeur_action+" euros");
							
				}		    
			});
		panelcombobox.add(jcb);
		panelcombobox.add(affichage_valeur);
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panelcombobox);
		JPanel contentbas= new JPanel();
		contentbas.setBackground(Color.white);
		contentbas.add(paneltextfieldnombreaction);

		JPanel control = new JPanel();
	
		control.add(okBouton);
		control.add(cancelBouton);
		 
		for(int i=0;i<listeentreprise_copie.size();i++){
			if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(listeentreprise_copie.get(i))==true){
			}
		}
		
		String IDcorrespondant = null;
		for( int i=0;i<listeIDcorrespondant.size();i++){
			if(i==listeentreprise_copie.indexOf(jcb.getSelectedItem())){
				IDcorrespondant = listeIDcorrespondant.get(i);
			}
		}
		try {
			valeur_action = API_YahooFinance.valeuraction(IDcorrespondant);
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		affichage_valeur.setText("Valeur de l'action de "+jcb.getSelectedItem()+ " : "+valeur_action+" euros");
			
		champ_nombreaction.addKeyListener(new KeyListener() { 

			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER) {
				
					okBouton.doClick();
				}			
			}
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER) {
					okBouton.doClick();
				}	
			}
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER) {	
					okBouton.doClick();
				}
			}		
			});
		okBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) { 
				
				double Montantajout = valeur_action*Double.parseDouble(champ_nombreaction.getText());
				if(Montantajout < bouton_limite_investissement.chiffre_limite_investissement){
				String IDcorrespondant=null;
				Object entreprise_a_ajouter = jcb.getSelectedItem();
				String entreprise_a_ajouter_string = entreprise_a_ajouter.toString();
				for( int i=0;i<listeIDcorrespondant.size();i++){
					if(i==listeentreprise_copie.indexOf(entreprise_a_ajouter)){
						IDcorrespondant = listeIDcorrespondant.get(i);
					}
				}
				try{
					nombre_actions_entreprise_a_ajouter=champ_nombreaction.getText();
					Panel_interface.nb_actions= Integer.parseInt(nombre_actions_entreprise_a_ajouter);
				
				}catch(NumberFormatException ex){
				
					  JOptionPane.showMessageDialog(null, "Veuillez entrer une valeur dans le champ quantité");
					 return;
				}
				Double total1= null;
				try {
					String user = bouton_connexion.utilisateurconnecte;
					total1 =ModeleDynamiqueObjet.floor(Panel_interface.nb_actions*(API_YahooFinance.valeuraction(IDcorrespondant)),3);
					Panel_interface.modele.addLigne(new Portefeuille(entreprise_a_ajouter_string, IDcorrespondant ,Panel_interface.nb_actions  ,API_YahooFinance.valeuraction(IDcorrespondant)+" "+ "euros".toString(),total1.toString()+" "+"euros","",""));
					Gestion_base_de_donnee.sauverlignedansBase(entreprise_a_ajouter_string,IDcorrespondant,Panel_interface.nb_actions,API_YahooFinance.valeuraction(IDcorrespondant),total1,user);
					Date date = new Date();
					DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
							DateFormat.SHORT,
							DateFormat.MEDIUM);
					jcomboboxachatvente.remplirtableauachatvente("Ajout", entreprise_a_ajouter_string, IDcorrespondant, Panel_interface.nb_actions, user, shortDateFormat.format(date));
					
					
				} catch (IOException e2) {

					e2.printStackTrace();
				}	

				//Gestion de la JComboxBox achat_vente
				Panel_interface.combo_box_achat_vente.addItem(entreprise_a_ajouter_string);
				Panel_interface.Liste_choix_ID_achat_vente.add(IDcorrespondant);
				for( int i=0;i<listeIDcorrespondant.size();i++){
					if(i==listeentreprise_copie.indexOf(entreprise_a_ajouter)){
						listeIDcorrespondant.remove(i);
					}
				} for( int i=0;i<listeentreprise_copie.size();i++){
					if(i==listeentreprise_copie.indexOf(entreprise_a_ajouter)){
						listeentreprise_copie.remove(i);
					}
				}
				ModeleDynamiqueObjet.rafraichirtotalportefeuille();
				setVisible(false);
				
			}else
			{
				JOptionPane.showMessageDialog(null, "Vous depassez la limite d'investissement autorisee");
			}
			}
			
		});
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});
		this.getContentPane().add(content, BorderLayout.NORTH);
		this.getContentPane().add(contentbas, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);	
		this.setVisible(true); 
	} 
}