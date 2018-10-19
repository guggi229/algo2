package ch.guggisberste.algo.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import ch.guggisberg.stefan.algo.DivideAndConquerable;

public interface DivideConquerableMultiThreadingMuster<T> extends DivideAndConquerable<T> {

	default T divideAndConquer () {

		if (this.isBasic()) return this.baseFun();

		List <? extends DivideAndConquerable <T>>
		subcomponents = this.decompose();

		List <T>
		intermediateResults =
		new ArrayList <T>(subcomponents.size());

		List<FutureTask<Thread>> helperList = new ArrayList<>();


		// Callable<Integer> callableObj = () -> 2+2;

		subcomponents.forEach (subcomponent -> intermediateResults.add (
// Future task?
						
				Callable<T> callableCode = () -> subcomponent.divideAndConquer();
				//Thread t = new Thread(callableCode);
				//t.start();

				));

		helperList.add(t);

		return recombine (intermediateResults);
	}
}
