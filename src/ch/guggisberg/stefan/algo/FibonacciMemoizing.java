package ch.guggisberg.stefan.algo;

import java.util.ArrayList;
import java.util.HashMap;

public class FibonacciMemoizing implements DivideAndConquerableMemoizing<Integer> {


	private ArrayList<DivideAndConquerable<HashMap<Integer, Integer>>> a = new ArrayList<>();

	static private HashMap<Integer, Integer> fibonacci = new HashMap<>();
	private Integer n;

	public FibonacciMemoizing(int number) {
		this.n=number;
		}

	public Integer findFibonacciValue() {

		if (isBasic()) {
			return n;
		}
		else if (numberAlreadyExists()) {
			return fibonacci.get(n);
		}
		else {
			Integer fibonacciValue = new FibonacciMemoizing(n - 2).findFibonacciValue()+new FibonacciMemoizing(n - 1).findFibonacciValue();
			fibonacci.put(n, fibonacciValue);
			return fibonacciValue;
		}
	}

	@Override
	public boolean isBasic() {
		return n == 0 || n==1;
	}

	@Override
	public boolean numberAlreadyExists() {
		return fibonacci.containsKey(n);		
	}

}