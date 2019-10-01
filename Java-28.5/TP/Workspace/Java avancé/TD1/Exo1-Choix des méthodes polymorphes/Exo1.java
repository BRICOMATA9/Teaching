public class Exo1 {

	public static void main(String[] args) {
		A aa = new A();
		B bb = new B();
		A ac = new C();
		A ab = new B();
		B bc = new C();

		aa.f(ac);
		bb.f(ac);
		ab.f(bb);
		ac.f(bc);
	}
}
