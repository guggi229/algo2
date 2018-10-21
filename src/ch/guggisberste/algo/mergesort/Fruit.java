package ch.guggisberste.algo.mergesort;

public class Fruit implements Comparable<Fruit> {

	private String name;
	private int gewicht;

	public Fruit (String name, int gewicht){
		this.name=name;
		this.gewicht = gewicht;

	}

	@Override
	public int compareTo(Fruit o) {
		return this.gewicht - o.gewicht;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}


}
