package modifier;

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

import bdd.Groupe;
import sql.Recherche;

@SuppressWarnings("serial")
public class ModifierGroupe extends JFrame implements ActionListener {

	JComboBox<Object> idGroupe;
	JComboBox<Object> idSection;

    JButton enregistrer;
    JButton annuler;
	Recherche service;

    public ModifierGroupe(Recherche service){
        
		this.service=service;
		setTitle("Modifier un Groupe");
		setBounds(200, 200,270, 290);
		setVisible(true);

        JLabel groupe = new JLabel("Groupe");
        idGroupe = new JComboBox<Object>((Object[])service.getIdGroupe().toArray()); 

        JLabel section = new JLabel("Promotion");
        idSection = new JComboBox<Object>((Object[])service.getIdSection().toArray()); 
 
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
        
        add(idGroupe,gbc,jp,2,0,1,1);
        add(idSection,gbc,jp,2,1,2,1);

        add(groupe,gbc,jp,0,0,1,1);
        add(section,gbc,jp,0,1,2,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
			try{
				Groupe groupe = new Groupe();
				groupe.setIdGroupe(Integer.parseInt (idGroupe.getSelectedItem().toString()));
				groupe.setIdSection(Integer.parseInt (idSection.getSelectedItem().toString()));
				service.modifierGroupe(groupe);
				setVisible(false);
			}catch(Exception eh){
				JOptionPane.showMessageDialog(this,eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
			}
    	}else if (source==annuler)
				setVisible(false);
    }
    
	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}