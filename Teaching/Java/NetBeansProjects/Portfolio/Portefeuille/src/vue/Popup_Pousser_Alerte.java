package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import modele.Formatage_Date;
import modele.SQLiteJDBC;

public class Popup_Pousser_Alerte extends JDialog {

	private static final long serialVersionUID = 1L;
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;
	static DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
	 JCheckBoxList checkBoxList = new JCheckBoxList(model);

	public Popup_Pousser_Alerte(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(400, 220);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
	}


	private void initComponent(){

		JPanel panneaulabel = new JPanel();
		panneaulabel.setBackground(Color.white);
		panneaulabel.setPreferredSize(new Dimension (150,150));
		JLabel label1 = new JLabel();
		label1.setText("Pousser l'alerte sur ");
		panneaulabel.add(label1);

		JScrollPane panellistecheckbox = new JScrollPane();
		panellistecheckbox.setBackground(Color.white);
		panellistecheckbox.setPreferredSize(new Dimension(200, 150));
		generer_liste_combobox();

		panellistecheckbox.setViewportView(checkBoxList);
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panneaulabel);
		content.add(panellistecheckbox);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");
		JButton cancelBouton = new JButton("Annuler");
		control.add(okBouton);
		control.add(cancelBouton);

		okBouton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) { 
				ArrayList<String> liste_employes = new ArrayList<String>();

				liste_employes=recuperer_utilisateurs_cochees();
				for(int i=0;i<liste_employes.size();i++){
					pousser_alerte(liste_employes.get(i));
				}
				JOptionPane.showMessageDialog(null, "Alerte poussée à "+liste_employes.toString());
				Panel_interface_bob.modele_tableau_activite_entreprise.fireTableDataChanged();
				setVisible(false);
			}
		});
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});

		this.getContentPane().add(content, BorderLayout.NORTH);
		this.getContentPane().add(control, BorderLayout.SOUTH);
		this.setVisible(true); 
	} 


	private ArrayList<String> recuperer_utilisateurs_cochees(){
		ArrayList<String> liste_employes_pousser_alerte = new ArrayList<String>();
		//Si on sélectionne la combobox "Tous les utilisateurs"
		if(model.getElementAt(0).isSelected()==true){
			for(int i=1;i<model.size();i++){
				System.out.println("tous les utilisateurs selectionnes");
				model.getElementAt(i).setSelected(true);

			}

		}
		//Si on sélectionne les utilisateur un par un
		for(int i=1;i<model.size();i++){
			if(model.getElementAt(i).isSelected()==true){
				liste_employes_pousser_alerte.add(model.getElementAt(i).getText());
			}
		}
		return liste_employes_pousser_alerte;
	}

	private void generer_liste_combobox(){
		String sql="SELECT * FROM `Tableau_Utilisateurs`";
		String user;
		model.addElement(new JCheckBox("Tous les utilisateurs"));
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				user=rs.getString("Utilisateurs");
				model.addElement(new JCheckBox(""+user+""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String recuperer_utilisateur_bouton(String entreprise){
		String user = null;

		for(int i=0;i<recuperer_users_avec_alerte(entreprise).size();i++){
			if(ButtonEditor.texte_bouton.toString().contains(recuperer_users_avec_alerte(entreprise).get(i))){
				user=recuperer_users_avec_alerte(entreprise).get(i);
			}
		}
		return user;
	}

	private int recuperer_valeur_alerte(String entreprise){
		int valeur_alerte = 0;

		String sql="SELECT * FROM `tableau_alertes` WHERE `Utilisateur`='"+recuperer_utilisateur_bouton(entreprise)+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("Entreprise").equals(entreprise)){
					valeur_alerte=rs.getInt("valeur_alerte");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valeur_alerte;
	}

	private ArrayList<String> recuperer_users_avec_alerte(String entreprise){
		ArrayList<String> employes_avec_alerte = new ArrayList<String>();
		String sql="SELECT * FROM `tableau_alertes`";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("Entreprise").equals(entreprise)){
					employes_avec_alerte.add(rs.getString("Utilisateur"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employes_avec_alerte;
	}

	private void pousser_alerte(String employe) {
		Date date= new Date();
		String datef;
		datef =Formatage_Date.mettredateenformepourstockage(date);
		int valeur_alerte;
		String entreprise = Panel_interface_bob.combobox_entreprises.getSelectedItem().toString();
		ArrayList<String>liste=new ArrayList<String>();

		if(recuperer_users_avec_alerte(entreprise).contains(employe)==false){
			//System.out.println("Alerte poussée a"+employe);
			valeur_alerte=recuperer_valeur_alerte(entreprise);
			String sql = "INSERT INTO `tableau_alertes`(`Entreprise`,`valeur_alerte`,`Utilisateur`,`Date`)VALUES('"
					+entreprise+"','"
					+valeur_alerte+"','"
					+employe+"','"
					+datef+"')";
			liste.add(employe);
			try {
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
@SuppressWarnings("serial") 
final class JCheckBoxList extends JList<JCheckBox> {
	protected Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

	public JCheckBoxList() {
		setCellRenderer(new CellRenderer());
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = locationToIndex(e.getPoint());

				if (index != -1) {
					//Si la checkbox "Tous les utilisateurs est cochée"
					if( index==0){
						for(int i=1;i<Popup_Pousser_Alerte.model.size();i++){
							JCheckBox checkbox=(JCheckBox) getModel().getElementAt(i);
							checkbox.setSelected(!checkbox.isSelected());
							repaint();
						}
					}else{
						JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
						checkbox.setSelected(!checkbox.isSelected());
						repaint();
					}
				}
			}
		});
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public JCheckBoxList(ListModel<JCheckBox> model){
		this();
		setModel(model);
	}

	final class CellRenderer implements ListCellRenderer<JCheckBox> {
		public Component getListCellRendererComponent(
				JList<? extends JCheckBox> list, JCheckBox value, int index,
				boolean isSelected, boolean cellHasFocus) {
			JCheckBox checkbox = value;

			//Drawing checkbox, change the appearance here
			checkbox.setBackground(isSelected ? getSelectionBackground()
					: getBackground());
			checkbox.setForeground(isSelected ? getSelectionForeground()
					: getForeground());
			checkbox.setEnabled(isEnabled());
			checkbox.setFont(getFont());
			checkbox.setFocusPainted(false);
			checkbox.setBorderPainted(true);
			checkbox.setBorder(isSelected ? UIManager
					.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
			return checkbox;
		}
	}
}
	}
