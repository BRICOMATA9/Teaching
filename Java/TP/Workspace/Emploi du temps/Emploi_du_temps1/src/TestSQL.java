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

public class TestSQL extends junit.framework.TestCase{
	
	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private Recherche recherche;
	
	public void setUp() throws Exception {
		DB db = DB.getInstance("root", "aghilesDJ35B");
		db.Execute_DB("use upec");	
		recherche = new Recherche(db);
	}
	
	
	public void testAjouterEtudiant() throws Exception {
		Etudiant etudiant = new Etudiant();
		etudiant.setIdPersonne(2);
		etudiant.setNom("DJOUDI");
		etudiant.setPrenom("Aghiles");
		etudiant.setLogin("Aghiles");
		etudiant.setMdp("Aghiles");
		etudiant.setIdGroupe(1);
		
		recherche.ajouterEtudiant(etudiant);
	}
		
	public void testAjouterEnseignant() throws Exception {
		Enseignant enseignant = new Enseignant();
		enseignant.setIdPersonne(2);
		enseignant.setNom("DJOUDI");
		enseignant.setPrenom("Aghiles");
		enseignant.setLogin("Aghiles");
		enseignant.setMdp("Aghiles");
		enseignant.setGrade("Aghiles");
		recherche.ajouterEnseignant(enseignant);
	}

	public void testAjouterModule() throws Exception {
		Module module = new Module();
		module.setIdModule("DJOUDI");
		module.setNom("Aghiles");
		module.setCoefficient(4);
		
		recherche.ajouterModule(module);
	}
	
	public void testAjouterSection() throws Exception {
		Section section = new Section();
		section.setIdSection(3);
		section.setAnnee((Date) formatterDate.parse("11-11-2011"));
		
		recherche.ajouterSection(section);
	}
	
	public void testAjouterGroupe() throws Exception {
		Groupe groupe = new Groupe();
		groupe.setIdGroupe(1);
		groupe.setIdSection(3);
	
		recherche.ajouterGroupe(groupe);
	}
	
	public void testAjouterCours() throws Exception {
		Cours cours = new Cours();
		cours.setIdSceance(8);
		cours.setIdModule("Aghiles");
		cours.setIdSalle(3);
		cours.setIdEnseignant(2);
		cours.setIdSection(3);
		cours.setDateDebut((Date) formatterDate.parse("11-11-2011"));
		cours.setDuree(3);
		
		recherche.ajouterCours(cours);
	}
	
	public void testAjouterTP() throws Exception {
		TP tp = new TP();
		tp.setIdSceance(2);
		tp.setIdModule("Aghiles");
		tp.setIdSalle(3);
		tp.setIdEnseignant(2);
		tp.setIdGroupe(3);
		tp.setDateDebut((Date) formatterDate.parse("11-11-2011"));
		tp.setDuree(3);
		
		recherche.ajouterTP(tp);
	}
	
	public void testAjouterInscription() throws Exception {
		Inscription inscription = new Inscription();	
		inscription.setIdEtudiant(2);
		inscription.setIdModule("Aghiles");
		inscription.setMoyenne(3.4);
		
		recherche.ajouterInscription(inscription);
	}	
	
	public void testAjouterSalle() throws Exception {
		Salle salle = new Salle();
		salle.setIdSalle(3);
		salle.setCapacite(4);
		salle.setIdBatiment(5);
		recherche.ajouterSalle(salle);
	}

	public void testAjouterBatiment() throws Exception {
		Batiment batiment = new Batiment();
		batiment.setIdBatiment(2);
		
		recherche.ajouterBatiment(batiment);
	}

}