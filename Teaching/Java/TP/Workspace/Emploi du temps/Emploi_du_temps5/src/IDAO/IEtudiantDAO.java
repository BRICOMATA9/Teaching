
package IDAO;

import java.util.stream.Stream;

import BDD.Etudiant;

public interface IEtudiantDAO {
    
	public Stream<Etudiant> getAllEtudiant();
	public Etudiant getEtudiantById(Integer idPersonne);
	public Stream<Integer> getIdEtudiant();
	public void ajouterEtudiant(Etudiant etudiant) throws Exception;
	public void supprimerEtudiant(Etudiant etudiant) throws Exception;
	public void modifierEtudiant(Etudiant etudiant) throws Exception;
}
