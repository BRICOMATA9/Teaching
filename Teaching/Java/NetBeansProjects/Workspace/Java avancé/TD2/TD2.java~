import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

abstract class Domain <T extends Comparable <T>> implements Set<T>, Comparable <Domain<T>> {

	public T max (Collection<? extends T> coll) {
		T candidate = coll.iterator().next();
		for (T elt:coll) {
			if (candidate.compareTo(elt)<0) candidate=elt;
		}
		return candidate;
	}

	@Override
	public int compareTo(Domain<T> other) {
		return max(this).compareTo(max(other));
	}
}

class C {}
class B extends C {}
class A extends B {}

class Pippo <T> {
	public T f (List<? extends T> sc) {
		return sc.get(0);
	}
}

class App {
	public static void main (String[] args){
		Pippo<C> pc = new Pippo<>();
		Pippo<A> pa = new Pippo<>();
		List<B> ls = new ArrayList<>();
		C c = pc.f(ls);
		A a = pa.f(ls); //NON
		
	}
}








