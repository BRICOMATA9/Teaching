package IDAO;

import java.util.stream.Stream;

import BDD.Groupe;

public interface IGroupeDAO {
	
	public Stream<Integer> getIdGroupe();
	public Stream<Groupe> getAllGroupe();
	public Groupe getGroupeById(Integer idGroupe) throws Exception;
	public void ajouterGroupe(Groupe groupe) throws Exception;
	public void supprimerGroupe(Groupe groupe) throws Exception;
	public void modifierGroupe(Groupe groupe) throws Exception;
}
