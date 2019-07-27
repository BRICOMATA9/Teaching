package API;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.Vector;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import Systeme.*;
import bdd.*;
import be4gi.Session;

/**
 * Classe SessionEDT implementant l'interface Session
 * Elle permet l'utilisation de notre application Serveur-Client
 * au travers des méthodes de l'interface Session
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class SessionEDT implements Session {

	private boolean ouverte;
	private Client client;

	/**
	 * Constructeur d'une SessionEDT
	 * @param ouverte : indique si la connection est établie
	 * @param client
	 */
	public SessionEDT(boolean ouverte, Client client) {
		this.ouverte = ouverte;
		this.client=null;
		if(ouverte)	this.client = client;
	}

	/**
	 * méthode permettant de savoir si une session est ouverte ou fermée
	 * @return true si la session est ouverte, false sinon
	 */
	public boolean estOuverte() {
		return ouverte;
	}

	/**
	 * méthode permettant de fermer une session ouverte. Si la session avait déjà été fermée, une
	 * exception sera levée.
	 * 
	 * @throws Exception levée si la session était déjà fermée.
	 */
	public void fermer() throws Exception {
		if(!ouverte) throw new Exception("Connexion déja fermer");
		client.FermerConnexion();
	}

	/**
	 * cette méthode permet de recevoir sous forme d'un flux XML, l'emploi du temps correspondant
	 * à l'utilisateur associé à la session (si c'est un inspecteur d'étude, c'est l'emploi du 
	 * temps de l'année dont il s'occupe.
	 * 
	 * @throws Exception - levée si l'utilisateur associé à la session n'a pas les droits requis
	 * pour une telle requête.
	 */
	public void getEDT(OutputStream outStreamXML) throws Exception {
		if(!ouverte) throw new Exception("Aucune connexion ouverte");
		
		Vector<Vector<Cours>>ListeCours = client.recupererEDT("");
		
		Element racine = new Element("edt");
		Document document = new Document(racine);
		
		Iterator i = ListeCours.iterator();
		while(i.hasNext())
		{
			Gestion_BDD.sauvegardeCours(racine, (Vector<Cours>) i.next());
		}
		
		try
		   {
		      //On utilise ici un affichage classique avec getPrettyFormat()
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      sortie.output(document, outStreamXML);
		      Gestion_BDD.afficheXML(document);
		   }
		   catch (java.io.IOException e){e.printStackTrace();}
	}

	/**
	 * cette méthode permet de recevoir sous forme d'un flux XML, l'emploi du temps correspondant
	 * à l'ensemble d'une promotion. Le format correspondra à la dtd du fichier d'initialisation de
	 * la base de donnée, avec seulement l'élément "edt" comme élément racine.
	 * 
	 * une exeption est levée si la promotion n'existe pas.
	 */
	public void getEDT(OutputStream outStreamXML, String promotion)throws Exception {
		if(!ouverte) throw new Exception("Aucune connexion ouverte");
		
		Vector<Vector<Cours>>ListeCours = client.recupererEDT(promotion);
		if(ListeCours.size()==0)throw new Exception("Promotion inexistante");
		
		Element racine = new Element("edt");
		Document document = new Document(racine);
		
		Iterator i = ListeCours.iterator();
		while(i.hasNext())
		{
			Gestion_BDD.sauvegardeCours(racine, (Vector<Cours>) i.next());
		}
		
		try
		   {
		      //On utilise ici un affichage classique avec getPrettyFormat()
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      sortie.output(document, outStreamXML);
		      Gestion_BDD.afficheXML(document);
		   }
		   catch (java.io.IOException e){e.printStackTrace();}

	}

	/**
	 * Cette méthode permet d'obtenir l'ensemble des emails sous forme d'un flux xml. Le format 
	 * correspondra à la dtd du fichier d'initialisation de la base de donnée, mais avec seulement le
	 * contenu des éléments  "inspecteurs" et "enseignants" sans les
	 * les logins et les mots de passe. (les étudiants n'ayant pas d'adresse email)
	 * @param outStreamXML
	 */
	public void getEmail(OutputStream outStreamXML) throws Exception {
		if(!ouverte) throw new Exception("Aucune connexion ouverte");
		
		Vector<Personne> utilisateurs = client.Recuperer_Email();
		
		Element racine = new Element("bdedt");
		Document document = new Document(racine);
		
		//Ajout des responsables et des enseignants
		Element inspecteurs = new Element("inspecteurs");
		racine.addContent(inspecteurs);
		Element enseignants = new Element("enseignants");
		racine.addContent(enseignants);
		Gestion_BDD.sauvegardeUtilisateurs(inspecteurs, enseignants,utilisateurs,true);

		try
		   {
		      //On utilise ici un affichage classique avec getPrettyFormat()
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      sortie.output(document, outStreamXML);
		      //Gestion_BDD.afficheXML(document);
		   }
		   catch (java.io.IOException e){e.printStackTrace();}
	}

	/**
	 * cette méthode permet de recevoir sous forme d'un flux XML, les reservations pour 
	 * une salle donnée. Le format correspondra à la dtd du fichier d'initialisation de la base de
	 * donnée, avec seulement l'élément "edt" comme élément racine.
	 * 
	 * une exeption est levée si la salle n'existe pas.
	 */
	public void getRéservation(OutputStream outStreamXML, String salle)throws Exception {
		if(!ouverte) throw new Exception("Aucune connexion ouverte");
		
		client.Choisir_EDT(Gestion_EDT.SALLE);
		Vector<Vector<Cours>>ListeCours = client.recupererEDT(salle);
		client.Choisir_EDT(Gestion_EDT.PROMOTION);
		
		Element racine = new Element("edt");
		Document document = new Document(racine);
		
		Iterator i = ListeCours.iterator();
		while(i.hasNext())
		{
			Gestion_BDD.sauvegardeCours(racine, (Vector<Cours>) i.next());
		}
		
		try
		   {
		      //On utilise ici un affichage classique avec getPrettyFormat()
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      sortie.output(document, outStreamXML);
		      //Gestion_BDD.afficheXML(document);
		   }
		   catch (java.io.IOException e){e.printStackTrace();}

	}

	/**
	 * cette méthode permet d'effectuer une réservation. Les formats utilisés pour les chaînes de
	 * caractères correspondant aux date, heure et durée sont les mêmes que ceux utilisés dans le
	 * fichier d'initialisation de la base de donnée.
	 * 
	 * une exception est levée si l'opération n'est pas permise. La cause sera indiquée en tant que
	 * message associé à l'exception (heure incorrecte, salle inexistante, salle déjà réservée, etc.)
	 */
	public void setRéservation(String date, String heure, String duree,String salle, String groupe, String matiere) throws Exception {
		client.Ajouter_Cours(matiere, salle, new Creneau(date,heure,duree), groupe);

	}

}
