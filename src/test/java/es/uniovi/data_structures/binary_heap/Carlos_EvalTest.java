package es.uniovi.data_structures.binary_heap;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.data_structures.bynary_heap.BinaryHeap;

public class Carlos_EvalTest {

	@Test public void test_sort_order_A() {

		Integer[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>( input );

		String result = "";

		// print elements in sorted order
		while (!heap.isEmpty()) {
			int x = heap.getHighestPriorityElement();
			result += x;
		}

		assertEquals( result, "12345678910" );
	}

	@Test public void test_sort_order_B() {

		BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
		heap.add( 2 );
		heap.add( 5 );
		heap.add( 1 );

		String result = "";

		// print elements in sorted order
		while (!heap.isEmpty()) {
			int x = heap.getHighestPriorityElement();
			result += x;
		}

		assertEquals( result, "125" );
	}

}
