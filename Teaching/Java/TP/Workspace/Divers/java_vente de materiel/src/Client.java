
public class Client {
private String nom, adresse;
//constructeur
public Client(String nom,String adresse){
	this.nom=nom;
	this.adresse=adresse;
}
//accesseurs
public String getNom(){
	return nom;
}

public String getAdresse(){
	return adresse;
}

public void setNom(String nom){
	this.nom=nom;
}
public void setAdresse(String adresse){
	this.adresse=adresse;
}

public String toString(){
	return "Nom: "+nom+" Adresse: "+adresse;
}
}
