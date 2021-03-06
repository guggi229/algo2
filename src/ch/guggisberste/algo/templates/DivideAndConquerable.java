package ch.guggisberste.algo.templates;


import java.util.List ;
import java.util.ArrayList ;
/**
 * Dieses Interface stellt das Template von Divide and Conquer dar um die Fibonacci Zahlen zu berechnen.
 *
 *
 *
 * @author guggisberste
 *
 * @param <OutputType> Ist die Position der zu suchender Fibonacci Zahl
 */
public interface DivideAndConquerable <OutputType> {

	boolean isBasic();

	OutputType baseFun();

	List <? extends DivideAndConquerable <OutputType>> decompose();

	OutputType recombine (List<OutputType> intermediateResults) ;

	default List <? extends DivideAndConquerable <OutputType>> stump () {
		return new	ArrayList <DivideAndConquerable <OutputType>>(0);
	}

	default OutputType divideAndConquer () {

		if (this.isBasic()) return this.baseFun();

		List <? extends DivideAndConquerable <OutputType>>
		subcomponents = this.decompose();

		List <OutputType>
		intermediateResults =
		new ArrayList <OutputType>(subcomponents.size());

		subcomponents.forEach (subcomponent -> intermediateResults.add (subcomponent.divideAndConquer()));
		return recombine (intermediateResults);
	}
}