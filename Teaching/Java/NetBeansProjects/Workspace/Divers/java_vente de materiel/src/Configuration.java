
public class Configuration {
private Client proprietaire;
private ComposantMateriel materiel;
private ComposantLogiciel logiciel;

// constructeur

public Configuration(Client proprietaire, ComposantMateriel materiel, ComposantLogiciel logiciel){
	this.proprietaire=proprietaire;
	this.materiel=new ComposantMateriel(materiel.getFrequence(), materiel.getMemoire(), materiel.getDisqueDur());
	//this.materiel=materiel;
	this.logiciel=new ComposantLogiciel(logiciel);
	//this.logiciel=logiciel;
}

public Client getProprietaire() {
	return proprietaire;
}

public void setProprietaire(Client proprietaire) {
	this.proprietaire = proprietaire;
}

public ComposantMateriel getMateriel() {
	return materiel;
}

public void setMateriel(ComposantMateriel materiel) {
	this.materiel = materiel;
}

public ComposantLogiciel getLogiciel() {
	return logiciel;
}

public void setLogiciel(ComposantLogiciel logiciel) {
	this.logiciel = logiciel;
}

public double getPrix(){
	return getMateriel().getPrix()+getLogiciel().getPrix();
	
}

public String toString(){
	return this.proprietaire.toString()+"\n"+this.materiel.toString()+"\n"+this.logiciel.toString();
	
}

public double prixModification(double frequence, int memoire, int disqueDur){
	ComposantMateriel tmpMat=new ComposantMateriel(frequence,memoire,disqueDur);
	//tmpMat.lirePrix();
	Configuration tmpConf=new Configuration(proprietaire,tmpMat,logiciel);
	tmpConf.getMateriel().lirePrix();
	tmpConf.getLogiciel().setPrix(logiciel.getPrix());
	return tmpConf.getPrix()-this.getPrix();
}

public static void main(String[] args){
	Client C=new Client("NomClient","AdresseClient");
	ComposantMateriel tmpMat=new ComposantMateriel(1.8,256,80);
	
	//tmpMat.lirePrix();
	ComposantLogiciel tmpLog=new ComposantLogiciel("Linux",false,false);
	//tmpLog.lirePrix();
	Configuration pc=new Configuration(C,tmpMat,tmpLog);
	pc.getMateriel().lirePrix();
	pc.getLogiciel().lirePrix();
	
	System.out.println(pc);
	System.out.println("\nPrix Total= "+pc.getPrix());
	
	System.out.println("-------------------------------------");
	double difference=pc.prixModification(1.8,512,120);
	System.out.println("Difference= "+difference);
	
	System.out.println("\nNouvelle configuration:\n");
	System.out.println("-------------------------\n");
	System.out.println(pc+"\nPrix Total= "+(pc.getPrix()+difference));
}

}
