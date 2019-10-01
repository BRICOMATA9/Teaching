public class statique{
	protected static int x=1;
	protected int y=1;
	public static int f(){
		return x;
	}
	
	public static int g(){
		return f();
	}
}
