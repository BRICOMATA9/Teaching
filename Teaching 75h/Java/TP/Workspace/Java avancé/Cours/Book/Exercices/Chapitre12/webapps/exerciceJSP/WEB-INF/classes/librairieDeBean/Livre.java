/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Exemples Chapitre 12 : Un composant JavaBean 
#	Exercice 12.7 
#	Fichier : Livre.java
#	Class : Livre
*/
package librairieDeBean ;
import java.io.Serializable ;
public class Livre implements java.io.Serializable {


	private String titre;
	private String categorie ;
	private String isbn ;
	private String nomAuteur ;
	private String prenomAuteur ;
	private String code ;

	
	
  
	public void setTitre (String valeur) {
		titre = valeur ;
	
        }
	public void setCategorie (String valeur) {
		categorie = valeur;
	}

	public void setIsbn (String valeur) {
		isbn =valeur;
	}

	public void setNomAuteur (String valeur) {
		nomAuteur =valeur;
	}

	public void setPrenomAuteur (String valeur) {
		prenomAuteur =valeur;
	}
	


	public String getTitre () {
		return titre;
	}

	public String getCategorie () {
		return categorie;
	}

	public String getIsbn () {
		return isbn;
	}
 
	public String getNomAuteur () {
		return nomAuteur;
	}

	public String getPrenomAuteur () {
		return prenomAuteur;
	}

	public String getCode() {
		code= setCode ();
		return code;
	}


	private String setCode () {
		String debutNom;
		String debutPrenom;
		String debutCategorie;
		int longueurIsbn;
		String finIsbn;

		debutNom=nomAuteur.substring(0,2);
		debutPrenom=prenomAuteur.substring(0,2);
		debutCategorie=categorie.substring(0,2);
		longueurIsbn=isbn.length();
		finIsbn=isbn.substring((longueurIsbn-2),longueurIsbn);
		return debutNom+debutPrenom+debutCategorie+finIsbn;

	}
	
	

}
