package Exercice_1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exo1 {

	public static void créer_flux(){
		String[] stringArr = { "a", "b", "c", "d" };
		Stream<String> stream = Stream.of(stringArr);
		//String[] arr = stream.toArray(String[]::new);
		String[] arr = stream.toArray(size -> new String[size]);
		//Object[] arr = stream.toArray();

		System.out.println(Arrays.toString(arr));
		//stream.limit(10).forEach(System.out::println);
	}
		public static void exo (){
			//LongStream s = LongStream.generate(System::nanoTime);
		  	IntStream entiers = IntStream.iterate(0,x -> x+1);
		  	//Stream<BigInteger> pairs = Stream.iterate(BigInteger.ZERO, x -> BigInteger.valueOf(x).add(2)); 
		  	Stream<BigInteger> pairs = Stream.iterate(BigInteger.ZERO, BigInteger.valueOf(2)::add);
		  	Stream<BigInteger> pairs1000 = pairs.limit(1000);
		  	//pairs1000.forEach(System.out::println);
		  	pairs1000.forEach(x -> {System.out.print(x+" ");});
		  	//entiers.limit(100).mapToObj(String::valueOf).forEach(System.out::println);
		  	entiers.map(x -> x*3).limit(100).mapToObj(String::valueOf).forEach(System.out::println);
		  	
		  	
		}
		
		public static IntStream msb (BigInteger i) {
			int length = i.bitLength();
			int[] tab = new int[length];
			for(int j = 0;j<=length-1;j--)
				tab[length-1-j] =  i.testBit(j)?1:0;
			return 	Arrays.stream(tab);
			
		}

  public static void main(String[] args) {
/*	  Stream<BigInteger> pairs = Stream.iterate(BigInteger.ZERO, BigInteger.valueOf(2)::add);
	  //IntStream bits = pairs.flatMapToInt(Exo1::msb);
	  Stream<BigInteger> pairs1000 = pairs.limit(1000);
	  //pairs1000.forEach(System.out::println);
	  IntStream bits = pairs1000.flatMapToInt(s -> IntStream.concat(Exo1.msb(s).map(i-> {if (i==0)return '0';else return '1';}),IntStream.of(' ')));
	  //IntStream bits = pairs1000.flatMapToInt(s -> IntStream.concat(Exo1.msb(s).map(i-> i==0?'0':'1'),IntStream.of(' ')));
	  //bits.forEach(x -> {System.out.println((char)x);});*/
	  
	  
	  Stream<BigInteger> impairs = Stream.iterate(BigInteger.ONE, BigInteger.valueOf(200000)::add);
	  Stream<BigInteger> premiers = impairs.filter(x-> x.isProbablePrime(20)).limit(1000);
	  //BigInteger somme = premiers.reduce(BigInteger.ZERO,BigInteger::add);
	  premiers.forEach(System.out::println);
	  	

	  
  }
}