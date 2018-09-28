package ch.guggisberg.stefan.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ch.guggisberg.stefan.algo.test.FibonacciCallable;

public class FibonacciMultiThreading implements DivideAndConquerableMultiThreading<Integer> {

	// Bestimmt wieviele CPUs die Maschine hat;
	private static final int CORES = Runtime.getRuntime().availableProcessors();
	private Integer n;
	private static List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
	private static ExecutorService pool = Executors.newFixedThreadPool(CORES);

	public FibonacciMultiThreading(Integer n){
		this.n = n;
	}

	public Integer findFibonacciValue(){

		int out = 0;

		if (isBasic()) {
			return n;
		}


		Callable<Integer> t1 = new FibonacciCallable(n-1);
		Callable<Integer> t2 = new FibonacciCallable(n-2);
		Future<Integer> future1 = pool.submit(t1);
		Future<Integer> future2 = pool.submit(t2);
		try {
			out = future1.get() + future2.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return out;
	}


	public static int countCPUs (){
		return CORES;
	}

	@Override
	public boolean isBasic() {
		return n == 0 || n==1;
	}
}
