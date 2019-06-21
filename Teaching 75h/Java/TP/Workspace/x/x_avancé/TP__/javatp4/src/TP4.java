import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;
public class TP4 {
	public static void main(String[] args) {
		//EXO1
		//Question 1
		Stream <String> flux1 = Stream.of("Vive","les","calins");
		//Question 2
		Stream <String> flux2 = Stream.<String>builder().add("Vive").add("les").add("calins").build();
		//Question 3
		ArrayList<String> l = new ArrayList<String>(Arrays.asList("Vive","les","calins"));
		Stream <String> flux3 = l.stream();
		//Question4
		int[] intTab = {1,2,3,4,5,6,7,8,9};
		IntStream intFlux = Arrays.stream(intTab);
		//Question5
		LongStream flux5 = LongStream.generate(()->System.nanoTime()).limit(99);
		//Question6
		BigInteger two = BigInteger.valueOf(2);
		Stream <BigInteger> flux6 = Stream.iterate(BigInteger.ZERO,two::add).limit(4);
		Stream <BigInteger> flux6b = Stream.iterate(BigInteger.ZERO,BigInteger.ONE::add).limit(10000);

		//EXO2
		//Question 1
		
	/*
		flux1.forEach(System.out::print);
		System.out.println();
		flux2.forEach(System.out::print);
		System.out.println();
		flux3.forEach(System.out::print);
		System.out.println();
		intFlux.forEach(System.out::print);
		System.out.println();
		flux5.forEach(System.out::println);
		flux6.forEach(System.out::println);*/
		
		//Question 2		
		
		//.limit(99) ajoutés aux deux derniers stream
		
		//Question 3
		
		Stream<String> flux7 = intFlux.mapToObj(i -> Integer.toString(i));
		//flux7.forEach(System.out::println);	
		
		//Question 4
		
		IntStream flux8 = msbFirst(BigInteger.valueOf(10));
		//flux8.forEach(System.out::println);
		
		//Question 5
		
		IntStream flux9 = flux6.flatMapToInt(i -> msbFirst(i));
		//flux9.forEach(i -> System.out.print((char)i));
		
		//Question 6
		
		Stream<BigInteger> flux10 = flux6b.filter(i -> i.isProbablePrime(100)).limit(1000);
		BigInteger x = flux10.reduce(BigInteger.ZERO,BigInteger::add);
		System.out.println(x);
		
	}
	public static IntStream msbFirst(BigInteger bi){
		IntStream.Builder s;
		if(bi.equals(BigInteger.valueOf(0))){
			return IntStream.builder().add('0').add(',').add(' ').build();
		}
		else if(bi.testBit(bi.bitLength()-1)){
			s = IntStream.builder().add('1');
		}
		else{
			s = IntStream.builder().add('0');
		}
		for(int i=bi.bitLength()-2; i>=0; i--){
			if(bi.testBit(i)){
				s.add('1');
			}
			else {
				s.add('0');
			}
		}
		return s.add(',').add(' ').build();
	}
}
