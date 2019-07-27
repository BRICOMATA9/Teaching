public class ClassTestException {

	public void test1(int x) throws ErreurValeurNegative {
		if (x<0) throw new ErreurValeurNegative();
	}
	
	public void test2(int y) {
		boolean b=false;
		while(!b){
			try {
				 if (y<0) throw new ErreurValeurNegative();
				 b=true;
			 }
			catch(Exception e) {
				System.out.println(e);	 
			}
		 }
	}
}
