package Exercice_3;

public class Main {

/*	public static void dispatch(O o) {
		if (o instanceof A) ((A)o).f(); 
		 else if (o instanceof B) ((B)o).f(); 
		  else if (o instanceof C) ((C)o).f(); 
		//o.f();
	}*/

	public static void main(String[] args) {
		//dispatch(new C());
		B a = new C();
		a.f();	
}

}
