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

import BDD.Salle;
import DAO.BatimentDAO;
import DAO.SalleDAO;

@SuppressWarnings("serial")
public class ModifierSalle extends JFrame implements ActionListener {

	JComboBox<Object> idSalle;
	JComboBox<Object> type;
	JComboBox<Object> idBatiment;
	JComboBox<Object> successeur;
	JComboBox<Object> predecesseur;
	JTextField capacite;

    JButton enregistrer;
    JButton annuler;

	private String[] typ = {"Cours","Machine","Chimie"};
	
    public ModifierSalle() throws Exception{

		setTitle("Modifier une Salle");
		setBounds(200, 200,270, 320);
		setVisible(true);

        JLabel salle = new JLabel("Salle");
        idSalle = new JComboBox<Object>((Object[])SalleDAO.getInstance().getId().toArray());
        idSalle.addActionListener(this);

        JLabel type_ = new JLabel("Type");
        type = new JComboBox<Object>(typ);
        
        JLabel batiment = new JLabel("Batiment");
        idBatiment = new JComboBox<Object>((Object[])BatimentDAO.getInstance().getId().toArray());
        
        JLabel successeur_ = new JLabel("Successeur");
        successeur = new JComboBox<Object>((Object[])SalleDAO.getInstance().getId().toArray());
        successeur.insertItemAt(null, 0);
        
        JLabel predecesseur_ = new JLabel("Predecesseur");
        predecesseur = new JComboBox<Object>((Object[])SalleDAO.getInstance().getId().toArray());
        predecesseur.insertItemAt(null, 0);
        
        JLabel capacite_ = new JLabel("Capacite");
        capacite = new JTextField(10);
 
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

        add(idSalle,gbc,jp,1,0,1,1);
        add(type,gbc,jp,1,1,1,1);
        add(idBatiment,gbc,jp,1,2,1,1);
        add(capacite,gbc,jp,1,3,1,1);
        add(successeur,gbc,jp,1,4,1,1);
        add(predecesseur,gbc,jp,1,5,1,1);

        add(salle,gbc,jp,0,0,1,1);
        add(type_,gbc,jp,0,1,1,1);
        add(batiment,gbc,jp,0,2,1,1);
        add(capacite_,gbc,jp,0,3,1,1);
        add(successeur_,gbc,jp,0,4,1,1);
        add(predecesseur_,gbc,jp,0,5,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
		try{   	
	    	if(source==idSalle){
	    		Salle salle = SalleDAO.getInstance().getById((Integer)idSalle.getSelectedItem());
	    		type.setSelectedItem(salle.getType());
				capacite.setText(salle.getCapacite().toString());
				idBatiment.setSelectedItem(salle.getIdBatiment().getIdBatiment());
				successeur.setSelectedItem(salle.getSuccesseur().getIdSalle());
				predecesseur.setSelectedItem(salle.getPredecesseur().getIdSalle());
	    	}else if (source==enregistrer){
				Salle salle = new Salle();
				salle.setIdSalle(Integer.parseInt (idSalle.getSelectedItem().toString()));
				salle.setType(type.getSelectedItem().toString());
				salle.setCapacite(Integer.parseInt(capacite.getText()));
				salle.setIdBatiment(BatimentDAO.getInstance().getById(idBatiment.getSelectedItem()));
				salle.setSuccesseur(SalleDAO.getInstance().getById(successeur.getSelectedItem()));
				salle.setPredecesseur(SalleDAO.getInstance().getById(predecesseur.getSelectedItem()));
				if (SalleDAO.getInstance().modifier(salle)) setVisible(false);
	    	}else if (source==annuler)
				setVisible(false);
		}catch(Exception eh){
			JOptionPane.showMessageDialog(this,eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
    }
    
	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}
