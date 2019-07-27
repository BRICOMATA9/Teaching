package builder;

public abstract class AbstractConverter implements NodeConverter {

	public AbstractConverter() {
		super();
	}

	@Override
	public void ReadProject(String projectName) {
	}

	@Override
	public void ReadSupervisor(String supervisorName) {
	}

	@Override
	public void ReadEmail(String email) {
	}
	
	@Override
	public void ReadDescription(String description) {
	}

}