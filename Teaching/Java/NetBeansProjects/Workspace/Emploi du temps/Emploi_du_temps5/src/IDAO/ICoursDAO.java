package IDAO;

import java.util.stream.Stream;

import BDD.Cours;

public interface ICoursDAO {

	public Stream<Cours> getAllCours();
	public void ajouterCours(Cours cours) throws Exception;
	public boolean supprimerCours(Cours cours) throws Exception;
	public boolean modifierCours(Cours cours) throws Exception;
}
