package ch.guggisberg.stefan.algo;

public class FibonacciMultiThreading  {

	// Bestimmt wieviele CPUs die Maschine hat;
	private final int cores = Runtime.getRuntime().availableProcessors();

	
	
	
	public int countCPUs (){
		return cores;
	}

}
