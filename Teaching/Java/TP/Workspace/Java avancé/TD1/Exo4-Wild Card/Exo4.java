import java.util.List;

public class Exo4 {

	public static <T> void f (T x) {
		System.out.println(x);
	}

	public static <T> T g() {
		return null;
	}

	public static <T> T h (List<T> ls) {
		return ls.get(2);
	}

	public static <T> void k (List<T> lt,List<T> ls) {
		lt.add(ls.get(2));
	}

	public static void main (String [] args) {

	}
}
