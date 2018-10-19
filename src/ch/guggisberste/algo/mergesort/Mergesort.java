package ch.guggisberste.algo.mergesort;

import java.util.ArrayList;

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

	public Mergesort(List<T> input, List<T> aux, int left, int right){
		this.input=input;
		this.left=left;
		this.right=right;
		this.mid=input.size()/2;
	}

	@Override
	public boolean isBasic() {
		if (input.size()== 1){
			return true;
		}
		return false;
	}

	@Override
	public T baseFun() {
	if ()

		return ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends DivideAndConquerable<T>> decompose() {
		new Mergesort<T>(input, aux, left, mid );
		new Mergesort<T>(input, aux,  mid+1, right);
		return null;
	}

	@Override
	public T recombine(List<T> intermediateResults) {
		// TODO Auto-generated method stub
		return null;
	}


}
