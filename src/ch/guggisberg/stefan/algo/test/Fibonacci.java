package ch.guggisberg.stefan.algo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Fibonacci {
	public static void main(String[] args) {
		int num = 1;
		int out = 0;
		try {
			num = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("first argument must be a whole number");
			System.exit(-1);
		}
		if (num <= 2) {
			out = 1;
		}
		else {
			ExecutorService pool = Executors.newFixedThreadPool(2);
			Callable<Integer> t1 = new FibonacciCallable(num-1);
			Callable<Integer> t2 = new FibonacciCallable(num-2);
			Future<Integer> future1 = pool.submit(t1);
			Future<Integer> future2 = pool.submit(t2);
			try {
				out = future1.get() + future2.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Fibonacci number #" + num + " is " + out);
		System.exit(0);
	}
}