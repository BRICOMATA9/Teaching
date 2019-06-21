public class TestAdapter
{
	public static void main(String[] args) {
		Target client = new Adapter();
		client.request();
	}
}
