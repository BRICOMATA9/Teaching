public class Exo2 {
	
	public static void main (String[] args) {
		A<? extends X> a = new B<Y1>();
		B<Y1> b;
		C<X> c;
		C<? super Y2> c1;
		C<? extends Y2> c2;
	}
}
