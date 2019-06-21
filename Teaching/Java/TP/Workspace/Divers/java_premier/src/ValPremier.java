import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ValPremier implements Callable<Long> {

	private int n;
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	boolean estPremier (long n){
		final long max = (long) Math.floor(Math.sqrt(n));
		for(int i=2;i<=max;i++)
			if (n%i == 0) return false;
		return true;
	}
	
	public ValPremier(int n) {
		this.n=n;
	}
	
	@Override
	public Long call() throws Exception {
		if(estPremier((long) this.n))
			return (long) this.n;
		else
			return (long) 0;
	}
	
	public Long sommePremier( long n) {
		Long somme = (long) 0;
		long i=0;
		long test;
		for(int j=0;i<n;j++){
			setN(j);			
			try{
				if((test=call())!=0){
					somme+=test;
					i++;
				}
			}catch(Exception e){}
		}
		return somme;
	}
	
	public Long sommePremierConcur( int concur, long n) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(concur);
		List<Future<Long>> futures = new ArrayList<Future<Long>>();
		Long somme = (long)0;
		
		for(int i=0;i<=n;i++)
			futures.add(pool.submit(new ValPremier(i)));
		
		for(Future<Long> f:futures)
			somme+=f.get();
		
		return somme;
	}
	
	public static void main(String[] args) throws Exception {
		ValPremier val = new ValPremier(11);
		//System.out.println(val.call());
		//System.out.println(val.sommePremier(4));
		
		long d1= System.nanoTime();
		System.out.println(val.sommePremierConcur(22,1000000));
		d1 = System.nanoTime() - d1;
		System.out.println(d1);
		
		long d2= System.nanoTime();
		System.out.println(val.sommePremier(1000000));
		d2 = System.nanoTime() - d2;
		System.out.println(d2);
		
	}
}

