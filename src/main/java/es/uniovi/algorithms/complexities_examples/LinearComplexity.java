package es.uniovi.algorithms.complexities_examples;

public class LinearComplexity implements ExampleAlgorithm {

	@Override
	public void execute( long times ) {
		for (long i = 0; i <= times; i++) 
			doNothing( i );
	}
}
