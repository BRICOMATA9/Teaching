package IDAO;

import java.util.stream.Stream;

import BDD.Batiment;

public interface IBatimentDAO {

	public Stream<Batiment> getAllBatiment();
	public Stream<Integer> getIdBatiment();
	public Batiment getBatimentById(Integer idBatiment) throws Exception;
	public void ajouterBatiment(Batiment batiment) throws Exception;
	public void supprimerBatiment(Batiment batiment) throws Exception;
	public void modifierBatiment(Batiment batiment) throws Exception;
	
}
