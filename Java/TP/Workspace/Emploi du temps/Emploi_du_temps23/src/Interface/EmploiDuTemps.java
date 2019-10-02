package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import BDD.Batiment;
import BDD.Cours;
import BDD.Enseignant;
import BDD.Etudiant;
import BDD.Groupe;
import BDD.Module;
import BDD.Personne;
import BDD.Salle;
import BDD.Section;
import BDD.TP;
import DAO.BatimentDAO;
import DAO.CoursDAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.GroupeDAO;
import DAO.ModuleDAO;
import DAO.SalleDAO;
import DAO.SectionDAO;
import DAO.TPDAO;
import Interface.Afficher.Afficher;
import Interface.Ajouter.AjouterBatiment;
import Interface.Ajouter.AjouterCours;
import Interface.Ajouter.AjouterEnseignant;
import Interface.Ajouter.AjouterEtudiant;
import Interface.Ajouter.AjouterGroupe;
import Interface.Ajouter.AjouterModule;
import Interface.Ajouter.AjouterSalle;
import Interface.Ajouter.AjouterSection;
import Interface.Ajouter.AjouterTP;
import Interface.Modifier.ModifierEnseignant;
import Interface.Modifier.ModifierEtudiant;
import Interface.Modifier.ModifierGroupe;
import Interface.Modifier.ModifierModule;
import Interface.Modifier.ModifierSalle;
import Interface.Modifier.ModifierSection;
import Interface.Supprimer.Supprimer;
import Interface.Supprimer.SupprimerCours;
import Interface.Supprimer.SupprimerTP;
import SQL.DB;
import SQL.Recherche;

@SuppressWarnings("serial")
public class EmploiDuTemps extends JFrame implements ActionListener {

//	private Personne personne;
	private Recherche service;
	public JMenuBar menubar;
	public JMenuItem salle_groupe,salle_enseignant,type_salle;
	public JMenuItem enseignant0,etudiant0,groupe0,matiere0,promotion0,seance0,salle0,batiment0,tp0;
	public JMenuItem enseignant1,etudiant1,groupe1,matiere1,promotion1,seance1,salle1,batiment1,tp1;
	public JMenuItem enseignant2,etudiant2,groupe2,matiere2,promotion2,seance2,salle2,batiment2,tp2;
	public JMenuItem enseignant3,etudiant3,groupe3,matiere3,promotion3,salle3;
//	private ServiceEmploi service;
	private boolean etudiant;

	public EmploiDuTemps(Personne personne,DB db){
//		this.personne = personne;
		if(personne instanceof Etudiant)
			etudiant=true;
		else
			etudiant=false;
		
		this.service=new Recherche(db);
		centerFrame(this);
		
		JMenu recherche=new JMenu("recherche");
			salle_groupe=new JMenuItem("Salles utilisé par un groupe d'étudiant");
			salle_enseignant=new JMenuItem("Salles utilisé par un enseignant");
			type_salle=new JMenuItem("Type de salle");

		JMenu afficher=new JMenu("Afficher");
			enseignant0=new JMenuItem("Enseignant");
			etudiant0=new JMenuItem("Etudiant");
			groupe0=new JMenuItem("Groupe");
			matiere0=new JMenuItem("Module");
			promotion0=new JMenuItem("Promotion");
			seance0=new JMenuItem("Cours");
			tp0=new JMenuItem("TP");
			salle0=new JMenuItem("Salle");
			batiment0=new JMenuItem("Batiment");

		JMenu ajouter=new JMenu("Ajouter");
			enseignant1=new JMenuItem("Enseignant");
			etudiant1=new JMenuItem("Etudiant");
			groupe1=new JMenuItem("Groupe");
			matiere1=new JMenuItem("Module");
			promotion1=new JMenuItem("Promotion");
			seance1=new JMenuItem("Cours");
			tp1=new JMenuItem("TP");
			salle1=new JMenuItem("Salle");
			batiment1=new JMenuItem("Batiment");

		JMenu supprimer=new JMenu("Supprimer");
			enseignant2=new JMenuItem("Enseignant");
			etudiant2=new JMenuItem("Etudiant");
			groupe2=new JMenuItem("Groupe");
			matiere2=new JMenuItem("Module");
			promotion2=new JMenuItem("Promotion");
			seance2=new JMenuItem("Cours");
			tp2=new JMenuItem("TP");
			salle2=new JMenuItem("Salle");
			batiment2=new JMenuItem("Batiment");

		JMenu modifier=new JMenu("Modifier");
			enseignant3=new JMenuItem("Enseignant");
			etudiant3=new JMenuItem("Etudiant");
			groupe3=new JMenuItem("Groupe");
			matiere3=new JMenuItem("Module");
			promotion3=new JMenuItem("Promotion");
			salle3=new JMenuItem("Salle");

		enseignant3.addActionListener(this);
		etudiant3.addActionListener(this);
		groupe3.addActionListener(this);
		matiere3.addActionListener(this);
		promotion3.addActionListener(this);
		salle3.addActionListener(this);

		enseignant2.addActionListener(this);
		etudiant2.addActionListener(this);
		groupe2.addActionListener(this);
		matiere2.addActionListener(this);
		promotion2.addActionListener(this);
		seance2.addActionListener(this);
		tp2.addActionListener(this);
		salle2.addActionListener(this);
		batiment2.addActionListener(this);

		enseignant1.addActionListener(this);
		etudiant1.addActionListener(this);
		groupe1.addActionListener(this);
		matiere1.addActionListener(this);
		promotion1.addActionListener(this);
		seance1.addActionListener(this);
		tp1.addActionListener(this);
		salle1.addActionListener(this);
		batiment1.addActionListener(this);

		enseignant0.addActionListener(this);
		etudiant0.addActionListener(this);
		groupe0.addActionListener(this);
		matiere0.addActionListener(this);
		promotion0.addActionListener(this);
		seance0.addActionListener(this);
		tp0.addActionListener(this);
		salle0.addActionListener(this);
		batiment0.addActionListener(this);
		
		salle_groupe.addActionListener(this);
		salle_enseignant.addActionListener(this);
		type_salle.addActionListener(this);
		
		recherche.add(salle_groupe);
		recherche.add(salle_enseignant);
		recherche.add(type_salle);
		

		afficher.add(enseignant0);
		afficher.add(etudiant0);
		afficher.add(groupe0);
		afficher.add(matiere0);
		afficher.add(promotion0);
		afficher.add(seance0);
		afficher.add(tp0);
		afficher.add(salle0);
		afficher.add(batiment0);

		ajouter.add(enseignant1);
		ajouter.add(etudiant1);
		ajouter.add(groupe1);
		ajouter.add(matiere1);
		ajouter.add(promotion1);
		ajouter.add(seance1);
		ajouter.add(tp1);
		ajouter.add(salle1);
		ajouter.add(batiment1);

		supprimer.add(enseignant2);
		supprimer.add(etudiant2);
		supprimer.add(groupe2);
		supprimer.add(matiere2);
		supprimer.add(promotion2);
		supprimer.add(seance2);
		supprimer.add(tp2);
		supprimer.add(salle2);
		supprimer.add(batiment2);

		modifier.add(enseignant3);
		modifier.add(etudiant3);
		modifier.add(groupe3);
		modifier.add(matiere3);
		modifier.add(promotion3);
		modifier.add(salle3);

		menubar=new JMenuBar();
		menubar.setBackground(Color.LIGHT_GRAY);
		menubar.add(afficher);
		menubar.add(ajouter);
		menubar.add(supprimer);
		menubar.add(modifier);
		menubar.add(recherche);
		if(!etudiant)setJMenuBar(menubar);

		new IGraphique(this,service);

		setTitle(personne.getNom());
		setBounds(100, 100,900, 600);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		try{
			if (e.getSource()==salle_groupe)
				new AfficherSalleByGroupe<>();
			else if (e.getSource()==salle_enseignant)
				new AfficherSalleByEnseignant<>();
			else if (e.getSource()==type_salle)
				new AfficherSalleByType<>();

			if (e.getSource()==enseignant0)
				new Afficher<Enseignant>("Enseignant",EnseignantDAO.getInstance().getAll());
			else if (e.getSource()==etudiant0)
					new Afficher<Etudiant>("Etudiant",EtudiantDAO.getInstance().getAll());
			else if (e.getSource()==groupe0)
				new Afficher<Groupe>("Groupe",GroupeDAO.getInstance().getAll());
			else if (e.getSource()==matiere0)
				new Afficher<Module>("Module",ModuleDAO.getInstance().getAll());
			else if (e.getSource()==promotion0)
				new Afficher<Section>("Section",SectionDAO.getInstance().getAll());
			else if (e.getSource()==seance0)
				new Afficher<Cours>("Cours",CoursDAO.getInstance().getAll());
			else if (e.getSource()==tp0)
				new Afficher<TP>("TP",TPDAO.getInstance().getAll());
			else if (e.getSource()==batiment0)
				new Afficher<Batiment>("Batiment",BatimentDAO.getInstance().getAll());
			else if (e.getSource()==salle0)
				new Afficher<Salle>("Salle",SalleDAO.getInstance().getAll());

			if (e.getSource()==enseignant1)
				new AjouterEnseignant();
			else if (e.getSource()==etudiant1)
				new AjouterEtudiant();
			else if (e.getSource()==groupe1)
				new AjouterGroupe();
			else if (e.getSource()==matiere1)
				new AjouterModule();
			else if (e.getSource()==promotion1)
				new AjouterSection();
			else if (e.getSource()==seance1)
				new AjouterCours("Ajouter",CoursDAO.getInstance()::ajouter);
			else if (e.getSource()==tp1)
				new AjouterTP("Ajouter",TPDAO.getInstance()::ajouter);
			else if (e.getSource()==salle1)
				new AjouterSalle();
			else if (e.getSource()==batiment1)
				new AjouterBatiment();

			else if (e.getSource()==enseignant2)
				new Supprimer<Enseignant> (EnseignantDAO.getInstance()::getAll);
			else if (e.getSource()==etudiant2)
				new Supprimer<Etudiant> (EtudiantDAO.getInstance()::getAll);
			else if (e.getSource()==groupe2)
				new Supprimer<Groupe> (GroupeDAO.getInstance()::getAll);
			else if (e.getSource()==matiere2)
				new Supprimer<Module> (ModuleDAO.getInstance()::getAll);
			else if (e.getSource()==promotion2)
				new Supprimer<Section> (SectionDAO.getInstance()::getAll);
			else if (e.getSource()==salle2)
				new Supprimer<Salle> (SalleDAO.getInstance()::getAll);
			else if (e.getSource()==batiment2)
				new Supprimer<Batiment> (BatimentDAO.getInstance()::getAll);
			else if (e.getSource()==seance2)
				new SupprimerCours("Supprimer",CoursDAO.getInstance()::supprimer);
			else if (e.getSource()==tp2)
				new SupprimerTP("Supprimer",TPDAO.getInstance()::supprimer);

			else if (e.getSource()==enseignant3)
				new ModifierEnseignant();
			else if (e.getSource()==etudiant3)
				new ModifierEtudiant();
			else if (e.getSource()==groupe3)
				new ModifierGroupe();
			else if (e.getSource()==matiere3)
				new ModifierModule();
			else if (e.getSource()==promotion3)
				new ModifierSection();
			else if (e.getSource()==salle3)
				new ModifierSalle();

		}catch(Exception ev){
			JOptionPane.showMessageDialog(this,ev.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Dimension frameSize = frame.getSize();
	   frame.setLocation((screenSize.width / 2) - ((frameSize.width +210)/ 2), (screenSize.height / 2) - (frameSize.height / 2));
	}
}


 