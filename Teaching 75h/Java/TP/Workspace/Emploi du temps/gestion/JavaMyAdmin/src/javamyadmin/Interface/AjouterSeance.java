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
import com.toedter.calendar.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AjouterSeance extends JFrame implements ActionListener {
		String[] duree = {"00:30","00:45","01:00","01:15","01:30","01:45","02:00","02:15",
															"02:30","02:45","03:00","03:30","04:00","05:00","06:00"};
		JDateChooser ChoixDate = new JDateChooser();
		JTextField id_sceance;
		JComboBox id_module;
		JComboBox id_emploi;
		JTextField date_sceance;
		JComboBox time_sceance;
		ServiceEmploi service;

    JButton enregistrer;
    JButton annuler;

    public AjouterSeance(ServiceEmploi service){
        
				this.service=service;

        JLabel seance = new JLabel("seance");
        id_sceance = new JTextField(10);
        
        JLabel module = new JLabel("module");
				String vmodule[] = {"module1","module2"};
        id_module = new JComboBox(vmodule);   

        JLabel emploi = new JLabel("emploi");
				String vemploi[] = {"emploi1","emploi2"};
        id_emploi = new JComboBox(vemploi);    

        JLabel dsceance = new JLabel("date");
				ChoixDate.setLocale(new Locale("fr","FR"));
				ChoixDate.setDate(GregorianCalendar.getInstance().getTime());

        JLabel hsceance = new JLabel("duree");
        time_sceance = new JComboBox(duree);
 
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
        
        add(id_sceance,gbc,jp,2,0,1,1);
        add(id_module,gbc,jp,2,1,2,1);
        add(id_emploi,gbc,jp,2,2,2,1);
        add(ChoixDate,gbc,jp,2,3,1,1);
        add(time_sceance,gbc,jp,2,4,1,1);

        add(seance,gbc,jp,0,0,1,1);
        add(module,gbc,jp,0,1,2,1);
        add(emploi,gbc,jp,0,2,2,1);
        add(dsceance,gbc,jp,0,3,1,1);
        add(hsceance,gbc,jp,0,4,1,1);

				JPanel jp2 = new JPanel();
				jp2.add (enregistrer);
				jp2.add (annuler);

				contentPane.add (jp2, BorderLayout.SOUTH);
				setTitle("Nouvelle seance");
				setBounds(200, 200,270, 290);
				setVisible(true);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer)
				try{
					SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
					Module module = new Module();
					module.setName((String)id_module.getSelectedItem());
					module.setId((String)id_module.getSelectedItem());
					Sceance sceance = new Sceance();
					sceance.setId(id_sceance.getText().trim());
					sceance.setIdEmploi((String)id_emploi.getSelectedItem());
					sceance.setModule(module);
					sceance.setDate(ChoixDate.getDate());
					sceance.setTime(formatterTime.parse((String)time_sceance.getSelectedItem()));
					service.addSceance(sceance);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(this,ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);	
				}	
    	else if (source==annuler)
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
