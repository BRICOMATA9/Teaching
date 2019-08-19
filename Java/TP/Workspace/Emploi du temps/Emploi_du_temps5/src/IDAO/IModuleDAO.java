package IDAO;

import java.util.stream.Stream;

import BDD.Module;

public interface IModuleDAO {

	public Module getModuleById(String idModule);
	public Stream<Module> getAllModule();
	public Stream<String> getIdModule();
	public void ajouterModule(Module module) throws Exception;
	public void supprimerModule(Module module) throws Exception;
	public void modifierModule(Module module) throws Exception;
}
