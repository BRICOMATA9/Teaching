import java.text.SimpleDateFormat;
import java.util.Date;

import bdd.Batiment;
import bdd.Enseignant;
import bdd.Etudiant;
import bdd.Groupe;
import bdd.Inscription;
import bdd.Module;
import bdd.Salle;
import bdd.Cours;
import bdd.Section;
import sql.DB;
import sql.Recherche;

public class Main {

	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		DB db = DB.getInstance("root", "aghilesDJ35B");
		db.Execute_DB("use upec");	
		Recherche recherche = new Recherche(db);
		
		Module module = new Module();
			module.setIdModule("DJOUDI");
			module.setNom("Aghiles");
			module.setCoefficient(4);
			
		Section section = new Section();
			section.setIdSection(3);
			section.setAnnee((Date) formatterDate.parse("11-11-2011"));
			
		Groupe groupe = new Groupe();
			groupe.setIdGroupe(1);
			groupe.setIdSection(3);
		
		Salle salle = new Salle();
			salle.setIdSalle(3);
			salle.setCapacite(4);
			salle.setIdBatiment(5);
		
		Etudiant etudiant = new Etudiant();
			etudiant.setIdPersonne(2);
			etudiant.setNom("DJOUDI");
			etudiant.setPrenom("Aghiles");
			etudiant.setLogin("Aghiles");
			etudiant.setMdp("Aghiles");
			etudiant.setIdGroupe(1);
			
		Enseignant enseignant = new Enseignant();
			enseignant.setIdPersonne(2);
			enseignant.setNom("DJOUDI");
			enseignant.setPrenom("Aghiles");
			enseignant.setLogin("Aghiles");
			enseignant.setMdp("Aghiles");
			enseignant.setGrade("Aghiles");
			
		Cours cours = new Cours();
			cours.setType("Cours");
			cours.setIdModule("Aghiles");
			cours.setIdSalle(3);
			cours.setIdEnseignant(2);
			cours.setIdSection(3);
			cours.setIdGroupe(3);
			cours.setDateDebut((Date) formatterDate.parse("11-11-2011"));
			cours.setHeureDebut((Date) formatterTime.parse("08:00:00"));
			cours.setDuree((Date) formatterTime.parse("01:00:00"));
			
/*		TP tP = new TP();
			tP.setIdModule("Aghiles");
			tP.setIdSalle(3);
			tP.setIdEnseignant(2);
			tP.setIdGroupe(3);
			tP.setDateDebut((Date) formatterDate.parse("11-11-2011"));
			tP.setDuree(3);*/
			
		Inscription inscription = new Inscription();	
			inscription.setIdEtudiant(2);
			inscription.setIdModule("Aghiles");
			inscription.setMoyenne(3.4);
			
		Batiment batiment = new Batiment();
			batiment.setIdBatiment(2);
		
		//recherche.login("aghes","Aghiles");
		
		recherche.supprimerEtudiant(etudiant);
		recherche.supprimerEnseignant(enseignant);
		recherche.supprimerModule(module);
		recherche.supprimerSection(section);
		recherche.supprimerGroupe(groupe);
		recherche.supprimerSeance(cours);
		recherche.supprimerInscription(inscription);
		recherche.supprimerSalle(salle);
		recherche.supprimerBatiment(batiment);
			
		recherche.ajouterEtudiant(etudiant);
		recherche.ajouterEnseignant(enseignant);
		recherche.ajouterModule(module);
		recherche.ajouterSection(section);
		recherche.ajouterGroupe(groupe);
		recherche.ajouterSeance(cours);
		recherche.ajouterInscription(inscription);
		recherche.ajouterSalle(salle);
		recherche.ajouterBatiment(batiment);		
			
		recherche.modifierEtudiant(etudiant);
		recherche.modifierEnseignant(enseignant);
		recherche.modifierModule(module);
		recherche.modifierSection(section);
		recherche.modifierGroupe(groupe);
		recherche.modifierSeance(cours);
		recherche.modifierInscription(inscription);
		recherche.modifierSalle(salle);
		recherche.modifierBatiment(batiment);
			
		recherche.getAllEtudiant();
		recherche.getAllEnseignant();
		recherche.getAllModule();
		recherche.getAllSection();
		recherche.getAllGroupe();
		recherche.getAllSeance();
		recherche.getAllInscription();
		recherche.getAllSalle();
		recherche.getAllBatiment();
			
		recherche.supprimerEtudiant(etudiant);
		recherche.supprimerEnseignant(enseignant);
		recherche.supprimerModule(module);
		recherche.supprimerSection(section);
		recherche.supprimerGroupe(groupe);
		recherche.supprimerSeance(cours);
		recherche.supprimerInscription(inscription);
		recherche.supprimerSalle(salle);
		recherche.supprimerBatiment(batiment);
	}

}
