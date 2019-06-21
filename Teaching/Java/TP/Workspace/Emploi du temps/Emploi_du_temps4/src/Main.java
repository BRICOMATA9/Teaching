import java.text.SimpleDateFormat;
import java.util.Date;

import bdd.Batiment;
import bdd.Cours;
import bdd.Enseignant;
import bdd.Etudiant;
import bdd.Groupe;
import bdd.Inscription;
import bdd.Module;
import bdd.Salle;
import bdd.Section;
import bdd.TP;
import sql.DB;
import sql.Recherche;

public class Main {

	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		DB db = DB.getInstance("root", "aghiles","upec");
		db.Execute_DB("use upec");	
		Recherche recherche = new Recherche(db);
		
		Module module = new Module();
			module.setIdModule("Java");
			module.setNom("Java avance");
			module.setCoefficient(3);
			
		Section section = new Section();
			section.setIdSection(1);
			section.setAnnee((Date) formatterDate.parse("01-06-2015"));
			
		Groupe groupe = new Groupe();
			groupe.setIdGroupe(1);
			groupe.setIdSection(1);
		
		Salle salle = new Salle();
			salle.setIdSalle(1);
			salle.setCapacite(40);
			salle.setIdBatiment(1);
		
		Etudiant etudiant = new Etudiant();
			etudiant.setIdPersonne(1);
			etudiant.setNom("DJOUDI");
			etudiant.setPrenom("Aghiles");
			etudiant.setLogin("login");
			etudiant.setMdp("mdp");
			etudiant.setIdGroupe(1);
			
		Enseignant enseignant = new Enseignant();
			enseignant.setIdPersonne(2);
			enseignant.setNom("DJOUDI");
			enseignant.setPrenom("Aghiles");
			enseignant.setLogin("login");
			enseignant.setMdp("mdp");
			enseignant.setGrade("Maitre");
			
		Cours cours = new Cours();
			cours.setIdModule("Java");
			cours.setIdSalle(1);
			cours.setIdEnseignant(2);
			cours.setIdSection(1);
			cours.setDateDebut((Date) formatterDate.parse("01-01-2016"));
			cours.setDuree((Date) formatterTime.parse("08:00:00"));
			
		TP tp = new TP();
			tp.setIdModule("Java");
			tp.setIdSalle(1);
			tp.setIdEnseignant(2);
			tp.setIdGroupe(1);
			tp.setDateDebut((Date) formatterDate.parse("02-1-2016"));
			tp.setDuree((Date) formatterTime.parse("08:00:00"));
			
		Inscription inscription = new Inscription();	
			inscription.setIdEtudiant(1);
			inscription.setIdModule("Java");
			inscription.setMoyenne(3.4);
			
		Batiment batiment = new Batiment();
			batiment.setIdBatiment(1);
		
		recherche.login("aghes","Aghiles");
		
		recherche.supprimerTP(tp);
		recherche.supprimerCours(cours);
		recherche.supprimerInscription(inscription);
		recherche.supprimerEtudiant(etudiant);
		recherche.supprimerGroupe(groupe);
		recherche.supprimerSection(section);
		recherche.supprimerModule(module);
		recherche.supprimerEnseignant(enseignant);
		recherche.supprimerSalle(salle);
		recherche.supprimerBatiment(batiment);
			
		recherche.ajouterBatiment(batiment);
		recherche.ajouterSalle(salle);
		recherche.ajouterEnseignant(enseignant);
		recherche.ajouterModule(module);
		recherche.ajouterSection(section);

		recherche.ajouterGroupe(groupe);
		recherche.ajouterEtudiant(etudiant);
		recherche.ajouterInscription(inscription);
		recherche.ajouterCours(cours);
		recherche.ajouterTP(tp);
		
		recherche.modifierBatiment(batiment);		
		recherche.modifierSalle(salle);	
		recherche.modifierEnseignant(enseignant);
		recherche.modifierModule(module);
		recherche.modifierSection(section);
		recherche.modifierGroupe(groupe);
		recherche.modifierEtudiant(etudiant);
		recherche.modifierInscription(inscription);
		recherche.modifierCours(cours);
		recherche.modifierTP(tp);

		recherche.getAllBatiment();
		recherche.getAllSalle();

		recherche.getAllEnseignant();
		recherche.getAllModule();
		recherche.getAllSection();
		recherche.getAllGroupe();
		recherche.getAllEtudiant();
		recherche.getAllInscription();
		recherche.getAllCours();
		recherche.getAllTP();

		recherche.supprimerTP(tp);
		recherche.supprimerCours(cours);
		recherche.supprimerInscription(inscription);
		recherche.supprimerEtudiant(etudiant);
		recherche.supprimerGroupe(groupe);
		recherche.supprimerSection(section);
		recherche.supprimerModule(module);
		recherche.supprimerEnseignant(enseignant);
		recherche.supprimerSalle(salle);
		recherche.supprimerBatiment(batiment);

	}

}