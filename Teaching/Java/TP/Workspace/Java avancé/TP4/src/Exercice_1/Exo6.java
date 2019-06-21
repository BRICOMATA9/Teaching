package Exercice_1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.LongStream;
import java.math.BigInteger;

public class Exo6 {

	public static void créer_flux() {
		Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
		BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
		System.out.println(Arrays.toString(bigIntArr));
  }

  public static void main(String[] args) {
		créer_flux();
  }
}
