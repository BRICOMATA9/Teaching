package Systeme;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

import bdd.*;
/**
 * Classe Gestion EDT qui est le thread qui demarre a chaque fois qu'un client se connecte au serveur. 
 * @author Alexander Remen et Tonya Vo Thanh
 *<p>La classe communique avec le client par TCP et avec Gestion_BDD qui s'occupe de la base de donnée.
 * Les stacktraces ne sont pas enlever dans cette partie pour faciliter la tâche de deboguage du côté serveur.
 * On imagine que celui qui fait tourner le serveur devrait avoir la possibilité d'améliorer le serveur et c'est donc avantageux. </p>
 */
public class Gestion_EDT extends Thread {

	static final int port = 8080;
	private Socket soc;
	private Thread t;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public static final int PROMOTION =0;
	public static final int SALLE =1;
	private Personne utilisateur;
	private int typeUtilisateur;
	private int typeEDT;
	private Gestion_BDD bd;
	
    /**
     * Constructeur d'un thread gestion edt
	 * @param soc
	 */
	public Gestion_EDT(Socket soc) {
		try
		{
			System.out.println("Nouveau client : "+soc);
			this.bd = Gestion_BDD.getInstance();
			this.soc = soc;
			this.typeEDT=Gestion_EDT.PROMOTION;
			
			in = new ObjectInputStream(this.soc.getInputStream());
		    out = new ObjectOutputStream(this.soc.getOutputStream());
		    
		    t = new Thread(this);
		    t.start();
		}catch(Exception e){
		   e.printStackTrace();
		}
	}
	
	/**
	 * Methode qui attends les signaux du client et execute la commande demandé
	 */
	public void run()
	{
		
		try {
			while (true)
			{
				Signal methode = (Signal)in.readObject();
				System.out.println("Reception du signal : "+methode.getNom());
				execute(methode);			
			}
			
		} catch (IOException e1) {} 
		  catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* méthode qui ferme la connection socket */
	private void FermerConnexion()
	{
		try {
			out.close();
			in.close();
			soc.close();
			System.out.println("Depart client : "+soc);
		} catch (IOException e) {
			System.out.println("Erreur fermeture socket");
		}
	}
	/* La méthode qui cherche quel signal est recu et execute la commande appropriée */
	private void execute(Signal methode) throws Exception
	{
		if(methode.getNom().compareTo("Connexion")==0)
		{
			Connection((String)methode.getParametres().elementAt(0),(String)methode.getParametres().elementAt(1));
		}
		else if(methode.getNom().compareTo("Test")==0)
		{
			System.out.println("Bonjour la connexion a reussi");
		}
		else if(methode.getNom().compareTo("visualiser_EDT")==0)
		{
			//Retourne la liste des cours trier
			//bd.testAffiche();
			Jours semaine = (Jours)methode.getParametres().elementAt(0);
			visualiser_EDT(methode,semaine);
			
		}
		else if(methode.getNom().compareTo("recuperer_EDT")==0)
		{
			out.writeObject(this.recuperer_EDT(methode));
		}
		else if(methode.getNom().compareTo("recuperer_EDT_Promo")==0)
		{
			Vector<Vector<Cours>> liste_cours = new Vector<Vector<Cours>>();
			Responsable resp;
			try {
				resp = (bd.getPromotion((String)methode.getParametres().firstElement())).getResp();
				trie_par_jour(bd.getCoursPromotion(resp), liste_cours);
			} catch (Exception e) {
				//e.printStackTrace();
			}
			out.writeObject(liste_cours);
		}
		else if(methode.getNom().compareTo("afficher_liste_contacts")==0)
		{
			//Retourne la liste de responsable et d'enseignant
			out.writeObject(bd.getRespEns());
		}
		else if(methode.getNom().compareTo("Choisir_EDT")==0)
		{
			typeEDT = (Integer)methode.getParametres().firstElement();
		}
		else if(methode.getNom().compareTo("envoi_email")==0)
		{
			String email = (String)methode.getParametres().elementAt(0);
			String sujet = (String)methode.getParametres().elementAt(1);
			String message = (String)methode.getParametres().elementAt(2);
			SimpleMailSender new_mail = new SimpleMailSender();
			out.writeObject(new_mail.envoimail(email, utilisateur.getEmail(), sujet, message));
		}
		else if(methode.getNom().compareTo("recuperer_listes")==0)
		{
			Vector[] table = {bd.getSalles(),bd.getMatieres(),bd.getGroupesResp((Responsable)utilisateur),bd.getEns(),bd.getCoursPromotion((Responsable)utilisateur)};//		
			out.writeObject(table);
		}
		else if(methode.getNom().compareTo("Saisir_EDT")==0)
		{
			Matiere mat = (Matiere)methode.getParametres().elementAt(0);
			Salle salle = (Salle)methode.getParametres().elementAt(1);
			Creneau cren = (Creneau)methode.getParametres().elementAt(2);
			Groupe gp = (Groupe)methode.getParametres().elementAt(3);
			Enseignant ens = (Enseignant)methode.getParametres().elementAt(4);
			Saisir_EDT(mat, salle,cren,gp,ens);
			//bd.testAffiche();
		}
		else if(methode.getNom().compareTo("Saisir_EDT2")==0)
		{
			try {
				Matiere mat = bd.getMatiere((String)methode.getParametres().elementAt(0));
				Salle salle = bd.getSalle((String)methode.getParametres().elementAt(1));
				Creneau cren = (Creneau)methode.getParametres().elementAt(2);
				Groupe gp = bd.getGroupe((String)methode.getParametres().elementAt(3));
				Saisir_EDT(mat, salle,cren,gp,null);
			} catch (Exception e) {
				out.writeObject(false);
				out.writeObject(e);
			}
			
			//bd.testAffiche();
		}
		else if(methode.getNom().compareTo("Modifier_EDT")==0)
		{
			Modifier_EDT(methode);
		}
		else if(methode.getNom().compareTo("Supprimer_EDT")==0)
		{
			Supprimer_EDT((Cours)methode.getParametres().firstElement());
		}
		else if(methode.getNom().compareTo("close")==0)
		{
			if (utilisateur!=null)
			{	
				if(utilisateur.getClass()==Responsable.class)
				{
					bd.sauveBDD();
					bd.sauvegarde();
				}
			}
			FermerConnexion();
		}
		else if(methode.getNom().compareTo("Recuperer_Email")==0)
		{
			out.writeObject(bd.getUtilisateurs());
		}
		
		//A la fin de chaque signal on sauvegarde la nouvelle base de donnees
		bd.sauveBDD();
	}
	
	/* la methode qui supprime un cours */
	private void Supprimer_EDT(Cours cours) throws IOException {
		Boolean ok = bd.supprime_cours(cours);
		out.writeObject(ok);
	}
	
	/* saisie d'un cours */
	private void Saisir_EDT(Matiere mat, Salle salle, Creneau cren, Groupe gp, Enseignant ens) throws IOException {
		try {
			if(ens!=null)bd.addCours(new Cours(mat, salle, gp, cren, ens));
			else bd.addCours(new Cours(cren, salle, gp, mat));
			out.writeObject(true);
		} catch (Exception e) {
			out.writeObject(false);
			out.writeObject(e);
		}
	}
	/* modification d'un cours */
	private void Modifier_EDT(Signal methode) throws IOException {
		Boolean ok = true;
		
		Matiere mat = (Matiere)methode.getParametres().elementAt(0);
		Salle salle = (Salle)methode.getParametres().elementAt(1);
		Creneau cren = (Creneau)methode.getParametres().elementAt(2);
		Groupe gp = (Groupe)methode.getParametres().elementAt(3);
		Enseignant ens = (Enseignant)methode.getParametres().elementAt(4);
		
		Cours c = bd.getCours(cren, salle);
		if(c==null) ok=false; //cours inexistant pas de modification
		else if (!(c.getGroupe().getResponsable().egal((Responsable)utilisateur)))
		{
			ok=false;
		}
		else
		{
			c.setMatiere(mat);
			c.setEnseignant(ens);
			c.setGroupe(gp);
		}
		
		out.writeObject(ok);
		
	}
	
	/* methode qui trie les cours par jour dans la liste que l'on utilise */
	private void trie_par_jour(Vector<Cours> cours, Vector<Vector<Cours>> liste_cours)
	{
		String date="";
		
		for(int i =0; i<cours.size(); i++)
		{
			//A chaque novelle date on ajoute un vecteur de cours
			if(cours.elementAt(i).getCreneau().getDate().toString().compareTo(date)!=0)
			{
				liste_cours.add(new Vector<Cours>());
				date = cours.elementAt(i).getCreneau().getDate().toString();
			}
			
			//On ajoute le cours au dernier vecteur de cours cree
			liste_cours.lastElement().add(cours.elementAt(i));
		}
	}
	
	/*
	 * Methodes a appeler lors de la 
	 * reception d'un signal "connection"
	 * @throws IOException 
	 */
	private void Connection(String nom, String mdp) throws IOException
	{
		boolean ok=false;
		//System.out.println("Connection: "+nom+ "  " + mdp);
		
		for(int i=0; i<bd.getUtilisateurs().size() && !ok; i++)
		{
			utilisateur=(Personne)bd.getUtilisateurs().elementAt(i);
			
			if((utilisateur.getUsername().compareTo(nom)==0))
			{
				if(utilisateur.getPassword().compareTo(mdp)==0)
				{
					ok= true;
				}
			}
		}
		
		out.writeObject(ok);
		
		if(ok)
		{
			typeUtilisateur = Personne.ETUDIANT;
			if(utilisateur.getClass()==Responsable.class)
			{
				typeUtilisateur= Personne.RESPONSABLE;
			}
			else if(utilisateur.getClass()==Enseignant.class)
			{
				typeUtilisateur= Personne.ENSEIGNANT;
			}
			out.writeObject(typeUtilisateur);
		}
		
		//Si on a pas trouve l'utilisateur
		/*if (!ok)
		{
			System.exit(0);
		} */
	}
	
	/* methode qui recupere l'emploi du temps demandé */
	private Vector<Vector<Cours>> recuperer_EDT(Signal methode) throws Exception
	{
		Vector<Vector<Cours>> liste_cours = new Vector<Vector<Cours>>();
		
		switch(this.typeUtilisateur)
		{
			case Personne.RESPONSABLE :
			{
				switch (this.typeEDT)
				{
					case Gestion_EDT.PROMOTION : trie_par_jour(bd.getCoursPromotion((Responsable)utilisateur), liste_cours);break;
					case Gestion_EDT.SALLE : trie_par_jour(bd.getCoursSalle(bd.getSalle((String)methode.getParametres().firstElement())), liste_cours);break;
				}
				break;
			}
			case Personne.ENSEIGNANT :
			{
				trie_par_jour(((Enseignant)utilisateur).getListe_cours(), liste_cours);
				break;
			}
			case Personne.ETUDIANT :
			{
				trie_par_jour(bd.getCoursGroupes(((Etudiant)utilisateur).getGroupes()), liste_cours);
				break;
			}
		}
		
		return liste_cours;
	}
	
	/* methode qui envoi au client les cours qu'il a demandé */
	private void visualiser_EDT(Signal methode,Jours Semaine) throws Exception
	{
		Vector<Vector<Cours>> liste_cours = recuperer_EDT(methode);
		
		/* on recupere seulement ceux de la semaine desiree */
		Vector<Vector<Cours>> tabCours = new Vector<Vector<Cours>>();
		
		int j=1, i=0;
		//System.out.println(Semaine.getJours(j));
		Date jour = Semaine.getJours(j);
		while(i< liste_cours.size() && j<6)
		{
			Cours c = liste_cours.elementAt(i).firstElement();
			int test =c.compareJour(jour);
			if(test==0)
			{
				tabCours.add(liste_cours.elementAt(i));
				j++;
				jour = Semaine.getJours(j);
				i++;
			}
			else if(test<0)
			{
				i++;
			}
			else if(test>0) //liste_cours[i] apres le jour 
			{
				tabCours.add(new Vector<Cours>());
				j++;
				jour = Semaine.getJours(j);
				
			}
		}
		
		while(tabCours.size()<5)
		{
			tabCours.add(new Vector<Cours>());
		}
		
		
		out.writeObject(tabCours);
	}
}
