package es.uniovi.algorithms.complexities_examples;

public class PowerComplexity implements ExampleAlgorithm {

	private long result;
	
	@Override
	public void execute( long times ) {
		long result = 1;
		for (long i = 1; i <= times; i++) {
		    result *= 2;
		    doNothing(times);
		}
		this.result = result;
	}
	
	public long getResult() {
		return this.result;
	}

}
