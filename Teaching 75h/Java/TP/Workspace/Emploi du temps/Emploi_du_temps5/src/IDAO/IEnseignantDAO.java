package IDAO;

import java.util.stream.Stream;

import BDD.Enseignant;

public interface IEnseignantDAO {

	public Stream<Enseignant> getAllEnseignant();
	public Enseignant getEnseignantById(Integer idPersonne);
	public Stream<Integer> getIdEnseignant();
	public void ajouterEnseignant(Enseignant enseignant) throws Exception;
	public void supprimerEnseignant(Enseignant enseignant) throws Exception;
	public void modifierEnseignant(Enseignant enseignant) throws Exception;
}
