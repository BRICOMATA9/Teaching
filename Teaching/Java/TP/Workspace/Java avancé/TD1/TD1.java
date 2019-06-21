import java.util.ArrayList;
import java.util.List;

public class TD1 {

	public <T> T first (List<T> l) {
		return l.get(0);
	}

	public static <T,Y> void removeLast (List<T> l, List<Y> l2) {
		l .remove(l .size()-1);
		l2.remove(l2.size()-1);
	}

	public static void main (String[] args) {
    List<Integer> l = new ArrayList<>();
    List<Number> l2 = new ArrayList<>();
    l.add(5);
    l.add(4);
    l2.add(3);
    //for (Integer i:l) System.out.println(i);
    removeLast(l,l2);
    //for (Integer i:l) System.out.println(i);
	}
}

class Toto<T> {
	T champ;
}
