package Systeme;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import bdd.Cours;
import bdd.Creneau;
import bdd.Enseignant;
import bdd.Groupe;
import bdd.Matiere;
import bdd.Personne;
import bdd.Salle;

import Interfaces.Interface_Connexion;
import Interfaces.Interface_EDT;
import Interfaces.Interface_Reservation;

public class Client {

	static final int port = 8080;
	private Socket soc;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private int typeUtilisateur;
	public Gestion_EDT gestion;
	public Client() throws UnknownHostException, IOException, ClassNotFoundException{
		//Reseau local
		String host = InetAddress.getLocalHost().getHostAddress();
		gestion = new Gestion_EDT(this);
	}

	public  Vector<Vector<Cours>> recuperercoursdelasemaine(Jours semaine) throws Exception, ClassNotFoundException{
		try{
			return gestion.visualiser_EDT("",semaine);
		}catch(Exception e) {return null;}
	}

	public Vector<Vector<Cours>> recupererEDT(String promo) throws IOException, ClassNotFoundException{
		try{
		if(promo.compareTo("")==0) 
			return gestion.recuperer_EDT(promo);
		else 
			return gestion.recuperer_EDT_Promo(promo);
		}catch(Exception e){return null;}
	}

	public void Afficher_Emploi_du_temps() throws IOException, ClassNotFoundException{
		Interface_EDT Graphic_EDT= new Interface_EDT();
		
		Graphic_EDT.Afficher_EDT(this);
		Vector<Personne> ListePersonne = gestion.afficher_liste_contacts();
		Graphic_EDT.init_fenetre_mail(ListePersonne,this);
		/* Si c'est un inspecteur */
		//if(typeUtilisateur==Personne.RESPONSABLE){
			Interface_Reservation FenetreReservation = new Interface_Reservation();
			FenetreReservation.Affiche_Interface_Reservation(this);
		//}
	}

	public void Choisir_EDT(int type){
		gestion.Choisir_EDT(type);
	}

	public Vector<Personne> Recuperer_Email() throws IOException, ClassNotFoundException{
		return gestion.Recuperer_Email();
	}

	public Boolean Connexion(String login, String mdp) throws IOException, ClassNotFoundException{

		typeUtilisateur = gestion.Connection(login,mdp);
		
		return typeUtilisateur!=3?true:false;
	}

	public Boolean Supprimer_cours(Cours cours_a_supprimer) throws IOException, ClassNotFoundException{

		return gestion.Supprimer_EDT(cours_a_supprimer);
	}

	public Boolean Ajouter_Cours(Matiere mat, Salle salle, Creneau cren, Groupe gp, Enseignant ens) throws Exception, ClassNotFoundException{
		
		return gestion.Saisir_EDT(mat,salle,cren,gp,ens);
	}

	public Boolean Ajouter_Cours(String matiere, String salle, Creneau creneau, String groupe) throws Exception {
		return gestion.Saisir_EDT2(matiere, salle, creneau, groupe);
		
	}

	public Boolean Envoi_email(String email, String sujet, String Message) throws IOException, ClassNotFoundException {	
		return true;//((Boolean)in.readObject());
	}

	public Vector[] Recup_Listes_Reservation() throws IOException, ClassNotFoundException{
		return gestion.recuperer_listes();
	}
	
	public void FermerConnexion(){
		try{
			gestion.close();
		}catch(Exception e){}	
	}
	
	public static void main(String[] args) {
		try {
			Client c = new Client();
			System.out.println("Client cree");

			Interface_Connexion Login = new Interface_Connexion();
			Login.affiche_login_screen(c);
			
			//c.FermerConnexion();
			//System.out.println("Fermeture client");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
