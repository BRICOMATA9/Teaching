package Modèle;
//Exception fond existant
public class FondExistant extends Exception {
	public FondExistant() {
		System.out.println("Le fond existe déjà");
	}

}
