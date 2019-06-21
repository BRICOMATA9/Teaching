public class C2 extends C1{
	public void a(){
		System.out.println("C2");
	}
	
	public static void main (String[] args){
		C0[] A=new C1[50];
		for(int i=0;i<34;i++) A[i]=new C2();
	
	//	C0 b=new C2();
	//	b.a();
	
	}
	
}
