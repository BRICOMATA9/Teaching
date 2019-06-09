package Exercice_2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Exo4 {

	public static IntStream msb (BigInteger i) {
		int length = i.bitLength();
		int[] tab = new int[length];
		for(int j = 0;j<=length-1;j++)
			tab[length-1-j] =  i.testBit(j)?1:0;
		return 	Arrays.stream(tab);
	}

  public static void main(String[] args) {
	  Stream<BigInteger> pairs = Stream.iterate(BigInteger.ZERO, BigInteger.valueOf(2)::add);
	  Stream<BigInteger> pairs1000 = pairs.limit(4);
	  IntStream bits = pairs1000.flatMapToInt(s -> IntStream.concat(Exo4.msb(s).map(i-> i==0?'0':'1'),IntStream.of(' ')));
	  bits.forEach(x -> {System.out.print((char)x);});
		System.out.println("");
  }
}
