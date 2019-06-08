package bdd;

import java.util.Date;

public class Personne {

	protected Integer idPersonne;
	protected String nom;
	protected String prenom;
	private String login;
	private String mdp;
	
	public Integer getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Integer idEtudiant) {
		this.idPersonne = idEtudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
