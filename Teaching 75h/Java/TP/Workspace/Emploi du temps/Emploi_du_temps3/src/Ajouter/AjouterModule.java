package Ajouter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bdd.Module;
import sql.Recherche;

@SuppressWarnings("serial")
public class AjouterModule extends JFrame implements ActionListener {

	JTextField idModule;
	JTextField nom;
	JTextField coef;

    JButton enregistrer;
    JButton annuler;
	Recherche service;

    public AjouterModule(Recherche service){
        
		this.service=service;
		setTitle("Ajouter un Module");
		setBounds(200, 200,270, 290);
		setVisible(true);

        JLabel module = new JLabel("Module");
        idModule = new JTextField(10);  

        JLabel nom_ = new JLabel("Libelle");
        nom = new JTextField(10); 
        
        JLabel coef_ = new JLabel("Coefficient");
        coef = new JTextField(10); 
 
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
        
        add(idModule,gbc,jp,1,0,1,1);
        add(nom,gbc,jp,1,1,1,1);
        add(coef,gbc,jp,1,2,1,1);

        add(module,gbc,jp,0,0,1,1);
        add(nom_,gbc,jp,0,1,1,1);
        add(coef_,gbc,jp,0,2,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
			try{
				Module module = new Module();
				module.setIdModule(idModule.getText().trim());
				module.setNom(nom.getText().trim());
				module.setCoefficient(Integer.parseInt(coef.getText()));
				service.ajouterModule(module);
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