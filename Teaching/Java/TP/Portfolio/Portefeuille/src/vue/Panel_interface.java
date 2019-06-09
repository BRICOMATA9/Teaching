/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controleur.Graphique_journalier_totalportefeuille;
import controleur.Graphique_mensuel_totalportefeuille;
import controleur.bouton_achatvente_automatique;
import controleur.bouton_acheter;
import controleur.bouton_ajouter;
import controleur.bouton_connexion;
import controleur.bouton_limite_investissement;
import controleur.bouton_rafraichir;
import controleur.bouton_supprimer;
import controleur.bouton_vendre;
import modele.ModeleDynamiqueObjet;

public class Panel_interface extends JPanel{
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public static DefaultListModel modelelistehistorique=new DefaultListModel();

	public Panel_interface() {
		initComponents();
		
	}
	@SuppressWarnings({ "unchecked","rawtypes" })

	private void initComponents() {

		/*-----------Panel haut----------*/
		panel_haut = new JPanel();
		// Panel_Tableau 	  
		JPaneltableau = new javax.swing.JPanel();
		tableau = new javax.swing.JTable(modele);
		label_total_portefeuille = new javax.swing.JLabel();
		bouton_rafraichir = new javax.swing.JButton(new bouton_rafraichir());
		bouton_supprimer = new javax.swing.JButton(new bouton_supprimer());
		bouton_ajouter = new JButton();
		Label_user = new javax.swing.JLabel();
		JScrollPane ScrollPaneTableau = new JScrollPane();
		Label_totaldispopourinvestissement = new JLabel();
		/*Panel en haut � droite (JPanel1)*/
		JPanel jPanel1 = new JPanel();
		jLabel1= new JLabel();

		//jButton1=new JButton();
		//Panel-achatvente
		bouton_alerte_entreprise= new JButton();
		jPanelachatvente=new javax.swing.JPanel();		
		Titre_achatvente = new javax.swing.JLabel();
		label_entreprise_achatvente = new JLabel();
		label_quantite_achatvente = new JLabel();
		Champ_achat_vente = new javax.swing.JTextField();
		bouton_acheter = new javax.swing.JButton(new bouton_acheter());
		bouton_vendre = new javax.swing.JButton(new bouton_vendre());
		Liste_entreprise_combo_box_achat_vente=new ArrayList<String>();
		combo_box_achat_vente = new javax.swing.JComboBox(Liste_entreprise_combo_box_achat_vente.toArray());
		combo_box_achat_vente.setModel(new DefaultComboBoxModel());
		Liste_choix_ID_achat_vente=new ArrayList<String>();
		//Liste_choix_ID_achat_vente = Gestion_base_de_donnee.recupererIDpourcomboboxachatvente();
		//Historique
		ScrollPane_historique = new JScrollPane();
		liste_historique = new javax.swing.JList(modelelistehistorique);
		Panneau_Graphique_historique=new JTabbedPane();
		/*------------- Panelbas -------*/
		Panelbas= new JPanel();
		scrollpanebas = new JScrollPane();

	 textfield_limite_investissement = new JTextField();


		bouton_fixer_limite_investissement = new javax.swing.JButton(new bouton_limite_investissement());
		jLabel1 = new javax.swing.JLabel();
		Panel_connexion = new javax.swing.JPanel();
		bouton_inscription = new javax.swing.JButton();
		bouton_deconnexion = new javax.swing.JButton();
		textfield_motdepasse_connexion = new javax.swing.JTextField();
		textfield_utilisateur_connexion = new javax.swing.JTextField();
		label_utilisateur_connexion = new javax.swing.JLabel();
		label_motdepasse_connexion = new javax.swing.JLabel();
		GrandPanelbas = new JPanel();
		label_limite_investissement=new JLabel();
		bouton_achat_automatique = new JButton();

		ScrollPane_historique.setViewportView(liste_historique);
		ScrollPaneTableau.setViewportView(tableau);
		label_quantite_achatvente.setText("Quantite");
		label_entreprise_achatvente.setText("Entreprise");
		Titre_achatvente.setText("Achat/Vente d'actions");
		bouton_supprimer.setText("Supprimer la selection");
		bouton_acheter.setText("acheter");
		bouton_vendre.setText("vendre");
		//textfield_limite_investissement.setText("salut");
		bouton_rafraichir.setText("Rafraichir tableau");
		bouton_ajouter.setText("Ajouter une entreprise");
		bouton_fixer_limite_investissement.setText("Ok");
		jLabel1.setText("euros");
		bouton_inscription.setText("Inscription");
		bouton_deconnexion.setText("Deconnexion");
		label_utilisateur_connexion.setText("Username");
		label_motdepasse_connexion.setText("Password");
		jPanelachatvente.setBorder(new LineBorder(Color.BLACK));
		bouton_achat_automatique.setText("Achat/Vente auto");
		
		Panel_interface.label_limite_investissement.setText("Limite investissement : ");
		Panel_interface.totalportefeuille = ModeleDynamiqueObjet.floor(ModeleDynamiqueObjet.calcultotalportefeuille(),2);
		Panel_interface.label_total_portefeuille.setText("Total Portefeuille : "+ Panel_interface.totalportefeuille + " euros");
		Panel_interface.Label_user.setText("<html><body>Utilisateur :  <strong>"+bouton_connexion.utilisateurconnecte+"</strong></body></html>");
		
		//Met en place le CellRenderer
		tableau.getColumn("Entreprises").setCellRenderer(new TableRenderer());
		tableau.getColumn("ID YahooFinance").setCellRenderer(new TableRenderer());
		tableau.getColumn("valeur unitaire").setCellRenderer(new TableRenderer());
		tableau.getColumn("Quantite").setCellRenderer(new TableRenderer());
		tableau.getColumn("Total").setCellRenderer(new TableRenderer());
		tableau.getColumn("Alertes").setCellRenderer(new IconRenderer());
		tableau.getColumn("Risques").setCellRenderer(new IconRenderer());
		
		tableau.getColumnModel().getColumn(5).setPreferredWidth(20);
		tableau.getColumnModel().getColumn(6).setPreferredWidth(20);
		
		tableau.setComponentPopupMenu( new Jpopupmenu());		
		tableau.addMouseListener(new TableMouseListener(tableau));

		
		
		bouton_achat_automatique.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new bouton_achatvente_automatique(null,"Mettre en place Achat/Vente automatique",true);
			}
		});
		

		bouton_ajouter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new bouton_ajouter(null,"Ajouter une entreprise",true);
			}
		});

		Panneau_Graphique_historique.add("Historique Mensuel", Graphique_mensuel_totalportefeuille.createPanelgraph());
		Panneau_Graphique_historique.add("Historique journalier", Graphique_journalier_totalportefeuille.createPanelgraph());

		/*----------------------------------------- Placement des composants (Netbeans) ------------------------------------------*/		

		  javax.swing.GroupLayout JPaneltableauLayout = new javax.swing.GroupLayout(JPaneltableau);
	        JPaneltableau.setLayout(JPaneltableauLayout);
	        JPaneltableauLayout.setHorizontalGroup(
	            JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(JPaneltableauLayout.createSequentialGroup()
	                .addGroup(JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(ScrollPaneTableau)
	                    .addGroup(JPaneltableauLayout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPaneltableauLayout.createSequentialGroup()
	                                .addGap(0, 0, Short.MAX_VALUE)
	                                .addComponent(label_total_portefeuille, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(JPaneltableauLayout.createSequentialGroup()
	                                .addGroup(JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(JPaneltableauLayout.createSequentialGroup()
	                                        .addComponent(bouton_ajouter)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                        .addComponent(bouton_supprimer)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(bouton_rafraichir))
	                                    .addGroup(JPaneltableauLayout.createSequentialGroup()
	                                        .addComponent(label_limite_investissement, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(textfield_limite_investissement, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(jLabel1)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(bouton_fixer_limite_investissement, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGap(0, 6, Short.MAX_VALUE)))))
	                .addContainerGap())
	        );
	        JPaneltableauLayout.setVerticalGroup(
	            JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(JPaneltableauLayout.createSequentialGroup()
	                .addGap(2, 2, 2)
	                .addGroup(JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(label_limite_investissement, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(bouton_fixer_limite_investissement)
	                    .addComponent(textfield_limite_investissement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(ScrollPaneTableau, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(label_total_portefeuille, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(3, 3, 3)
	                .addGroup(JPaneltableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(bouton_ajouter)
	                    .addComponent(bouton_supprimer)
	                    .addComponent(bouton_rafraichir))
	                .addContainerGap(19, Short.MAX_VALUE))
	        );

      
        javax.swing.GroupLayout Panel_connexionLayout = new javax.swing.GroupLayout(Panel_connexion);
        Panel_connexion.setLayout(Panel_connexionLayout);
        Panel_connexionLayout.setHorizontalGroup(
            Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_connexionLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(Label_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bouton_deconnexion)
                .addContainerGap())
        );
        Panel_connexionLayout.setVerticalGroup(
            Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_connexionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bouton_deconnexion))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Panneau_Graphique_historique))
                    .addComponent(Panel_connexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Panel_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panneau_Graphique_historique, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        

        javax.swing.GroupLayout jPanelachatventeLayout = new javax.swing.GroupLayout(jPanelachatvente);
        jPanelachatvente.setLayout(jPanelachatventeLayout);
        jPanelachatventeLayout.setHorizontalGroup(
            jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelachatventeLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Titre_achatvente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelachatventeLayout.createSequentialGroup()
                .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelachatventeLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(bouton_acheter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bouton_vendre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanelachatventeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPane_historique)
                            .addGroup(jPanelachatventeLayout.createSequentialGroup()
                                .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label_entreprise_achatvente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_quantite_achatvente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelachatventeLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Champ_achat_vente, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelachatventeLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(combo_box_achat_vente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelachatventeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bouton_achat_automatique)
                .addGap(55, 55, 55))
        );
        jPanelachatventeLayout.setVerticalGroup(
            jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelachatventeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Titre_achatvente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_box_achat_vente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_entreprise_achatvente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Champ_achat_vente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_quantite_achatvente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanelachatventeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bouton_acheter)
                    .addComponent(bouton_vendre))
                .addGap(18, 18, 18)
                .addComponent(bouton_achat_automatique)
                .addGap(28, 28, 28)
                .addComponent(ScrollPane_historique, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_hautLayout = new javax.swing.GroupLayout(panel_haut);
        panel_haut.setLayout(panel_hautLayout);
        panel_hautLayout.setHorizontalGroup(
            panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_hautLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPaneltableau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelachatvente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_hautLayout.setVerticalGroup(
            panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_hautLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPaneltableau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_hautLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelachatvente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Panelbas.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout GrandPanelbasLayout = new javax.swing.GroupLayout(GrandPanelbas);
        GrandPanelbas.setLayout(GrandPanelbasLayout);
        GrandPanelbasLayout.setHorizontalGroup(
            GrandPanelbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrandPanelbasLayout.createSequentialGroup()
                .addComponent(Panelbas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        GrandPanelbasLayout.setVerticalGroup(
            GrandPanelbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelbas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_haut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrandPanelbas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_haut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrandPanelbas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}// </editor-fold>                        




	// Variables declaration - do not modify                     
	static javax.swing.JLabel Label_user;
	static JTabbedPane Panneau_Graphique_historique;
	private static JLabel Titre_achatvente;
	public  static  JButton bouton_acheter;
	private  static JButton bouton_ajouter;
	private  static JButton bouton_rafraichir;
	private static  JButton bouton_supprimer;
	static  JButton bouton_vendre;
	public static JLabel  label_quantite_achatvente;
	public static  JTextField Champ_achat_vente;
	@SuppressWarnings("rawtypes")
	public
	static  JComboBox combo_box_achat_vente;
	public static JLabel label_entreprise_achatvente;
	public static JLabel label_total_portefeuille;
	static public JScrollPane ScrollPane_historique;
	private static javax.swing.JPanel panel_haut;
	public static  JTable tableau;

	public static ModeleDynamiqueObjet modele = new ModeleDynamiqueObjet();

	/*---------------  Composant Partie Achat/Vente-----------*/          
	public static int nb_actions;
	public static ArrayList<String> Liste_entreprise_combo_box_achat_vente;
	public static ArrayList<String> Liste_choix_ID_achat_vente;
	static javax.swing.JPanel Panelbas;
	static javax.swing.JScrollPane Panelbasscroll;
	public static javax.swing.JLabel labeltotalachatvente;
	public static DefaultComboBoxModel<?> modelecombobox;
	private javax.swing.JPanel jPanelachatvente;
	private javax.swing.JPanel JPaneltableau;
	static JScrollPane scrollpanebas;
	static JButton bouton_alerte_entreprise;
	public static double totalportefeuille;
	public static double totalportefeuilleaffiche;
	@SuppressWarnings("rawtypes")
	static  javax.swing.JList liste_historique;
	//Listes pour l'ajout d'entreprises.
	// End of variables declaration  
	double totaldisponiblepourtransactions;
	static JLabel Label_totaldispopourinvestissement;
	static  JLabel jLabel1;
	static JButton bouton_fixer_limite_investissement;	
	public static JButton bouton_achat_automatique;
	private javax.swing.JPanel GrandPanelbas;	 
	private javax.swing.JPanel Panel_connexion;	   
	public static javax.swing.JButton bouton_deconnexion;
	private javax.swing.JButton bouton_inscription;
	private javax.swing.JLabel label_motdepasse_connexion;	
	private javax.swing.JLabel label_utilisateur_connexion;
	public static JLabel label_limite_investissement;
	public static JTextField textfield_limite_investissement;
	@SuppressWarnings("unused")
	private javax.swing.JTextField textfield_motdepasse_connexion;
	@SuppressWarnings("unused")
	private javax.swing.JTextField textfield_utilisateur_connexion;
}