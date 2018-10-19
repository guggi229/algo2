package ch.guggisberg.stefan.helper;

public class TestRun {

	public static void main(String[] args) {
		
		
		ExecutionTimer<Integer> et = new ExecutionTimer<Integer>(() -> new NaturalNumber.FibonacciDnC(m).divideAndConquer());
			System.out.println("DnC F("+n+")\t = "+et.result);
			System.out.println(" time\t = "+et.time+"\n");
	

	}

}
