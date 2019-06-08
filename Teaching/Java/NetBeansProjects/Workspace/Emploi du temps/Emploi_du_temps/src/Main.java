import java.text.SimpleDateFormat;
import java.util.Date;

import BDD.Batiment;
import BDD.Cours;
import BDD.Enseignant;
import BDD.Etudiant;
import BDD.Groupe;
import BDD.Inscription;
import BDD.Module;
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
import SQL.DB;

public class Main {

	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		DB db = DB.getInstance("root", "aghiles","upec");
		db.Execute_DB("use upec");	
		//Recherche recherche = new Recherche(db);
		
		Batiment batiment = new Batiment();
			batiment.setIdBatiment(1);
		
		Module module = new Module();
			module.setIdModule("Java");
			module.setNom("Java avance");
			module.setCoefficient(3);
			
		Section section = new Section();
			section.setIdSection(1);
			section.setAnnee((Date) formatterDate.parse("01-06-2015"));
			
		Groupe groupe = new Groupe();
			groupe.setIdGroupe(1);
			groupe.setIdSection(section);
		
		Salle salle = new Salle();
			salle.setIdSalle(1);
			salle.setCapacite(40);
			salle.setIdBatiment(batiment);
		
		Etudiant etudiant = new Etudiant();
			etudiant.setIdPersonne(1);
			etudiant.setNom("DJOUDI");
			etudiant.setPrenom("Aghiles");
			etudiant.setLogin("login");
			etudiant.setMdp("mdp");
			etudiant.setIdGroupe(groupe);
			
		Enseignant enseignant = new Enseignant();
			enseignant.setIdPersonne(2);
			enseignant.setNom("DJOUDI");
			enseignant.setPrenom("Aghiles");
			enseignant.setLogin("login");
			enseignant.setMdp("mdp");
			enseignant.setGrade("Maitre");
			
		Cours cours = new Cours();
			cours.setIdModule(module);
			cours.setIdSalle(salle);
			cours.setIdEnseignant(enseignant);
			cours.setIdSection(section);
			cours.setDateDebut((Date) formatterDate.parse("01-01-2016"));
			cours.setHeureDebut((Date) formatterTime.parse("08:00:00"));
			cours.setDuree((Date) formatterTime.parse("08:00:00"));
			
		TP tp = new TP();
			tp.setIdModule(module);
			tp.setIdSalle(salle);
			tp.setIdEnseignant(enseignant);
			tp.setIdGroupe(groupe);
			tp.setIdSection(section);
			tp.setDateDebut((Date) formatterDate.parse("02-1-2016"));
			tp.setHeureDebut((Date) formatterTime.parse("08:00:00"));
			tp.setDuree((Date) formatterTime.parse("08:00:00"));
			
		Inscription inscription = new Inscription();	
			inscription.setIdEtudiant(1);
			inscription.setIdModule("Java");
			inscription.setMoyenne(3.4);

		
		//recherche.login("aghes","Aghiles");
		
		TPDAO.getInstance().supprimer(tp);
		CoursDAO.getInstance().supprimer(cours);
		EtudiantDAO.getInstance().supprimer(etudiant);
		GroupeDAO.getInstance().supprimer(groupe);
		SectionDAO.getInstance().supprimer(section);
		ModuleDAO.getInstance().supprimer(module);
		EnseignantDAO.getInstance().supprimer(enseignant);
		SalleDAO.getInstance().supprimer(salle);
		BatimentDAO.getInstance().supprimer(batiment);
			
		BatimentDAO.getInstance().ajouter(batiment);
		SalleDAO.getInstance().ajouter(salle);
		EnseignantDAO.getInstance().ajouter(enseignant);
		ModuleDAO.getInstance().ajouter(module);
		SectionDAO.getInstance().ajouter(section);
		GroupeDAO.getInstance().ajouter(groupe);
		EtudiantDAO.getInstance().ajouter(etudiant);
		CoursDAO.getInstance().ajouter(cours);
		TPDAO.getInstance().ajouter(tp);
		
		BatimentDAO.getInstance().modifier(batiment);		
		SalleDAO.getInstance().modifier(salle);	
		EnseignantDAO.getInstance().modifier(enseignant);
		ModuleDAO.getInstance().modifier(module);
		SectionDAO.getInstance().modifier(section);
		GroupeDAO.getInstance().modifier(groupe);
		EtudiantDAO.getInstance().modifier(etudiant);
		CoursDAO.getInstance().modifier(cours);
		TPDAO.getInstance().modifier(tp);

		BatimentDAO.getInstance().getAll();
		SalleDAO.getInstance().getAll();
		EnseignantDAO.getInstance().getAll();
		ModuleDAO.getInstance().getAll();
		SectionDAO.getInstance().getAll();
		GroupeDAO.getInstance().getAll();
		EtudiantDAO.getInstance().getAll();
		CoursDAO.getInstance().getAll();
		TPDAO.getInstance().getAll();

		TPDAO.getInstance().supprimer(tp);
		CoursDAO.getInstance().supprimer(cours);
		EtudiantDAO.getInstance().supprimer(etudiant);
		GroupeDAO.getInstance().supprimer(groupe);
		SectionDAO.getInstance().supprimer(section);
		ModuleDAO.getInstance().supprimer(module);
		EnseignantDAO.getInstance().supprimer(enseignant);
		SalleDAO.getInstance().supprimer(salle);
		BatimentDAO.getInstance().supprimer(batiment);

	}

}