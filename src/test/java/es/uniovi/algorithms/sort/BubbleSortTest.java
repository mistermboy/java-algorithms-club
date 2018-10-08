package es.uniovi.algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

	private Integer[] intArr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
			sortIntArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	private String[] strArr = { "d", "c", "b", "a" },
			sortStrArr = { "a", "b", "c", "d" };

	private Double[] dblArr = { 1.9, 2.6, Double.MAX_VALUE, 0.00004, Double.MIN_VALUE },
			sortDblArr = { Double.MIN_VALUE, 0.00004, 1.9, 2.6, Double.MAX_VALUE };

	@Test public void integerSortTest() {
		BubbleSort.sort( intArr );
		assertArrayEquals( sortIntArr, intArr );
	}

	@Test public void stringSortTest() {
		BubbleSort.sort( strArr );
		assertArrayEquals( sortStrArr, strArr );
	}
	
	@Test public void doubleSortTest() {
		BubbleSort.sort( dblArr );
		assertArrayEquals( sortDblArr, dblArr );
	}

}
