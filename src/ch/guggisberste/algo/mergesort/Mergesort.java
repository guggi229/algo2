package ch.guggisberste.algo.mergesort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ch.guggisberste.algo.templates.DivideAndConquerable;

public class Mergesort<T> implements DivideAndConquerable<T> {

	@SuppressWarnings("rawtypes")
	private List input = new ArrayList<T>();

	@SuppressWarnings("rawtypes")
	private List aux = new ArrayList<T>();

	private int left;
	private int right;
	private int mid;

	private List<T> result;
	private Mergesort<T> leftpart;
	private Mergesort<T> righhtpart;


	// Recombine indexes
	private int leftIndex;
	private int rightIndex;
	private int auxIndex;

	private Comparator<T> comparator;

	private static int counter=1;


	public Mergesort(List<T> input, List<T> aux, Comparator<T> comparator){
		this.input=input;
		this.left=0;
		this.right=input.size();
		this.mid=input.size()/2;
		this.comparator=comparator;
		System.out.println("Input Data: " +input);
		System.out.println("Konstruktor Durchäufe: " + counter++);
	}

	@Override
	public boolean isBasic() {
		return (input.size()== 1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T baseFun() {
		return (T) input;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends DivideAndConquerable<T>> decompose() {
		leftpart =	new Mergesort<T>(input.subList(0, mid), aux, comparator );
		righhtpart = new Mergesort<T>(input.subList(mid+1, right), aux, comparator);
		result = new ArrayList<>();
		result.add((T) leftpart);
		result.add((T) righhtpart);
		return (List<? extends DivideAndConquerable<T>>) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T recombine(List<T> intermediateResults) {
		while (leftIndex <= mid && rightIndex <= right ) { // l-r- merge left & right
			if (comparator.compare((T) input.get(leftIndex), (T) input.get(rightIndex)) < 0)
				aux.set(auxIndex++,input.get(leftIndex++));// [ i ++];
			else
				aux.set(auxIndex++,input.get(rightIndex++));
		}
		return (T) aux;
	}

	@SuppressWarnings("unchecked")
	public T getSortedList(){
		return (T) aux;
	}
}
