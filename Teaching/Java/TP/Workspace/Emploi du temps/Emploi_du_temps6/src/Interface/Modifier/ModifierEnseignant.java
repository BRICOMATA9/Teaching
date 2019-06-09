package Interface.Modifier;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BDD.Enseignant;
import DAO.EnseignantDAO;

@SuppressWarnings("serial")
public class ModifierEnseignant extends JFrame implements ActionListener {

	JComboBox<Object> idPersonne;
	JTextField nom;
	JTextField prenom;
	JTextField login;
	JTextField mdp;
	JTextField grade;

    JButton enregistrer;
    JButton annuler;

    public ModifierEnseignant(){

		setTitle("Modifier un Enseignant");
		setBounds(200, 200,270, 290);
		setVisible(true);

        JLabel personne = new JLabel("Enseignant");
        idPersonne = new JComboBox<Object>((Object[])EnseignantDAO.getInstance().getId().toArray());
        idPersonne.addActionListener(this);

        JLabel nom_ = new JLabel("Nom");
        nom = new JTextField(10);
        
        JLabel prenom_ = new JLabel("Prenom");
        prenom = new JTextField(10);
        
        JLabel login_ = new JLabel("Login");
        login = new JTextField(10);
        
        JLabel mdp_ = new JLabel("Mot de Passe");
        mdp = new JTextField(10);
        
        JLabel grade_ = new JLabel("Grade");
        grade = new JTextField(10);
 
        enregistrer = new JButton("Enregistrer");
        enregistrer.addActionListener(this);
        
        annuler = new JButton("Annuler");
        annuler.addActionListener(this);
                
        Container contentPane = getContentPane();
        GridBagLayout gbl = new GridBagLayout();

        JPanel jp = new JPanel();
        jp.setLayout(gbl);
        contentPane.add(jp);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        
       	Insets inset = new Insets(10,10,5,5); 
        gbc.insets = inset;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
        add(idPersonne,gbc,jp,1,1,1,1);
        add(nom,gbc,jp,1,2,1,1);
        add(prenom,gbc,jp,1,3,1,1);
        add(login,gbc,jp,1,4,1,1);
        add(mdp,gbc,jp,1,5,1,1);
        add(grade,gbc,jp,1,6,1,1);

        add(personne,gbc,jp,0,1,1,1);
        add(nom_,gbc,jp,0,2,1,1);
        add(prenom_,gbc,jp,0,3,1,1);
        add(login_,gbc,jp,0,4,1,1);
        add(mdp_,gbc,jp,0,5,1,1);
        add(grade_,gbc,jp,0,6,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	try{
    	if (source==idPersonne){
    		Enseignant enseignant = EnseignantDAO.getInstance().getById(Integer.parseInt (idPersonne.getSelectedItem().toString()));
    		nom.setText(enseignant.getNom());
    		prenom.setText(enseignant.getPrenom());
    		login.setText(enseignant.getLogin());
    		mdp.setText(enseignant.getMdp());
    		grade.setText(enseignant.getGrade());
    	}
    	else if (source==enregistrer){
			try{
				Enseignant prof = new Enseignant();
				prof.setIdPersonne(Integer.parseInt (idPersonne.getSelectedItem().toString()));
				prof.setNom(nom.getText().trim());
				prof.setPrenom(prenom.getText().trim());
				prof.setLogin(login.getText().trim());
				prof.setMdp(mdp.getText().trim());
				prof.setGrade(grade.getText().trim());
				EnseignantDAO.getInstance().modifier(prof);
				setVisible(false);
			}catch(Exception eh){
					JOptionPane.showMessageDialog(this,eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
			}
    	}else if (source==annuler)
				setVisible(false);
    	}catch(Exception en){}
    }
    
	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}
