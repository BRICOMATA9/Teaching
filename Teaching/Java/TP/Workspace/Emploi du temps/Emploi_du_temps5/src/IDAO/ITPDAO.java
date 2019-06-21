package IDAO;

import java.util.stream.Stream;

import BDD.TP;

public interface ITPDAO {

	public Stream<TP> getAllTP();
	public void ajouterTP(TP tp) throws Exception;
	public boolean supprimerTP(TP tp) throws Exception;
	public void modifierTP(TP tp) throws Exception;
	public Stream<TP> getAllSeance();
}
