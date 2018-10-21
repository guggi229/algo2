package ch.guggisberste.algo.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergesortDemo {

	public static void main(String[] args) {


		// Objekte fürs Sortieren erstellen
		// =================================

		Fruit a = new Fruit("Banana", 40);
		Fruit b = new Fruit("Apfel", 43);
		Fruit c = new Fruit("Erdberen", 22);
		Fruit d = new Fruit("Kokos", 53);
		Fruit e = new Fruit("Trauben", 87);
		Fruit f = new Fruit("Tomaten", 9);
		Fruit g = new Fruit("Feigen", 34);
		Fruit h = new Fruit("Himbeeren", 12);

		List<Fruit> fruits = new ArrayList<>();

		fruits.add(a);
		fruits.add(b);
		fruits.add(c);
		fruits.add(d);
		fruits.add(e);
		fruits.add(f);
		fruits.add(g);
		fruits.add(h);

		List<Fruit> aux = new ArrayList<>();
		Mergesort<Fruit> ms = new Mergesort<>(fruits, aux, (f1,f2) -> { return f1.getGewicht()-f2.getGewicht(); } );

		ms.getSortedList();

		for (Fruit fruit : aux) {
			System.out.println(fruit.getGewicht());
		}

	}

}
