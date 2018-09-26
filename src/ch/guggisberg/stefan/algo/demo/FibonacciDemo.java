package ch.guggisberg.stefan.algo.demo;

import ch.guggisberg.stefan.algo.DivideAndConquerable;
import ch.guggisberg.stefan.algo.FibonacciMemoizing;
import ch.guggisberg.stefan.algo.FibonacciSequence;

public class FibonacciDemo {

	public static void main(String[] args) {


		// Input Parameter entgegen nehmen.
		Integer input=0;
		try {
			input = Integer.parseInt(args[0]);
		} catch (NumberFormatException  e) {
		System.out.println("Falsche Eingabe");
		// Programm Sofort beenden.
		System.exit(0);
		}

		// Hier startet der Test
		// ======================

		// Memoizing
		FibonacciMemoizing fm = new FibonacciMemoizing(input);
		System.out.println("Die Berechnung mit Memoizing ergibt: " + fm.findFibonacciValue());

		// Sequenziell

		DivideAndConquerable<Integer> dac = new FibonacciSequence(input);
		System.out.println("Die Berechnung mit Sequenziell ergibt: " + dac.divideAndConquer());
	}


}
