package es.uniovi.algorithms.complexities_examples;

public class QuadraticComplexity implements ExampleAlgorithm {

	@Override
	public void execute( long times ) {
		for (long i = 0; i <= times; i++)
		    for (long j = 0; j <= times; j++)
		    	doNothing( i );
	}

}
