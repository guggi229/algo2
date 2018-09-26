package ch.guggisberg.stefan.algo;

import java.util.ArrayList;
import java.util.List;



public class FibonacciSequence implements DivideAndConquerable<Integer>{

	private Integer n;

	private ArrayList<DivideAndConquerable<Integer>> a = new ArrayList<>();

	public FibonacciSequence(Integer n) {
		this.n = n;
	}

	@Override
	public boolean isBasic() {
		return n == 0 || n==1;
	}

	@Override
	public Integer baseFun() {
		return n;
	}

	@Override
	public List<? extends DivideAndConquerable<Integer>> decompose() {
		a.add(new FibonacciSequence(n-1));
		a.add(new FibonacciSequence(n-2));
		return a;
	}

	@Override
	public Integer recombine(List<Integer> intermediateResults) {
		return intermediateResults.get(0)+intermediateResults.get(1);
	}


}
