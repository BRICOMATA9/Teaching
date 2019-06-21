package API;

import java.io.*;
import java.net.UnknownHostException;
import be4gi.Edt;
import be4gi.Session;
import Systeme.Client;
import Systeme.Gestion_BDD;
import Systeme.Serveur;

/**
 * Classe EmploiDuTemps implementant l'interface EDT
 * Elle permet l'utilisation de notre application Serveur-Client
 * au travers des méthodes de l'interface EDT
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class EmploiDuTemps implements Edt {
	private Gestion_BDD bd; 
	private static final String fichierXml ="XML/bdedtApi.xml"; 

	/**
	 * Constructeur sans parametre qui lance le serveur
	 */
	public EmploiDuTemps() {
		//On lance le serveur
		Serveur.lanceServeur();
		//System.out.println("lancement serveur");
	}

	/**
	 * Cette méthode permet d'ouvrir une session. Tout utilisateur (inspecteur des études,
	 * enseignant, étudiant) peut ouvrir une session qui lui permettra d'effectuer des opérations
	 * sur l'emploi du temps, à partir du moment où il a été correctement identifié. Dans le cas 
	 * contraire, la création d'une session renverra la valeur null. Un même utilisateur doit
	 * pouvoir ouvrir plusieurs sessions en même temps.
	 * 
	 * @param login pour identifier l'utilisateur
	 * @param pass pour valider l'identification de l'utilisateur
	 * @return la session ouverte ou null si l'identification n'a pu être faite.
	 */
	public Session créerSession(String login, String pass) {
		//System.out.println("creerSession");
		Client c = null;
		boolean ok = false;
		try {
			c = new Client();
			ok=c.Connexion(login, pass);
			//if(ok)System.out.println("Client : "+login+" connecté");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SessionEDT(ok, c);
	}

	/**
	 * Cette méthode permet d'initialiser les données à partir d'un flux XML
	 * valide suivant la dtd bdedt.dtd fournie dans le sujet du BE.
	 * @param inStreamXML le flux XML valide suivant la dtd bdedt.dtd
	 * @return vrai si les données ont été initialisées
	 */
	public boolean initialiserBase(InputStream inStreamXML) {
		//System.out.println("InitialiserBase");
		boolean ok = true;
		try {
			//On ecrit dans le fichier utiliser au chargement de la bdd
			File fichier = new File(fichierXml);
			if(fichier.exists())fichier.delete();
			fichier.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(fichier);
			while(inStreamXML.available()>0) fos.write(inStreamXML.read());
			bd= Gestion_BDD.getInstance();
			bd.chargement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ok= false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ok= false;
		}
		return ok;
	}

	/**
	 * Cette méthode permet d'obtenir l'ensemble des données sous forme d'un
	 * flux XML valide suivant la dtd bdedt.dtd fournie dans le sujet du BE.
	 * 
	 * Le flux de sortie obtenue doit être compatible avec le flux d'entrée de
	 * la méthode initialiserBase(Reader inStreamXML);
	 * 
	 * @param outStreamXML le writer dans lequel on sauvegardera les données
	 * @return vrai si le writer a été correctement initialisé
	 */
	public boolean sauvegarderBase(OutputStream outStreamXML){
		//System.out.println("sauvegarderBase");
		boolean ok = true; 
		File fichier = new File(fichierXml);
		if(!fichier.exists())
		{
			//System.out.println("Aucune base de données n'a été charger");
			ok = false;
		}
		else
		{
			try {
				FileInputStream fis = new FileInputStream(fichier);
				while(fis.available()>0)outStreamXML.write(fis.read());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ok=false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ok=false;
			}
		}
		return ok;
	}

}
