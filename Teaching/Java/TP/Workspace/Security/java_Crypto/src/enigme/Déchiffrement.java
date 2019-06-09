package enigme;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//java Déchiffrement cryptogramme1.txt

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Déchiffrement {

	public static void main(String[] args) throws Exception {
		InputStreamReader r = new InputStreamReader(new FileInputStream(args[0]), "ISO-8859-15");	
		OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream("Fichier.txt"), "ISO-8859-15");				
		List<Integer> list = new ArrayList<Integer>();

		while (r.ready()) list.add(r.read());

		Map<Integer, Long> map = list.stream()
																.sorted((e1, e2) -> e1.compareTo(e2))
																.collect(groupingBy(identity(), counting()));

        Map<Integer, Long> sorted =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
		
		map.forEach((k,v) -> System.out.println((char)(int)k+","+k+","+v));
		r.close();	
		w.close();
	}
}