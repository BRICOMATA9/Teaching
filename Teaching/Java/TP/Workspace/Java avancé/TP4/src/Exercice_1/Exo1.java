package Exercice_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exo1 {

	public static void créer_flux(String[] stringArr){

		Stream<String> stream = Stream.of(stringArr);
		//String[] arr = stream.toArray(String[]::new);
		//String[] arr = stream.toArray(size -> new String[size]);
		//Object[] arr = stream.toArray();

		//System.out.println(Arrays.toString(arr));
    stream.limit(10).forEach(System.out::println);
	}

  public static void main(String[] args) {
		String[] stringArr = { "a", "b", "c", "d" };
		créer_flux(stringArr);
  }
}
