package Exercice_2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Exo3 {

	public static void map_to_intstream() {

		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(1,2,3));

		IntStream intStream = integers.stream().mapToInt(Integer::intValue);
		Stream<String> stringStream = intStream.mapToObj(String::valueOf);
		//Stream<String> stringStream = intStream.mapToObj(n ->Integer.toString(n));
		System.out.println(Arrays.toString(stringStream.toArray()));
	}

  public static void main(String[] args) {
		map_to_intstream();
  }
}
