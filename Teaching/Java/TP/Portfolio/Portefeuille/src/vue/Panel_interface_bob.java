/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import modele.Combobox_listeentreprises;
import modele.Gestion_TableauEmployesBob;
import modele.Gestion_Tableau_Activite_Entreprises;
import modele.ModeleTableauEmployesBob;
import modele.Modele_Tableau_Activite_Entreprises;
import modele.TableauEmployesBob;
import controleur.bouton_interdire_achat;


public class Panel_interface_bob extends javax.swing.JPanel {


	private static final long serialVersionUID = 1L;
	
	public static List<TableauEmployesBob> listEmployees=Gestion_TableauEmployesBob.remplir_JTable_Bob();
	public static TableModel modele_tableau_employes_bob = new ModeleTableauEmployesBob(listEmployees);
	public static Modele_Tableau_Activite_Entreprises modele_tableau_activite_entreprise = new Modele_Tableau_Activite_Entreprises();


	public Panel_interface_bob() {
		initComponents();
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })                      
	private void initComponents() {

		panel_haut = new javax.swing.JPanel();
		bouton_deconnexion = new javax.swing.JButton();
		combobox_entreprises = new javax.swing.JComboBox(Combobox_listeentreprises.remplir_combobox().toArray());
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		bouton_interdire_achat = new javax.swing.JButton(new bouton_interdire_achat());
		bouton_rapportPDF = new javax.swing.JButton();
		Panel_tableau_employes = new javax.swing.JPanel();
		scrollpane_tableau_employes = new javax.swing.JScrollPane();
		Tableau_Employes_Bob = new javax.swing.JTable(modele_tableau_employes_bob);
		Panel_tableau_activite_entreprise = new javax.swing.JPanel();
		scrollpane_tableau_activite_entreprise = new javax.swing.JScrollPane();
		Tableau_Activite_Entreprises = new javax.swing.JTable(modele_tableau_activite_entreprise);

		bouton_deconnexion.setText("Deconnexion");
		

		//Mise en place du tri dans le tableau
		ModeleTableauEmployesBob.MettreTriEnPlace(Tableau_Employes_Bob);


		//Mise en place du CellRenderer pour le tableau
		Tableau_Employes_Bob.getColumn("Classement").setCellRenderer(new TableRendererBob());
		Tableau_Employes_Bob.getColumn("Employes").setCellRenderer(new TableRendererBob());
		Tableau_Employes_Bob.getColumn("Gain").setCellRenderer(new TableRendererBob());
		Tableau_Employes_Bob.getColumn("Valeur du Portefeuille").setCellRenderer(new TableRendererBob());

		Tableau_Activite_Entreprises.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		Tableau_Activite_Entreprises.getColumnModel().getColumn(0).setPreferredWidth(320);
		Tableau_Activite_Entreprises.setRowHeight(25);
		
		Tableau_Activite_Entreprises.getColumn("Activites").setCellRenderer(new TableRenderer_activiteentreprises_bob());
		
		Tableau_Activite_Entreprises.getColumn("Bouton").setCellRenderer(new BoutonRenderer());
		Tableau_Activite_Entreprises.getColumn("Bouton").setCellEditor(new ButtonEditor(new JCheckBox()));
		

		combobox_entreprises.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				Gestion_Tableau_Activite_Entreprises.rafraichir_tableau();
				
			}

		});

		jLabel1.setText("Utilisateur : Bob");
		jLabel2.setText("Entreprise");
		bouton_interdire_achat.setText("Interdire achat");
		
		bouton_rapportPDF.setText("Rapport PDF");
		bouton_rapportPDF.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
					Popup_rapport_pdf pop = new Popup_rapport_pdf(new JFrame(), "Rapport PDF",false);
			}
		});


		scrollpane_tableau_employes.setViewportView(Tableau_Employes_Bob);

		javax.swing.GroupLayout Panel_tableau_employesLayout = new javax.swing.GroupLayout(Panel_tableau_employes);
		Panel_tableau_employes.setLayout(Panel_tableau_employesLayout);
		Panel_tableau_employesLayout.setHorizontalGroup(
				Panel_tableau_employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(Panel_tableau_employesLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollpane_tableau_employes, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addContainerGap())
				);
		Panel_tableau_employesLayout.setVerticalGroup(
				Panel_tableau_employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(Panel_tableau_employesLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollpane_tableau_employes, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addContainerGap())
				);

		scrollpane_tableau_activite_entreprise.setViewportView(Tableau_Activite_Entreprises);

		javax.swing.GroupLayout Panel_tableau_activite_entrepriseLayout = new javax.swing.GroupLayout(Panel_tableau_activite_entreprise);
		Panel_tableau_activite_entreprise.setLayout(Panel_tableau_activite_entrepriseLayout);
		Panel_tableau_activite_entrepriseLayout.setHorizontalGroup(
				Panel_tableau_activite_entrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(Panel_tableau_activite_entrepriseLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollpane_tableau_activite_entreprise, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addContainerGap())
				);
		Panel_tableau_activite_entrepriseLayout.setVerticalGroup(
				Panel_tableau_activite_entrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(Panel_tableau_activite_entrepriseLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollpane_tableau_activite_entreprise, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout panel_hautLayout = new javax.swing.GroupLayout(panel_haut);
		panel_haut.setLayout(panel_hautLayout);
		panel_hautLayout.setHorizontalGroup(
				panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel_hautLayout.createSequentialGroup()
						.addGap(619, 619, 619)
						.addComponent(bouton_interdire_achat)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bouton_rapportPDF)
						.addContainerGap())
				.addGroup(panel_hautLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(Panel_tableau_employes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panel_hautLayout.createSequentialGroup()
										.addGap(195, 195, 195)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
										.addComponent(bouton_deconnexion)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
								.addGroup(panel_hautLayout.createSequentialGroup()
										.addGap(188, 188, 188)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(combobox_entreprises, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(panel_hautLayout.createSequentialGroup()
										.addGap(52, 52, 52)
										.addComponent(Panel_tableau_activite_entreprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(8, Short.MAX_VALUE))
				);
		panel_hautLayout.setVerticalGroup(
				panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel_hautLayout.createSequentialGroup()
						.addGroup(panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(bouton_deconnexion)
								.addComponent(jLabel1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(combobox_entreprises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(Panel_tableau_activite_entreprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel_hautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(bouton_interdire_achat)
								.addComponent(bouton_rapportPDF))
						.addGap(43, 43, 43))
				.addGroup(panel_hautLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(Panel_tableau_employes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_haut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(0, 12, Short.MAX_VALUE)
						.addComponent(panel_haut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				);
	}                                             


	private javax.swing.JPanel Panel_tableau_activite_entreprise;
	private javax.swing.JPanel Panel_tableau_employes;
	public static javax.swing.JTable Tableau_Activite_Entreprises;
	static  javax.swing.JTable Tableau_Employes_Bob;
	static  javax.swing.JButton bouton_deconnexion;
	public static  javax.swing.JButton bouton_interdire_achat;
	static  javax.swing.JButton bouton_rapportPDF;
	@SuppressWarnings("rawtypes")
	public
	static  javax.swing.JComboBox combobox_entreprises;
	static  javax.swing.JLabel jLabel1;
	static  javax.swing.JLabel jLabel2;
	private javax.swing.JPanel panel_haut;
	private javax.swing.JScrollPane scrollpane_tableau_activite_entreprise;
	private javax.swing.JScrollPane scrollpane_tableau_employes;               
}