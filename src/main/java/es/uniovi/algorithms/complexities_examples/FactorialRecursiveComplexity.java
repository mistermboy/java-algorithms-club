package es.uniovi.algorithms.complexities_examples;

public class FactorialRecursiveComplexity implements ExampleAlgorithm {

	private long result;
	
	@Override
	public void execute( long times ) {
		this.result = executeRecursion( times );
	}
	
	private long executeRecursion( long times ) {
		if (times == 0)
		    return 1;
		else
		    return times * executeRecursion(times - 1);
	}
	
	public long getResult() {
		return this.result;
	}

}
