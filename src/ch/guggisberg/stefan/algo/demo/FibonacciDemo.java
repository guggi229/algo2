package ch.guggisberg.stefan.algo.demo;




import org.apache.commons.lang3.time.StopWatch;
import ch.guggisberg.stefan.algo.DivideAndConquerable;
import ch.guggisberg.stefan.algo.FibonacciMemoizing;
import ch.guggisberg.stefan.algo.FibonacciMultiThreading;
import ch.guggisberg.stefan.algo.FibonacciSequence;

public class FibonacciDemo {

	public static void main(String[] args) {


		// Input Parameter entgegen nehmen.
		Integer input=1;
		try {
			input = Integer.parseInt(args[0]);
		} catch (NumberFormatException  e) {
			System.out.println("Falsche Eingabe");
			// Programm Sofort beenden.
			System.exit(0);
		}

		StopWatch stopWatch = new StopWatch();

		// Hier startet der Test
		// ======================

		// Memoizing

		stopWatch.start();
		FibonacciMemoizing fm = new FibonacciMemoizing(input);
		Integer fiboMemoizing = fm.findFibonacciValue();
		stopWatch.stop();
		Long timeMemoizing= stopWatch.getNanoTime();
		stopWatch.reset();


		// Sequenziell
		stopWatch.start();
		DivideAndConquerable<Integer> dac = new FibonacciSequence(input);
		Integer fiboSeq = dac.divideAndConquer();
		stopWatch.stop();
		Long timeSeq= stopWatch.getNanoTime();
		stopWatch.reset();


		// MultiThreading
		stopWatch.start();
		FibonacciMultiThreading fmt = new FibonacciMultiThreading(input);
		Integer fibofmt = fmt.findFibonacciValue();
		stopWatch.stop();
		Long timefmt= stopWatch.getNanoTime();
		stopWatch.reset();



		// Anzeige
		// =======

		System.out.println("Auswertung Ihrer Zahl:");
		System.out.println("Fibonacci Position : n = " +input);
		System.out.println("Berechnung mit einer Sequenzieller Methode: " + fiboSeq + " Benötigte Zeit[ns]: " + timeSeq);
		System.out.println("Berechnung mit einer Memoizing Methode: " + fiboMemoizing + " Benötigte Zeit[ns]: " + timeMemoizing);
		System.out.println("Berechnung mit einer MultiThreading Methode: " + fibofmt + " Benötigte Zeit[ns]: " + timefmt);

		System.out.println();
		stopWatch.reset();
		// Ab wann ist welche Methode besser?
		for (Integer n=2;  n<25; n++ ) {
			stopWatch.start();
			FibonacciMemoizing fmem = new FibonacciMemoizing(n);
			Integer fNumberMem = fmem.findFibonacciValue();
			stopWatch.stop();
			Long timeMem= stopWatch.getNanoTime();
			stopWatch.reset();

			stopWatch.start();
			DivideAndConquerable<Integer> fs = new FibonacciSequence(n);
			Integer fNumberSeq = fs.divideAndConquer();
			stopWatch.stop();
			Long timeSeqe= stopWatch.getNanoTime();
			stopWatch.reset();

			stopWatch.start();
			FibonacciMultiThreading fMulti = new FibonacciMultiThreading(n);
			Integer fNumberMulti = fMulti.findFibonacciValue();
			stopWatch.stop();
			Long timeMulti= stopWatch.getNanoTime();
			stopWatch.reset();

			System.out.println("************************************************************");
			System.out.println("Fibonacci Position n = " + n +" wird sequenziell in " + timeSeqe + "[ns] gefunden und mit Memoizig in " + timeMem + "[ns]"+  ",mit MultiThreading " + timeMulti+" Wert ist :" + fNumberMem ) ;

			if (timeMem<timeSeqe) System.out.println("Methode Memoizing ist schneller!");
			else if (timeMem.equals(timeSeqe)) System.out.println("Beide waren geleich schnell! ");
			else System.out.println("Methode Sequenziell ist schneller!");
		}

		System.out.println();
		stopWatch.reset();
		// Ab wann ist welche Methode besser?
		for (Integer n=2;  n<25; n++ ) {
			stopWatch.start();
			FibonacciMemoizing fmem = new FibonacciMemoizing(n);
			Integer fNumberMem = fmem.findFibonacciValue();
			stopWatch.stop();
			Long timeMem= stopWatch.getNanoTime();
			stopWatch.reset();

			stopWatch.start();
			FibonacciMultiThreading fMulti = new FibonacciMultiThreading(n);
			Integer fNumberMulti = fMulti.findFibonacciValue();
			stopWatch.stop();
			Long timeMulti= stopWatch.getNanoTime();
			stopWatch.reset();

			stopWatch.start();
			DivideAndConquerable<Integer> fs = new FibonacciSequence(n);
			Integer fNumberSeq = fs.divideAndConquer();
			stopWatch.stop();
			Long timeSeqe= stopWatch.getNanoTime();
			stopWatch.reset();

			// CSV Textausgabe
			System.out.println( n +" ; " + timeSeqe + "; " + timeMem  + ";" +timeMulti + " ; " + fNumberMem) ;


		}

	}
}
