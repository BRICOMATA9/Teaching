package Systeme;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.net.Socket;
import java.util.*;

import bdd.*;

public class Gestion_EDT {

	static final int port = 8080;
/*	private Socket soc;
	private Thread t;
	private ObjectInputStream in;
	private ObjectOutputStream out;*/

	public static final int PROMOTION =0;
	public static final int SALLE =1;
	private Personne utilisateur;
	private int typeUtilisateur;
	private int typeEDT;
	private Gestion_BDD bd;
	public Client client;
	
	public Gestion_EDT(Client client) {
		this.bd = Gestion_BDD.getInstance();
		this.typeEDT=Gestion_EDT.PROMOTION;

	}

	//méthode qui ferme la connection socket */
	private void FermerConnexion(){
	}

	public Vector<Personne> afficher_liste_contacts () {
		return bd.getRespEns();
	}

	public Vector<Personne> Recuperer_Email(){
		return (bd.getUtilisateurs());
	}

	public Vector[] recuperer_listes (){
			Vector[] table = {	bd.getSalles(),
													bd.getMatieres(),
													bd.getGroupesResp((Responsable)utilisateur),
													bd.getEns(),
													bd.getCoursPromotion((Responsable)utilisateur)
												};		
			return (table);
	}

	public Boolean Saisir_EDT2(String matiere, String salle, Creneau creneau, String groupe){
			try {
				Matiere mat = bd.getMatiere(matiere);
				Salle sal = bd.getSalle(salle);
				Groupe gp = bd.getGroupe(groupe);
				return Saisir_EDT(mat, sal,creneau,gp,null);
			} catch (Exception e) {
				return (false);
			}	
	}

	public void Choisir_EDT (int type) {
		typeEDT = type;
	}

	//La méthode qui cherche quel signal est recu et execute la commande appropriée */
	public void close() throws Exception {

/*		if(methode.getNom().compareTo("Modifier_EDT")==0){
			Modifier_EDT(methode);
		}*/
			if (utilisateur!=null){	
				if(utilisateur.getClass()==Responsable.class){
					//bd.sauveBDD();
					//bd.sauvegarde();
				}
			}
			FermerConnexion();
	}

	public Vector<Vector<Cours>> recuperer_EDT_Promo (String promo){
			Vector<Vector<Cours>> liste_cours = new Vector<Vector<Cours>>();
			Responsable resp;
			try {
				resp = (bd.getPromotion(promo)).getResp();
				trie_par_jour(bd.getCoursPromotion(resp), liste_cours);
			} catch (Exception e) {
				//e.printStackTrace();
			}
			return liste_cours;
		}
	
	/* la methode qui supprime un cours */
	public Boolean Supprimer_EDT(Cours cours) throws IOException {
		return bd.supprime_cours(cours);
	}
	
	/* saisie d'un cours */
	public Boolean Saisir_EDT(Matiere mat, Salle salle, Creneau cren, Groupe gp, Enseignant ens) throws Exception {
			if(ens!=null)
				bd.addCours(new Cours(mat, salle, gp, cren, ens));
			else 
				bd.addCours(new Cours(cren, salle, gp, mat));
			bd.testAffiche();
			return true;
	}
	/* modification d'un cours */
/*	private void Modifier_EDT(Signal methode) throws IOException {
		Boolean ok = true;
		
		Matiere mat = (Matiere)methode.getParametres().elementAt(0);
		Salle salle = (Salle)methode.getParametres().elementAt(1);
		Creneau cren = (Creneau)methode.getParametres().elementAt(2);
		Groupe gp = (Groupe)methode.getParametres().elementAt(3);
		Enseignant ens = (Enseignant)methode.getParametres().elementAt(4);
		
		Cours c = bd.getCours(cren, salle);
		if(c==null) ok=false; //cours inexistant pas de modification
		else if (!(c.getGroupe().getResponsable().egal((Responsable)utilisateur))){
			ok=false;
		}
		else{
			c.setMatiere(mat);
			c.setEnseignant(ens);
			c.setGroupe(gp);
		}
		
		//out.writeObject(ok);
		
	}*/
	
	/* methode qui trie les cours par jour dans la liste que l'on utilise */
	private void trie_par_jour(Vector<Cours> cours, Vector<Vector<Cours>> liste_cours){
		String date="";
		
		for(int i =0; i<cours.size(); i++){
			//A chaque novelle date on ajoute un vecteur de cours
			if(cours.elementAt(i).getCreneau().getDate().toString().compareTo(date)!=0){
				liste_cours.add(new Vector<Cours>());
				date = cours.elementAt(i).getCreneau().getDate().toString();
			}
			
			//On ajoute le cours au dernier vecteur de cours cree
			liste_cours.lastElement().add(cours.elementAt(i));
		}
	}
	
	//Methodes a appeler lors de la reception d'un signal "connection"
	public int Connection(String nom, String mdp) throws IOException{
		boolean ok=false;
		//System.out.println("Connection: "+nom+ "  " + mdp);
		
		for(int i=0; i<bd.getUtilisateurs().size() && !ok; i++){
			utilisateur=(Personne)bd.getUtilisateurs().elementAt(i);
			
			if((utilisateur.getUsername().compareTo(nom)==0)){
				if(utilisateur.getPassword().compareTo(mdp)==0){
					ok= true;
				}
			}
		}
		
		if(ok){
			typeUtilisateur = Personne.ETUDIANT;
			if(utilisateur.getClass()==Responsable.class){
				typeUtilisateur= Personne.RESPONSABLE;
			}
			else if(utilisateur.getClass()==Enseignant.class){
				typeUtilisateur= Personne.ENSEIGNANT;
			}
			return (typeUtilisateur);
		}
		
		//Si on a pas trouve l'utilisateur
		/*if (!ok){
			System.exit(0);
		}*/
		return 3;
	}
	
	/* methode qui recupere l'emploi du temps demandé */
	public Vector<Vector<Cours>> recuperer_EDT(String promo) throws Exception{
		Vector<Vector<Cours>> liste_cours = new Vector<Vector<Cours>>();
		System.out.println(this.typeUtilisateur);
		switch(this.typeUtilisateur){
			case Personne.RESPONSABLE :{
				switch (this.typeEDT){
					case Gestion_EDT.PROMOTION : trie_par_jour(bd.getCoursPromotion((Responsable)utilisateur), liste_cours);break;
					case Gestion_EDT.SALLE : trie_par_jour(bd.getCoursSalle(bd.getSalle(promo)), liste_cours);break;
				}
				break;
			}
			case Personne.ENSEIGNANT :{
				trie_par_jour(((Enseignant)utilisateur).getListe_cours(), liste_cours);
				break;
			}
			case Personne.ETUDIANT :{
				trie_par_jour(bd.getCoursGroupes(((Etudiant)utilisateur).getGroupes()), liste_cours);
				break;
			}
		}
		return liste_cours;
	}
	
	/* methode qui envoi au client les cours qu'il a demandé */
	public Vector<Vector<Cours>> visualiser_EDT(String methode,Jours Semaine) throws Exception{
		Vector<Vector<Cours>> liste_cours = recuperer_EDT(methode);
		
		/* on recupere seulement ceux de la semaine desiree */
		Vector<Vector<Cours>> tabCours = new Vector<Vector<Cours>>();
		
		int j=1, i=0;
		//System.out.println(Semaine.getJours(j));
		Date jour = Semaine.getJours(j);
		while(i< liste_cours.size() && j<6){
			Cours c = liste_cours.elementAt(i).firstElement();
			int test =c.compareJour(jour);
			if(test==0){
				tabCours.add(liste_cours.elementAt(i));
				j++;
				jour = Semaine.getJours(j);
				i++;
			}
			else if(test<0){
				i++;
			}
			else if(test>0) {//liste_cours[i] apres le jour 
				tabCours.add(new Vector<Cours>());
				j++;
				jour = Semaine.getJours(j);		
			}
		}
		
		while(tabCours.size()<5){
			tabCours.add(new Vector<Cours>());
		}
		return tabCours;
	}
}
