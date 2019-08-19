/**
 * This adapts the Adaptee so the client
 * may use it.
 */

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
