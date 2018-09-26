package ch.guggisberg.stefan.algo;

import java.util.HashMap;

public class FibonacciMemoizing {

	  private HashMap<Integer, Integer> map;

	  public FibonacciMemoizing() {
	    map = new HashMap<>();
	  }

	  public int findFibonacciValue(int number) {
	    if (number == 0 || number == 1) {
	      return number;
	    }
	    else if (map.containsKey(number)) {
	      return map.get(number);
	    }
	    else {
	      int fibonacciValue = findFibonacciValue(number - 2) + findFibonacciValue(number - 1);
	      map.put(number, fibonacciValue);
	      return fibonacciValue;
	    }
	  }
	}