package Modèle;
//exception fond inexistant
public class FondInexistant extends Exception{
	public FondInexistant() {
		System.out.println("Le fond demandé n'existe pas");
	}

}
