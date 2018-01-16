package pruefung;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("Lenovo");
		array.add("Apple");
		array.add("HP");
		array.add("Asus");
		array.add("Acer");
		array.add("Acer");

		
		
		// Sorted: Sortiert nach String-Länge (klein nach gross)
		// Limit: Limitiert auf 2 Elemente
		// Collect: Gibt neue Liste aus
		// forEach: Gibt neue Liste auf Konsole aus
		array.stream()
		// Filter: Nur Anfangsbuchstabe 'A'
		.filter(s -> s.charAt(0) == 'A')
		//Löscht Duplikate
		.distinct()
		.sorted(Comparator.comparing(s -> s.length()))
		.limit(2)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		

	}
}
