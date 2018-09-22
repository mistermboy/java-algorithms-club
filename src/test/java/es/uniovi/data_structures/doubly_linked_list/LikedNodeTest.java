package es.uniovi.data_structures.doubly_linked_list;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LikedNodeTest {

	private LinkedNode<Integer> intNode;
	private LinkedNode<String> strNode;
	private LinkedNode<Double> dblNode;

	@Before public void setUp() {
		intNode = new LinkedNode<Integer>( 1 );
		strNode = new LinkedNode<String>( "a" );
		dblNode = new LinkedNode<Double>( 1.0 );
	}
	
	@After public void tearDown() {
		intNode.delete();
		strNode.delete();
		dblNode.delete();
	}

	@Test public void getValueTest() {
		// Integer.
		assertEquals( 1, intNode.getContent().intValue() );

		// String.
		assertEquals( "a", strNode.getContent() );

		// Double.
		assertEquals( 1.0, dblNode.getContent().doubleValue(), 0.00001 );
	}

	@Test public void setValueTest() {
		// Integer.
		assertEquals( 1, intNode.getContent().intValue() );
		intNode.setContent( -2 );
		assertEquals( -2, intNode.getContent().intValue() );

		// String.
		assertEquals( "a", strNode.getContent() );
		strNode.setContent( "b" );
		assertEquals( "b", strNode.getContent() );

		// Double
		assertEquals( 1.0, dblNode.getContent().doubleValue(), 0.00001 );
		dblNode.setContent( -1.1 );
		assertEquals( -1.1, dblNode.getContent().doubleValue(), 0.00001 );
	}

	@Test public void previousNodeTest() {
		// Integer.
		assertNull( intNode.getPreviousNode() );
		intNode.setPreviousNode( new LinkedNode<Integer>( 0 ) );
		assertEquals( 0, intNode.getPreviousNode().getContent().intValue() );

		// Same for String and Double.
	}
	
	@Test public void nextNodeTest() {
		// Integer.
		assertNull( intNode.getNextNode() );
		intNode.setNextNode( new LinkedNode<Integer>( 2 ) );
		assertEquals( 2, intNode.getNextNode().getContent().intValue() );

		// Same for String and Double.
	}

	@Test public void deleteTest() {
		// Integer.
		intNode.delete();
		assertNull( intNode.getPreviousNode() );
		assertNull( intNode.getContent() );
		assertNull( intNode.getNextNode() );

		// String.
		strNode.delete();
		assertNull( strNode.getPreviousNode() );
		assertNull( strNode.getContent() );
		assertNull( strNode.getNextNode() );

		// Double
		dblNode.delete();
		assertNull( dblNode.getPreviousNode() );
		assertNull( dblNode.getContent() );
		assertNull( dblNode.getNextNode() );
	}

	@SuppressWarnings("unused") @Test public void mutabilityTest() {
		// Integer.
		assertEquals( 1, intNode.getContent().intValue() );
		int i = intNode.getContent();
		i = -2;
		assertEquals( 1, intNode.getContent().intValue() );
		LinkedNode<Integer> auxIntNode = intNode;
		assertEquals( 1, auxIntNode.getContent().intValue() );
		auxIntNode.setContent( -2 );
		assertEquals( -2, intNode.getContent().intValue() );

		// String.
		assertEquals( "a", strNode.getContent() );
		String s = strNode.getContent();
		s = "b";
		assertEquals( "a", strNode.getContent() );
		LinkedNode<String> auxStringNode = strNode;
		assertEquals( "a", auxStringNode.getContent() );
		auxStringNode.setContent( "b" );
		assertEquals( "b", strNode.getContent() );

		// The same for doubles...

	}

}
