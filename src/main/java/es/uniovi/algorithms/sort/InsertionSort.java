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
 * Insertion sort is a simple sorting algorithm: a comparison sort in which the
 * sorted array (or list) is built one entry at a time. It is much less
 * efficient on large lists than more advanced algorithms such as quicksort,
 * heapsort, or merge sort.
 * <p>
 * Family: Insertion.<br>
 * Space: In-place.<br>
 * Stable: True.<br>
 * <p>
 * Average case = O(n^2)<br>
 * Worst case = O(n^2)<br>
 * Best case = O(n)<br>
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @param <T> the generic type
 * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion Sort
 *      (Wikipedia)</a> <br>
 */
public class InsertionSort<T extends Comparable<T>> {

    /**
	 * Instantiates a new insertion sort.
	 */
    private InsertionSort() { }

    /**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param unsorted the unsorted
	 * @return the t[]
	 */
    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int length = unsorted.length;
        for (int i = 1; i < length; i++) {
            sort(i, unsorted);
        }
        return unsorted;
    }

    /**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param i the i
	 * @param unsorted the unsorted
	 */
    private static <T extends Comparable<T>> void sort(int i, T[] unsorted) {
        for (int j = i; j > 0; j--) {
            T jthElement = unsorted[j];
            T jMinusOneElement = unsorted[j - 1];
            if (jthElement.compareTo(jMinusOneElement) < 0) {
                unsorted[j - 1] = jthElement;
                unsorted[j] = jMinusOneElement;
            } else {
                break;
            }
        }
    }
}
