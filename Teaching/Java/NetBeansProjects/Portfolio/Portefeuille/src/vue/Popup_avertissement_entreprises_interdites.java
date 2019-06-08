package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modele.Gestion_Entreprises_Interdites_achat;

public class Popup_avertissement_entreprises_interdites extends JDialog {

	private static final long serialVersionUID = 1L;

	private static DefaultListModel<String> model = new DefaultListModel<String>();
	private static JList<String> liste1 = new JList<String>(model);
	private static ArrayList<String> liste_entreprises= new ArrayList<String>();
	public Popup_avertissement_entreprises_interdites(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(400, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
	}


	private void initComponent(){



		generer_liste();
		JScrollPane liste = new JScrollPane();
		liste.setPreferredSize(new Dimension(400,250));
		liste.setBorder(BorderFactory.createTitledBorder("<html><body><span style='color:red;'>Les entreprises suivante ont été signalé comme à risque : </span></body></html>"));
		liste.setViewportView(liste1);

		JPanel milieu = new JPanel();	
		milieu.setPreferredSize(new Dimension(400,260));
		milieu.add(liste);



		JPanel control = new JPanel();
		control.setPreferredSize(new Dimension(400,50));
		JButton okBouton = new JButton("Interdire achat");
		JButton cancelBouton = new JButton("Annuler");
		control.add(okBouton);
		control.add(cancelBouton);

		okBouton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) { 

				for(int i=0;i<liste_entreprises.size();i++){
					Gestion_Entreprises_Interdites_achat.stockerentreprise(liste_entreprises.get(i));
				}
				setVisible(false);
			}
		});
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});

		this.getContentPane().add(milieu, BorderLayout.NORTH);
		this.getContentPane().add(control, BorderLayout.SOUTH);
		//S'affiche seulemet si on a des entreprises a risque non interdites à l'achat
		if(liste_entreprises.size()>0){
			this.setVisible(true);
			
			
		}
	} 

	private void generer_liste(){
		liste_entreprises =Gestion_Entreprises_Interdites_achat.prevenir_bob_des_entreprises_a_risque();
		for(int i=0;i<liste_entreprises.size();i++){
			model.addElement(liste_entreprises.get(i).toString());
		}	
	}
}	