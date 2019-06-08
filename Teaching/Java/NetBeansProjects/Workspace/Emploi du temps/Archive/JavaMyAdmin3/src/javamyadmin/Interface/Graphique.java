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
import javamyadmin.Service.ServiceEmploi;

public class GraphiqueModule extends JFrame implements ActionListener {

		JTextField id_module;
		JComboBox id_prof;
		JTextField name_module;
		JTextField duree;

    JButton enregistrer;
    JButton annuler;
		ServiceEmploi service;

    public GraphiqueModule(ServiceEmploi service){
        
				this.service=service;
				setTitle("Nouveau Enseignant");
				setBounds(200, 200,270, 290);
				setVisible(true);

        JLabel module = new JLabel("Module");
        id_module = new JTextField(10);
        
        JLabel nom = new JLabel("Nom");  
        name_module = new JTextField(10);

        JLabel dure = new JLabel("Duree");  
        duree = new JTextField(10);

        JLabel prof = new JLabel("Enseignant");
				String vmodule[] = {"module1","module2"};
        id_prof = new JComboBox(vmodule); 
 
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

        add(id_module,gbc,jp,2,0,1,1);
        add(id_prof,gbc,jp,2,1,1,1);
        add(name_module,gbc,jp,2,2,1,1);
        add(duree,gbc,jp,2,3,1,1);

        add(module,gbc,jp,0,0,1,1);
        add(prof,gbc,jp,0,1,2,1);
        add(nom,gbc,jp,0,2,1,1);
        add(dure,gbc,jp,0,3,1,1);

				JPanel jp2 = new JPanel();
				jp2.add (enregistrer);
				jp2.add (annuler);

				getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
/*    		SimpleDateFormat formatterDate = new SimpleDateFormat("yy/MM/dd");
				SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
				Module module = new Module();
				module.setName((String)id_module.getSelectedItem());
				module.setId((String)id_module.getSelectedItem());
				Sceance sceance = new Sceance();
				sceance.setId(id_sceance.getText().trim());
				sceance.setIdEmploi((String)id_emploi.getSelectedItem());
				sceance.setModule(module);
				try{
				sceance.setDate(formatterDate.parse(date_sceance.getText().trim()));
				sceance.setTime(formatterTime.parse(time_sceance.getText().trim()));
				}catch(Exception exp){}
				
				service.addSceance(sceance);*/
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
