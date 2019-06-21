package Exercice_1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Exo4 {

	public static void créer_flux(Integer[] integerArr){

		Stream<Integer> streamInteger = Arrays.stream(integerArr);
		System.out.println(Arrays.toString(streamInteger.toArray()));

		//streamInteger.forEach(System.out::println);

	/*	
		Integer[] integerArray = streamInteger.toArray(Integer[]::new);
		Arrays.stream(integerArray).forEach(System.out::println);
	*/

  }

  public static void main(String[] args) {
		Integer[] integerArr = { 2,3,4,4 };
		créer_flux(integerArr);
  }
}
