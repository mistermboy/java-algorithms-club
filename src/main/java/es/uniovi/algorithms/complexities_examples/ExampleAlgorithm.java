package es.uniovi.algorithms.complexities_examples;

public interface ExampleAlgorithm {

	static final int SLEEP_TIME = 2;
	static final int SAMPLES = 3;
	static final int START_N = 100;
	static final int FINAL_N = 300;

	public default void doNothing( long time ) {
		long endTime = System.currentTimeMillis() + SLEEP_TIME;
		while (System.currentTimeMillis() < endTime) {
			// do nothing.
		}
	}
	
	public void execute( long times );

}
