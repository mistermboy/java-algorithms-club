package es.uniovi.data_structures.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	private Graph<String> stringGraph;
	private Graph<Integer> integerGraph;
	private Graph<Character> charGraph;

	@Before public void setUp() {
		stringGraph = new Graph<String>( 5 );
		integerGraph = new Graph<Integer>( 5 );
		charGraph = new Graph<Character>( 5 );
	}

	@Test public void constructorTest() {
		// Strings...
		assertArrayEquals( new boolean[][] { { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false } },
				stringGraph.getEdges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 } },
				stringGraph.getWeights() );

		// Integers...
		assertArrayEquals( new boolean[][] { { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false } },
				integerGraph.getEdges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 } },
				integerGraph.getWeights() );

		// Characters...
		assertArrayEquals( new boolean[][] { { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false } },
				charGraph.getEdges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 } },
				charGraph.getWeights() );
	}

	@Test public void addNodeTest() {
		// Strings...
		try {
			stringGraph.addContent( "A" );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 1, stringGraph.size() );
		assertEquals( 0, stringGraph.getValueIndex( "A" ) );

		try {
			stringGraph.addContent( "B" );
			stringGraph.addContent( "B" );
			fail( "Expected an Exception to be thrown because A is already in the graph." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Integers...
		try {
			integerGraph.addContent( 1 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 1, integerGraph.size() );
		assertEquals( 0, integerGraph.getValueIndex( 1 ) );

		try {
			integerGraph.addContent( 2 );
			integerGraph.addContent( 2 );
			fail( "Expected an Exception to be thrown because 2 is already in the graph." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Characters...
		try {
			charGraph.addContent( 'a' );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 1, charGraph.size() );
		assertEquals( 0, charGraph.getValueIndex( 'a' ) );

		try {
			charGraph.addContent( 'b' );
			charGraph.addContent( 'b' );
			fail( "Expected an Exception to be thrown because a is already in the graph." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Null objects...
		try {
			stringGraph.addContent( null );
			fail( "Expected an Exception to be thrown because null objects are not allowed in the graph." );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			integerGraph.addContent( null );
			fail( "Expected an Exception to be thrown because null objects are not allowed in the graph." );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			charGraph.addContent( null );
			fail( "Expected an Exception to be thrown because null objects are not allowed in the graph." );
		} catch (Exception e) {
			System.out.println( e );
		}
	}

	@Test public void getNodeTest() {
		// Strings...
		try {
			stringGraph.addContent( "a" );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 0, stringGraph.getValueIndex( "a" ) );
		assertEquals( Graph.INDEX_NOT_FOUND, stringGraph.getValueIndex( "b" ) );

		// Integers...
		try {
			integerGraph.addContent( 1 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 0, integerGraph.getValueIndex( 1 ) );
		assertEquals( Graph.INDEX_NOT_FOUND, integerGraph.getValueIndex( 2 ) );

		// Characters...
		try {
			charGraph.addContent( 'a' );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 0, charGraph.getValueIndex( 'a' ) );
		assertEquals( Graph.INDEX_NOT_FOUND, charGraph.getValueIndex( 'b' ) );
	}

	@Test public void addEdgeAndExistsEdgeTest() {
		// Strings...
		try {
			stringGraph.addContent( "AA" );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			stringGraph.addContent( "AB" );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			stringGraph.addContent( "AC" );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			stringGraph.addContent( "BA" );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			stringGraph.addContent( "BB" );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			assertEquals( false, stringGraph.existsEdge( "AA", "AB" ) );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			stringGraph.addEdge( "AA", "AB", 0.5 );
		} catch (Exception e) {
			System.out.println( e );
		}
		try {
			assertEquals( true, stringGraph.existsEdge( "AA", "AB" ) );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Integers...
		try {
			integerGraph.addContent( 1 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			integerGraph.addContent( 2 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			integerGraph.addContent( 3 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			integerGraph.addContent( 4 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			integerGraph.addContent( 5 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals( false, integerGraph.existsEdge( 1, 2 ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			integerGraph.addEdge( 1, 2, 0.5 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals( true, integerGraph.existsEdge( 1, 2 ) );
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Characters...
		try {
			charGraph.addContent( 'a' );
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		try {
			charGraph.addContent( 'b' );
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		try {
			charGraph.addContent( 'c' );
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			charGraph.addContent( 'd' );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			charGraph.addContent( 'e' );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals( false, charGraph.existsEdge( 'a', 'b' ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			charGraph.addEdge( 'a', 'b', 0.5 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals( true, charGraph.existsEdge( 'a', 'b' ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test public void removeEdgeTest() throws Exception {
		// Strings...
		stringGraph.addContent( "AA" );
		stringGraph.addContent( "AB" );
		stringGraph.addContent( "AC" );
		stringGraph.addContent( "BA" );
		stringGraph.addContent( "BB" );
		stringGraph.addEdge( "AA", "AB", 0.5 );
		stringGraph.addEdge( "AA", "AC", 0.5 );
		assertEquals( true, stringGraph.existsEdge( "AA", "AB" ) );
		assertEquals( true, stringGraph.existsEdge( "AA", "AC" ) );
		stringGraph.removeEdge( "AA", "AB" );
		assertEquals( false, stringGraph.existsEdge( "AA", "AB" ) );
		stringGraph.removeEdge( "AA", "AC" );
		assertEquals( false, stringGraph.existsEdge( "AA", "AC" ) );
		try {
			stringGraph.removeEdge( "AA", "AC" );
			fail( "This edge has already been removed and then it must throw an exception." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Integers...
		integerGraph.addContent( 1 );
		integerGraph.addContent( 2 );
		integerGraph.addContent( 3 );
		integerGraph.addContent( 4 );
		integerGraph.addContent( 5 );
		integerGraph.addEdge( 1, 2, 0.5 );
		integerGraph.addEdge( 1, 3, 0.5 );
		assertEquals( true, integerGraph.existsEdge( 1, 2 ) );
		assertEquals( true, integerGraph.existsEdge( 1, 3 ) );
		integerGraph.removeEdge( 1, 2 );
		assertEquals( false, integerGraph.existsEdge( 1, 2 ) );
		integerGraph.removeEdge( 1, 3 );
		assertEquals( false, integerGraph.existsEdge( 1, 3 ) );
		try {
			integerGraph.removeEdge( 1, 3 );
			fail( "This edge has already been removed and then it must throw an exception." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Characters...
		charGraph.addContent( 'a' );
		charGraph.addContent( 'b' );
		charGraph.addContent( 'c' );
		charGraph.addContent( 'd' );
		charGraph.addContent( 'e' );
		charGraph.addEdge( 'a', 'b', 0.5 );
		charGraph.addEdge( 'a', 'c', 0.5 );
		assertEquals( true, charGraph.existsEdge( 'a', 'b' ) );
		assertEquals( true, charGraph.existsEdge( 'a', 'c' ) );
		charGraph.removeEdge( 'a', 'b' );
		assertEquals( false, charGraph.existsEdge( 'a', 'b' ) );
		charGraph.removeEdge( 'a', 'c' );
		assertEquals( false, charGraph.existsEdge( 'a', 'c' ) );
		try {
			charGraph.removeEdge( 'a', 'c' );
			fail( "This edge has already been removed and then it must throw an exception." );
		} catch (Exception e) {
			System.out.println( e );
		}

	}

	@Test public void traverseGraphTest() throws Exception {
		// Strings...
		stringGraph.addContent( "AA" );
		stringGraph.addContent( "AB" );
		stringGraph.addContent( "AC" );
		stringGraph.addContent( "BA" );
		stringGraph.addContent( "BB" );
		assertEquals( "AA-", stringGraph.traverseGraph( "AA" ) );
		assertEquals( "BA-", stringGraph.traverseGraph( "BA" ) );
		stringGraph.addEdge( "AA", "AB", 0.5 );
		assertEquals( "AA-AB-", stringGraph.traverseGraph( "AA" ) );
		stringGraph.addEdge( "AB", "AC", 0.5 );
		assertEquals( "AA-AB-AC-", stringGraph.traverseGraph( "AA" ) );
		stringGraph.addEdge( "AA", "AC", 0.5 );
		assertEquals( "AA-AB-AC-", stringGraph.traverseGraph( "AA" ) );
		stringGraph.addEdge( "AA", "BB", 0.5 );
		assertEquals( "AA-AB-AC-BB-", stringGraph.traverseGraph( "AA" ) );
		try {
			stringGraph.addContent( "C" );
			fail( "Expected an exception because the graph must be full." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Integers...
		integerGraph.addContent( 1 );
		integerGraph.addContent( 2 );
		integerGraph.addContent( 3 );
		integerGraph.addContent( 4 );
		integerGraph.addContent( 5 );
		assertEquals( "1-", integerGraph.traverseGraph( 1 ) );
		integerGraph.addEdge( 1, 2, 0.5 );
		assertEquals( "1-2-", integerGraph.traverseGraph( 1 ) );
		integerGraph.addEdge( 1, 3, 0.5 );
		assertEquals( "1-2-3-", integerGraph.traverseGraph( 1 ) );
		integerGraph.addEdge( 1, 4, 0.5 );
		assertEquals( "1-2-3-4-", integerGraph.traverseGraph( 1 ) );
		try {
			integerGraph.addContent( 6 );
			fail( "Expected an exception because the graph must be full." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Characters...
		charGraph.addContent( 'a' );
		charGraph.addContent( 'b' );
		charGraph.addContent( 'c' );
		charGraph.addContent( 'd' );
		charGraph.addContent( 'e' );
		charGraph.addEdge( 'b', 'c', 0.5 );
		assertEquals( "a-", charGraph.traverseGraph( 'a' ) );
		assertEquals( "b-c-", charGraph.traverseGraph( 'b' ) );
		try {
			charGraph.addContent( 'f' );
			fail( "Expected an exception because the graph must be full." );
		} catch (Exception e) {
			System.out.println( e );
		}

	}

	@Test public void FloydTest() {
		try {
			stringGraph.addContent( "N1" );
			stringGraph.addContent( "N2" );
			stringGraph.addContent( "N3" );
			stringGraph.addContent( "N4" );
			stringGraph.addContent( "N5" );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 5, stringGraph.size() );
		assertEquals( 0, stringGraph.getValueIndex( "N1" ) );
		assertEquals( 1, stringGraph.getValueIndex( "N2" ) );
		assertEquals( 2, stringGraph.getValueIndex( "N3" ) );
		assertEquals( 3, stringGraph.getValueIndex( "N4" ) );
		assertEquals( 4, stringGraph.getValueIndex( "N5" ) );
		assertArrayEquals( new boolean[][] { { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false },
				{ false, false, false, false, false }, { false, false, false, false, false } },
				stringGraph.getEdges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0 } },
				stringGraph.getWeights() );
		try {
			stringGraph.print();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		try {
			stringGraph.addEdge( "N1", "N2", 3.0 );
			stringGraph.addEdge( "N1", "N3", 4.0 );
			stringGraph.addEdge( "N1", "N5", 8.0 );
			stringGraph.addEdge( "N2", "N5", 5.0 );
			stringGraph.addEdge( "N3", "N5", 3.0 );
			stringGraph.addEdge( "N5", "N4", 7.0 );

		} catch (Exception e) {
			System.out.println( e );
		}
		assertArrayEquals( new boolean[][] { { false, true, true, false, true },
				{ false, false, false, false, true },
				{ false, false, false, false, true }, { false, false, false, false, false },
				{ false, false, false, true, false } }, stringGraph.getEdges() );
		assertArrayEquals(
				new double[][] { { 0.0, 3.0, 4.0, 0.0, 8.0 }, { 0.0, 0.0, 0.0, 0.0, 5.0 },
						{ 0.0, 0.0, 0.0, 0.0, 3.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 7.0, 0.0 } },
				stringGraph.getWeights() );
		try {
			assertEquals( "N1-N2-N5-N4-N3-", stringGraph.traverseGraph( "N1" ) );
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			stringGraph.print();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		stringGraph.computeFloyd( stringGraph.size() );
		assertArrayEquals(
				new int[][] { { -1, -1, -1, 4, 2 }, { -1, -1, -1, 4, -1 }, { -1, -1, -1, 4, -1 },
						{ -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } },
				stringGraph.getP() );
		assertArrayEquals( new double[][] { { 00.0, 03.0, 04.0, 14.0, 07.0 },
				{ Graph.MAX_NUMBER, 00.0, Graph.MAX_NUMBER, 12.0, 05.0 },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, 00.0, 10.0, 03.0 },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, Graph.MAX_NUMBER, 00.0, Graph.MAX_NUMBER },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, Graph.MAX_NUMBER, 07.0, 00.0 } },
				stringGraph.getA() );
		try {
			stringGraph.computeFloyd( stringGraph.size() );
			assertEquals( "N1N5", stringGraph.printFloydPath( "N1", "N5" ) );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Easy integer test.
		try {
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addContent( 4 );
			integerGraph.addContent( 5 );
			integerGraph.addEdge( 1, 2, 1 );
			integerGraph.addEdge( 2, 3, 1 );
			integerGraph.addEdge( 3, 4, 1 );
			integerGraph.addEdge( 4, 5, 4 );
			integerGraph.addEdge( 3, 5, 1 );
		} catch (Exception e) {
			System.out.println( "No repeated nodes are allowed" + e );
		}
		integerGraph.computeFloyd( integerGraph.size() );
		assertEquals( "1235", integerGraph.printFloydPath( 1, 5 ) );
		try {
			integerGraph.addEdge( 1, 5, 1 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		integerGraph.computeFloyd( integerGraph.size() );
		assertEquals( "15", integerGraph.printFloydPath( 1, 5 ) );
	}

	@Test public void getDTest() {
		// Falta implementaci�n
	}

	@Test public void getPDTest() {
		// Falta implementaci�n
	}

	@Test public void getNumberOfReturnNodesWithinCostTest() {
		// Strings...
		try {
			stringGraph.addContent( "A" );
			stringGraph.addContent( "B" );
			stringGraph.addContent( "C" );
			stringGraph.addEdge( "A", "B", 1.0 );
			stringGraph.addEdge( "B", "A", 1.0 );
			stringGraph.addEdge( "B", "C", 2.0 );
			stringGraph.addEdge( "C", "A", 1.0 );
		} catch (Exception e) {
			System.out.println( e );
		}

		try {
			assertEquals( 1, stringGraph.getNumberOfReturnNodesWithinCost( "A", 1 ) );
			assertEquals( 2, stringGraph.getNumberOfReturnNodesWithinCost( "A", 2 ) );
			assertEquals( 3, stringGraph.getNumberOfReturnNodesWithinCost( "A", 4 ) );
			assertEquals( 2, stringGraph.getNumberOfReturnNodesWithinCost( "B", 2 ) );
			assertEquals( 3, stringGraph.getNumberOfReturnNodesWithinCost( "B", 6 ) );
		} catch (Exception e) {
			fail( "Something fail... at the testing Strings" );
			System.out.println( e );
		}

		try {
			assertEquals( 1, stringGraph.getNumberOfReturnNodesWithinCost( "A", -1 ) );
			fail( "An Exception should be thrown as not your're getting this error." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Integers...
		try {
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addEdge( 1, 2, 1.0 );
			integerGraph.addEdge( 2, 1, 1.0 );
			integerGraph.addEdge( 2, 3, 2.0 );
			integerGraph.addEdge( 3, 1, 1.0 );
		} catch (Exception e) {
			System.out.println( e );
		}

		try {
			assertEquals( 1, integerGraph.getNumberOfReturnNodesWithinCost( 1, 1 ) );
			assertEquals( 2, integerGraph.getNumberOfReturnNodesWithinCost( 1, 2 ) );
			assertEquals( 3, integerGraph.getNumberOfReturnNodesWithinCost( 1, 4 ) );
		} catch (Exception e) {
			fail( "Something fail... at the testing Integers" );
			System.out.println( e );
		}

		// Chars...
		try {
			charGraph.addContent( 'A' );
			charGraph.addContent( 'B' );
			charGraph.addContent( 'C' );
			charGraph.addEdge( 'A', 'B', 1.0 );
			charGraph.addEdge( 'B', 'A', 1.0 );
			charGraph.addEdge( 'B', 'C', 2.0 );
			charGraph.addEdge( 'C', 'A', 1.0 );
		} catch (Exception e) {
			System.out.println( e );
		}

		try {
			assertEquals( 1, charGraph.getNumberOfReturnNodesWithinCost( 'A', 1 ) );
			assertEquals( 2, charGraph.getNumberOfReturnNodesWithinCost( 'A', 2 ) );
			assertEquals( 3, charGraph.getNumberOfReturnNodesWithinCost( 'A', 4 ) );
		} catch (Exception e) {
			fail( "Something fail... at the testing Chars" );
			System.out.println( e );
		}
	}

	@Test public void isStronglyConnectedTest() {
		try {
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addContent( 4 );
			integerGraph.addEdge( 1, 2, 1 );
			integerGraph.addEdge( 2, 1, 1 );
			integerGraph.addEdge( 2, 3, 1 );
			integerGraph.addEdge( 1, 4, 1 );
			integerGraph.addEdge( 4, 3, 1 );
			integerGraph.addEdge( 4, 2, 1 );
		} catch (Exception e) {
			System.out.println( e );
		}
		// Up to this moment the node 2 is almost strongly connected one but
		// it's not yet.
		assertEquals( false, integerGraph.isStronglyConnected( 2 ) );
		try {
			// Now, with the new edge 2 is a full strongly connected node.
			integerGraph.addEdge( 3, 2, 1 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals( true, integerGraph.isStronglyConnected( 2 ) );
	}

	@Test public void diametroTest() {
		try {
			integerGraph.addContent( 0 );
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addEdge( 0, 1, 5 );
			integerGraph.addEdge( 1, 2, 2 );
			integerGraph.addEdge( 2, 3, 3 );
			integerGraph.addEdge( 1, 3, 2 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 7, (int) integerGraph.getDiameter() );
	}

	@Test public void diametroDijkstraTest() {
		try {
			integerGraph.addContent( 0 );
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addEdge( 0, 1, 5 );
			integerGraph.addEdge( 1, 2, 2 );
			integerGraph.addEdge( 2, 3, 3 );
			integerGraph.addEdge( 1, 3, 2 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 7, (int) integerGraph.getDiameterDijkstra() );
	}

	@Test public void gradoNodoTest() {
		try {
			integerGraph.addContent( 0 );
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addEdge( 0, 1, 1 );
			integerGraph.addEdge( 1, 2, 1 );
			integerGraph.addEdge( 2, 3, 1 );
			integerGraph.addEdge( 1, 3, 1 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 2, integerGraph.getDegreeOf( 3 ) );
	}

	@Test public void minGradoNodoTest() {
		try {
			integerGraph.addContent( 0 );
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addEdge( 0, 1, 1 );
			integerGraph.addEdge( 1, 2, 1 );
			integerGraph.addEdge( 2, 3, 1 );
			integerGraph.addEdge( 1, 3, 1 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 0, integerGraph.getMinDegree() );
	}

	@Test public void maxGradoNodoTest() {
		try {
			integerGraph.addContent( 0 );
			integerGraph.addContent( 1 );
			integerGraph.addContent( 2 );
			integerGraph.addContent( 3 );
			integerGraph.addEdge( 0, 1, 1 );
			integerGraph.addEdge( 1, 2, 1 );
			integerGraph.addEdge( 2, 3, 1 );
			integerGraph.addEdge( 1, 3, 1 );
		} catch (Exception e) {
			System.out.println( e );
		}
		assertEquals( 2, integerGraph.getMaxDegree() );
	}

}
