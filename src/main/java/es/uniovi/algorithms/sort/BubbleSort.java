/* 
 * MIT License
 * 
 * Copyright (c) 2018 Guillermo Facundo Colunga
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package es.uniovi.algorithms.sort;

/**
 * Bubble sort is a sorting algorithm that is implemented by starting in the
 * beginning of the array and swapping the first two elements only if the first
 * element is greater than the second element. This comparison is then moved
 * onto the next pair and so on and so forth. This is done until the array is
 * completely sorted. The smaller items slowly “bubble” up to the beginning of
 * the array.
 *
 * @author Guillermo Facundo Colunga.
 * @version 1
 * @since 201712120028.
 * @formatter Oviedo Computing Community Extended.
 */
public class BubbleSort {

	/**
	 * Average: O(N^2) Worst: O(N^2) Memory: O(1)
	 * 
	 * Sorts the given array of elements by executing bubble sort. That is by
	 * starting in the beginning of the array and swapping the first two
	 * elements only if the first element is greater than the second element.
	 * This comparison is then moved onto the next pair and so on and so forth.
	 * This is done until the array is completely sorted. The smaller items
	 * slowly “bubble” up to the beginning of the array.
	 *
	 * @param <T> the generic type
	 * @param elements array to be sorted. It is sorted in the same array.
	 */
	public static <T extends Comparable<T>> void sort( T[] elements ) {
		for (int i = 1; i < elements.length; i++) { // O(n)
			for (int j = elements.length - 1; j >= i; j--) { // O(n)
				if (elements[j - 1].compareTo( elements[j] ) > 0) {
					T temp = elements[j];
					elements[j] = elements[j - 1];
					elements[j - 1] = temp;
				}
			}
		}
	}

}