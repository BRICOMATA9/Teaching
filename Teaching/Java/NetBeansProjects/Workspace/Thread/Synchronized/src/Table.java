public class Table{  
  
	public synchronized void printTable(int n){ 
		for(int i=1;i<=5;i++){  
			try{ 
				System.out.println(n*i); 
				Thread.sleep(1000); 	  
			}catch(Exception e){
				System.out.println("Exception "+e);
			}  
		}  
	}  

	public void print(){
		System.out.println("Aghiles");
	}
} 
