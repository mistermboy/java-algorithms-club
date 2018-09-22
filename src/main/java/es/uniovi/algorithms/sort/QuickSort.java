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

import java.util.Random;

/**
 * Quicksort is a sorting algorithm which, on average, makes O(n*log n)
 * comparisons to sort n items. In the worst case, it makes O(n^2) comparisons,
 * though this behavior is rare. Quicksort is often faster in practice than
 * other algorithms.
 * <p>
 * Family: Divide and conquer.<br>
 * Space: In-place.<br>
 * Stable: False.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n^2)<br>
 * Best case = O(n) [three-way partition and equal keys]<br>
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @param <T> the generic type
 * @see <a href="https://en.wikipedia.org/wiki/Quick_sort">Quicksort
 *      (Wikipedia)</a> <br>
 */
public class QuickSort<T extends Comparable<T>> {

    /** The Constant RAND. */
    private static final Random RAND = new Random();

    /**
	 * The Enum PIVOT_TYPE.
	 *
	 * @author Guillermo Facundo Colunga
	 * @version 201806081225
	 */
    public static enum PIVOT_TYPE {
        
        /** The first. */
        FIRST, 
        /** The middle. */
        MIDDLE, 
        /** The random. */
        RANDOM
    }

    /** The type. */
    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    /**
	 * Instantiates a new quick sort.
	 */
    private QuickSort() { }

    /**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param pivotType the pivot type
	 * @param unsorted the unsorted
	 * @return the t[]
	 */
    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE pivotType, T[] unsorted) {
        int pivot = 0;
        if (pivotType == PIVOT_TYPE.MIDDLE) {
            pivot = unsorted.length/2;
        } else if (pivotType == PIVOT_TYPE.RANDOM) {
            pivot = getRandom(unsorted.length);  
        }
        sort(pivot, 0, unsorted.length - 1, unsorted);
        return unsorted;
    }

    /**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param index the index
	 * @param start the start
	 * @param finish the finish
	 * @param unsorted the unsorted
	 */
    private static <T extends Comparable<T>> void sort(int index, int start, int finish, T[] unsorted) {
        int pivotIndex = start + index;
        T pivot = unsorted[pivotIndex];
        int s = start;
        int f = finish;
        while (s <= f) {
            while (unsorted[s].compareTo(pivot) < 0)
                s++;
            while (unsorted[f].compareTo(pivot) > 0)
                f--;
            if (s <= f) {
                swap(s, f, unsorted);
                s++;
                f--;
            }
        }
        if (start < f) {
            pivotIndex = getRandom((f - start) + 1);
            sort(pivotIndex, start, f, unsorted);
        }
        if (s < finish) {
            pivotIndex = getRandom((finish - s) + 1);
            sort(pivotIndex, s, finish, unsorted);
        }
    }

    /**
	 * Gets the random.
	 *
	 * @param length the length
	 * @return the random
	 */
    private static final int getRandom(int length) {
        if (type == PIVOT_TYPE.RANDOM && length > 0)
            return RAND.nextInt(length);
        if (type == PIVOT_TYPE.FIRST && length > 0)
            return 0;
        return length / 2;
    }

    /**
	 * Swap.
	 *
	 * @param <T> the generic type
	 * @param index1 the index 1
	 * @param index2 the index 2
	 * @param unsorted the unsorted
	 */
    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T index2Element = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = index2Element;
    }
}