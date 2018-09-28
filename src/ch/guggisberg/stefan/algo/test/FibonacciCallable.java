package ch.guggisberg.stefan.algo.test;

import java.util.concurrent.Callable;

public  class FibonacciCallable implements Callable<Integer> {
	private Integer num;
	public FibonacciCallable(Integer num) {
		this.num = num;
	}
	public Integer call() {
		return calc(num);
	}
	public Integer calc(Integer num) {
		if (num <= 2)
			return 1;
		return calc(num-1)+calc(num-2);
	}
}

