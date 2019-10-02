import java.util.List;
import java.util.ArrayList;

public class Exo5 {

	public static <T> T f (List<? super T> ls) {
		T t=null;
		//getClass().getName()
		return t;
	}

	public static <T> void g (List<? super T> lt,List<? extends T> ls){}
	
	public static <S,T> void h (List<T> lt, List<S> ls) {}

	public static void main (String[] args) {
		List<     A     > laa = new ArrayList<A>();
		List<     B     > lbb = new ArrayList<B>();
		List<     C     > lcc = new ArrayList<C>();
		List<? extends A> lac = new ArrayList<C>();
		List<? extends B> lbc = new ArrayList<C>();
		List<? super   B> lba = new ArrayList<A>();
		
		A a=f(lbb);
		//B b=f(lbc);
		//h(lbc,lba);
		//g(lbc,lba);
		g(laa,lac);
	}
}
