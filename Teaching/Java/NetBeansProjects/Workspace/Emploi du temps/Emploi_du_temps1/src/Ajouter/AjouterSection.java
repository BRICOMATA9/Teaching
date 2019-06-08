package Ajouter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bdd.Section;
import sql.Recherche;

@SuppressWarnings("serial")
public class AjouterSection extends JFrame implements ActionListener {

	JTextField idSection;
	JTextField annee;

    JButton enregistrer;
    JButton annuler;
	Recherche service;
	private SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	
    public AjouterSection(Recherche service){
        
		this.service=service;
		setTitle("Ajouter un Groupe");
		setBounds(200, 200,270, 320);
		setVisible(true);

        JLabel section = new JLabel("Promotion");
        idSection = new JTextField(10);
        
        JLabel annee_ = new JLabel("Annee");
        annee = new JTextField(10);
 
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

        add(idSection,gbc,jp,1,0,1,1);
        add(annee,gbc,jp,1,1,1,1);

        add(section,gbc,jp,0,0,1,1);
        add(annee_,gbc,jp,0,1,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
			try{
				Section promo = new Section();
				promo.setIdSection(Integer.parseInt(idSection.getText()));
				promo.setAnnee((Date) formatterDate.parse(annee.getText()));
					service.ajouterSection(promo);
			}catch(Exception eh){}
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
