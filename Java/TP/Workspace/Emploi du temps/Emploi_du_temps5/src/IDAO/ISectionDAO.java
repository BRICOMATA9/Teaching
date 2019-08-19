package IDAO;

import java.util.stream.Stream;

import BDD.Section;

public interface ISectionDAO {

	public Stream<Section> getAllSection();
	public Stream<Integer> getIdSection();
	public Section getSectionById(Integer idSection) throws Exception;
	public void ajouterSection(Section section) throws Exception;
	public boolean supprimerSection(Section Section) throws Exception;
	public void modifierSection(Section section) throws Exception;
}
