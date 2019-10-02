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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import bdd.Cours;
import bdd.Enseignant;
import bdd.Groupe;
import bdd.Module;
import bdd.Salle;
import bdd.Section;
import bdd.TP;
import sql.Recherche;

@SuppressWarnings("serial")
public class AjouterCours extends JFrame implements ActionListener {

	JComboBox idModule;
	JComboBox idSalle;
	JComboBox idEnseignant;
	JComboBox idSection;
	JDateChooser dateDebut;
	JComboBox heureDebut;
	JComboBox durree;
	int i = 16;

	private final SimpleDateFormat formatjour =  new SimpleDateFormat("dd-MM-yy",new Locale("fr","FR"));
	private final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	private String[] duree = {"00:30","00:45","01:00","01:15","01:30","01:45","02:00","02:15"
							,"02:30","02:45","03:00","03:30","04:00","05:00","06:00"};
	
	private String[] heure_ = {"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30",
			"13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30"};
	
    JButton enregistrer;
    JButton annuler;
	Recherche service;

    public AjouterCours(Recherche service){

		this.service=service;
		setTitle("Ajouter un Cours");
		setBounds(200, 200,360, 390);
		setVisible(true);
		
        JLabel module = new JLabel("Module");
        idModule = new JComboBox(service.getIdModule().toArray());
         
        JLabel enseignant = new JLabel("Enseignant");
        idEnseignant = new JComboBox(service.getIdEnseignant().toArray());
        
        JLabel salle = new JLabel("Salle");
        idSalle = new JComboBox(service.getIdSalle().toArray());
        
		JLabel date = new JLabel("Date :");
		dateDebut = new JDateChooser();
		dateDebut.setLocale(new Locale("fr","FR"));
		dateDebut.setDate(GregorianCalendar.getInstance().getTime());
		
        JLabel heure = new JLabel("Heure");
        heureDebut = new JComboBox(heure_);
        
        JLabel section = new JLabel("Section");
        idSection = new JComboBox(service.getIdSection().toArray());
        
		JLabel durree_ = new JLabel("Duree :");
		durree = new JComboBox(duree);
		durree.setSelectedItem("01:15");
 
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
        gbc.weightx = 1;
        gbc.weighty = 1;

       	Insets inset = new Insets(10,10,5,5); 
        gbc.insets = inset;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        add(idModule,gbc,jp,1,0,1,1);
        add(idSalle,gbc,jp,1,1,1,1);
        add(idEnseignant,gbc,jp,1,2,1,1);
        add(idSection,gbc,jp,1,3,1,1);
        add(dateDebut,gbc,jp,1,4,1,1);
        add(heureDebut,gbc,jp,1,5,1,1);
        add(durree,gbc,jp,1,6,1,1);

        add(module,gbc,jp,0,0,1,1);
        add(salle,gbc,jp,0,1,1,1);
        add(enseignant,gbc,jp,0,2,1,1);
        add(section,gbc,jp,0,3,1,1);
        add(date,gbc,jp,0,4,1,1);
        add(heure,gbc,jp,0,5,1,1);
        add(durree_,gbc,jp,0,6,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
			try{
				Cours cours = new Cours();
				cours.setIdModule(idModule.getSelectedItem().toString());
				cours.setIdSalle(Integer.parseInt (idSalle.getSelectedItem().toString()));
				cours.setIdEnseignant(Integer.parseInt (idEnseignant.getSelectedItem().toString()));
				cours.setIdSection(Integer.parseInt (idSection.getSelectedItem().toString()));
				cours.setDateDebut(dateDebut.getDate());
				cours.setHeureDebut((Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"));
				cours.setDuree((Date) formatTime.parse((String)durree.getSelectedItem()+":00"));
				service.ajouterCours(cours);
	    		setVisible(false);
			}catch(Exception eh){
				JOptionPane.showMessageDialog(this,"fdfdd"+eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
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
