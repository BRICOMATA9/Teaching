package IDAO;

import java.util.stream.Stream;

import BDD.Salle;

public interface ISalleDAO {
	
	public Stream<Salle> getAllSalle();
	public Stream<Integer> getIdSalle();
	public Salle getSalleById(Integer idSalle) throws Exception;
	public void ajouterSalle(Salle salle) throws Exception;
	public void supprimerSalle(Salle salle) throws Exception;
	public void modifierSalle(Salle salle) throws Exception;
}
