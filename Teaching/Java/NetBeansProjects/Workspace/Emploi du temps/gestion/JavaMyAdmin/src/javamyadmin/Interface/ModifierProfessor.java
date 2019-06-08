package javamyadmin.Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javamyadmin.Model.*;
import javamyadmin.Data.ServiceEmploi;

public class ModifierProfessor extends JFrame implements ActionListener {

		JTextField id_prof;
		JTextField first_name;
		JTextField last_name;
		JTextField email;

    JButton enregistrer;
    JButton annuler;
		ServiceEmploi service;

    public ModifierProfessor(ServiceEmploi service){
        
				this.service=service;
				setTitle("Nouveau Enseignant");
				setBounds(200, 200,270, 290);
				setVisible(true);

        JLabel prof = new JLabel("Classe");
        id_prof = new JTextField(10);
        
        JLabel prenom = new JLabel("Prenom");  
        first_name = new JTextField(10);

        JLabel nom = new JLabel("Nom");  
        last_name = new JTextField(10);

        JLabel mail = new JLabel("email");  
        email = new JTextField(10);
 
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
        
        add(id_prof,gbc,jp,2,0,1,1);
        add(first_name,gbc,jp,2,1,1,1);
        add(last_name,gbc,jp,2,2,1,1);
        add(email,gbc,jp,2,3,1,1);

        add(prof,gbc,jp,0,0,1,1);
        add(nom,gbc,jp,0,1,2,1);
        add(prenom,gbc,jp,0,2,1,1);
        add(mail,gbc,jp,0,3,1,1);

				JPanel jp2 = new JPanel();
				jp2.add (enregistrer);
				jp2.add (annuler);

				getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
				try{
				Professor professor = new Professor();
				professor.setId(id_prof.getText().trim());
				professor.setFirstName(first_name.getText().trim());
				professor.setLastName(last_name.getText().trim());
				professor.setEmail(email.getText().trim());
				
				service.addProfessor(professor);
				}catch(Exception r){}
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
