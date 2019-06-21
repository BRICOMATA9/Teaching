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
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.List;

public class Supprimer <T> extends JFrame implements ActionListener {

		JComboBox supprimer;

    JButton enregistrer;
    JButton annuler;
		ServiceEmploi service;

    public Supprimer(ServiceEmploi service, Supplier<List<T>> f) throws Exception{
        
				this.service=service;
				setTitle("Nouvelle promotion");
				setBounds(200, 200,270, 290);
				setVisible(true);

        JLabel label = new JLabel("Supprimer un entité");
				String vpromo[] = {"module1","module2"};
        supprimer = new JComboBox(f.get().toArray()); 
 
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
        
        add(supprimer,gbc,jp,2,0,1,1);

        add(label,gbc,jp,0,0,1,1);

				JPanel jp2 = new JPanel();
				jp2.add (enregistrer);
				jp2.add (annuler);

				getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
				try{
					if(supprimer.getSelectedItem() instanceof Professor)
						service.deleteProfessor((Professor)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof EmploiDuTemps)
						service.deleteEmploi((EmploiDuTemps)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Classe)
						service.deleteClasse((Classe)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Module)
						service.deleteModule((Module)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Promotion)
						service.deletePromotion((Promotion)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Sceance)
						service.deleteSceance((Sceance)supprimer.getSelectedItem());
/*					else if(supprimer.getSelectedItem() instanceof Professor)
						service.deleteProfessor((Professor)supprimer.getSelectedItem());*/
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

/*	private void supprimer(T elm){
		Object o=JOptionPane.showInputDialog(this, "Choisissez la base que vous voulez supprimer",
			"Boite d'options",JOptionPane.QUESTION_MESSAGE,null, elm.toArray(), null);
		//Mysql.executer("use "+(String)o);
		Mysql.supprimer("Drop database "+(String)o+";");
	}*/
}
