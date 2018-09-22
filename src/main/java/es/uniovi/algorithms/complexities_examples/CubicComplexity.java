package es.uniovi.algorithms.complexities_examples;

public class CubicComplexity implements ExampleAlgorithm {

	@Override
	public void execute( long times ) {
		for (long i = 0; i <= times; i++)
		    for (long j = 0; j <= times; j++)
		    	for (long k = 0; k <= times; k++)
		    		doNothing( k );
	}

}
