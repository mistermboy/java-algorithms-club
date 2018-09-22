package es.uniovi.algorithms.complexities_examples;

import java.lang.reflect.Method;

public class TestBench implements ExampleAlgorithm {

	public static void main(String[] args) { 
		new TestBench().execute( 99 );
	}
	
	/**
     * @param fileName
     *            String, output file name, example: quadratic.txt
     * @param algorithmName
     *            String, the name of the algorithm to test.
     * @param startN
     *            Integer(int), the iteration where the algorithm will start.
     * @param endN
     *            Integer(int), the iteration where the algorithm will end.
     * @param repetitions
     *            Integer(int), the number of times the experiment must be
     *            repeated.
     * @throws IOException
     *             if there's any problem while writing and or creating the
     *             file.
     */
    private static void test(String path, String classTo, String algorithmName, int startN, int endN,
	    int repetitions) {
	int i = startN;
	int j = repetitions;
	long result;
	long mean = 0;
	while (i <= endN) {
		while (j > 0) {
		long before = System.currentTimeMillis();
		testAlgorithm(path, classTo, algorithmName, i);
		long after = System.currentTimeMillis();
		result = (after - before);
		mean = (mean + result) / 2;
		System.out.println("TIME SPENT... " + result + "ms");
		j = j - 1;
	    }
	    j = repetitions;
	    mean = 0;
	    result = 0;
	    i = i + 1;
	}
    }
	
	/**
	 * It's used to execute an algorithm from the Algorithms class. It can be
	 * used to execute any method from any class.
	 * 
	 * @param String className, the name of the class the method you want to
	 *            execute is placed.
	 * @param String methodName, the name of the method you want to test.
	 * @param int n.
	 */
	private static void testAlgorithm( String path, String className, String methodName, int n ) {
		Class<?> myClass = null;
		Object myObject = null;
		try {
			myClass = Class.forName( path + className );
			myObject = myClass.newInstance();
		} catch (Exception e) {
			System.err.println( "Error loading the class " + className );
			System.out.println( e.toString() );
		}
		try {
			Class<?>[] params = new Class[1];
			params[0] = Long.TYPE;
			Method m = myClass.getMethod( methodName, params );
			m.invoke( myObject, n );
		} catch (Exception e) {
			System.err.println( "Error loading the method" + methodName );
			System.out.println( e.toString() );
		}
	}

	@Override
	public void execute( long times ) {
		TestBench.test("es.uniovi.algorithms.complexities_examples.", "LinearComplexity", "execute", START_N,
				FINAL_N, SAMPLES);
	}
}
