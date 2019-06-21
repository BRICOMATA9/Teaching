package Ajouter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.*;
import sql.Recherche;

@SuppressWarnings("serial")
public class AjouterSceance extends JFrame implements ActionListener {

	JComboBox type;
	JComboBox idModule;
	JComboBox idSalle;
	JComboBox idEnseignant;
	JComboBox idSection;
	JComboBox idGroupe;
	JDateChooser dateDebut;
	JComboBox durree;
	
	//private final SimpleDateFormat formatjour =  new SimpleDateFormat("dd/MM/yyyy",new Locale("fr","FR"));
	private String[] duree = {"00:30","00:45","01:00","01:15","01:30","01:45","02:00","02:15"
							,"02:30","02:45","03:00","03:30","04:00","05:00","06:00"};
	
    JButton enregistrer;
    JButton annuler;
		Recherche service;

    public AjouterSceance(Recherche service){
        
				this.service=service;
				setTitle("Reservation");
				setBounds(200, 200,270, 320);
				setVisible(true);

				JLabel module = new JLabel("Module");
				idModule = new JComboBox(service.getAllModule().toArray());
				 
				JLabel enseignant = new JLabel("Enseignant");
				idEnseignant = new JComboBox(service.getAllEnseignant().toArray());

				JLabel salle = new JLabel("Salle");
				idSalle = new JComboBox(service.getAllSalle().toArray());

				JLabel groupe = new JLabel("Groupe");
				idGroupe = new JComboBox(service.getAllGroupe().toArray());
				    
				JLabel date = new JLabel("Date :");
				dateDebut = new JDateChooser();
				dateDebut.setLocale(new Locale("fr","FR"));
				dateDebut.setDate(GregorianCalendar.getInstance().getTime());
        
        JLabel section = new JLabel("Section");
        idSection = new JComboBox(service.getAllSection().toArray());
        
				JLabel durree_ = new JLabel("Duree :");
				durree = new JComboBox(duree)
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
        gbc.weightx = 0;
        gbc.weighty = 0;

       	Insets inset = new Insets(10,10,5,5); 
        gbc.insets = inset;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        add(idModule,gbc,jp,1,0,1,1);
        add(idSalle,gbc,jp,1,1,1,1);
        add(idEnseignant,gbc,jp,1,2,1,1);
        add(idSection,gbc,jp,1,3,1,1);
        add(idGroupe,gbc,jp,1,4,1,1);
        add(dateDebut,gbc,jp,1,5,1,1);
        add(durree,gbc,jp,1,6,1,1);

        add(module,gbc,jp,0,0,1,1);
        add(salle,gbc,jp,0,1,1,1);
        add(enseignant,gbc,jp,0,2,1,1);
        add(section,gbc,jp,0,3,1,1);
        add(groupe,gbc,jp,0,4,1,1);
        add(date,gbc,jp,0,5,1,1);
        add(durree_,gbc,jp,0,6,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	/*Object source = e.getSource();
    	if (source==enregistrer){
			try{
	    		if(type.getSelectedItem().toString().equals("Cours")){
	    			Cours cours = new Cours();
					//cours.setIdSceance();
					cours.setIdModule(((Module)idModule.getSelectedItem()).getIdModule());
					cours.setIdSalle(((Salle)idSalle.getSelectedItem()).getIdSalle());
					cours.setIdEnseignant(((Enseignant)idEnseignant.getSelectedItem()).getIdPersonne());
					cours.setIdSection(((Section)idSection.getSelectedItem()).getIdSection());
					cours.setDateDebut((Date) formatjour.parse((String)durree.getSelectedItem()));
					//cours.setDuree((Integer)durree.getSelectedItem());
					service.ajouterCours(cours);
	    		}else if(type.getSelectedItem().toString().equals("TP")){
	    			TP tp = new TP();
	    			//tp.setIdSceance();
	    			tp.setIdModule(((Module)idModule.getSelectedItem()).getIdModule());
	    			tp.setIdSalle(((Salle)idSalle.getSelectedItem()).getIdSalle());
	    			tp.setIdEnseignant(((Enseignant)idEnseignant.getSelectedItem()).getIdPersonne());
	    			tp.setIdGroupe(((Groupe)idGroupe.getSelectedItem()).getIdGroupe());
	    			tp.setDateDebut((Date) formatjour.parse((String)durree.getSelectedItem()));
					//cours.setDuree((Integer)durree.getSelectedItem());
					service.ajouterTP(tp);
	    		}
			}catch(Exception eh){}
    	}else if (source==annuler)
			setVisible(false);*/
    }
    
	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}
