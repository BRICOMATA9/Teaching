package adapter.TestAdapter;

public class Adapter implements Target
{
	private Adaptee delegate;

	public Adapter() {
		delegate = new Adaptee();
	}

	public void request() {
		delegate.delegatedRequest();
	}
}
