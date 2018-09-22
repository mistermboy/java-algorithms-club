package es.uniovi.algorithms.complexities_examples;

public class LogarithmicComplexity implements ExampleAlgorithm {

	@Override
	public void execute( long times ) {
		for (long i = times; i > 0; i = i / 2) {
		    doNothing(i);
		}
	}

}
