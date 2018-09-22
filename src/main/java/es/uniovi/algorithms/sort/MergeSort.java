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
 * Merge sort is an O(n log n) comparison-based sorting algorithm. Most
 * implementations produce a stable sort, which means that the implementation
 * preserves the input order of equal elements in the sorted output.
 * <p>
 * Family: Merging.<br>
 * Space: In-place.<br>
 * Stable: True.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n*log n)<br>
 * Best case = O(n*log n)<br>
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @param <T> the generic type
 * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge Sort
 *      (Wikipedia)</a> <br>
 */
@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> {

    /**
	 * The Enum SPACE_TYPE.
	 *
	 * @author Guillermo Facundo Colunga
	 * @version 201806081225
	 */
    public static enum SPACE_TYPE { 
    	/** The in place. */
    	IN_PLACE, 
    	/** The not in place. */
    	NOT_IN_PLACE }

    /**
	 * Instantiates a new merge sort.
	 */
    private MergeSort() { }

    /**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param unsorted the unsorted
	 * @return the t[]
	 */
    public static <T extends Comparable<T>> T[] sort(SPACE_TYPE type, T[] unsorted) {
        sort(type, 0, unsorted.length, unsorted);
        return unsorted;
    }

    /**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param start the start
	 * @param length the length
	 * @param unsorted the unsorted
	 */
    private static <T extends Comparable<T>> void sort(SPACE_TYPE type, int start, int length, T[] unsorted) {
        if (length > 2) {
            int aLength = (int) Math.floor(length / 2);
            int bLength = length - aLength;
            sort(type, start, aLength, unsorted);
            sort(type, start + aLength, bLength, unsorted);
            if (type == SPACE_TYPE.IN_PLACE)
                mergeInPlace(start, aLength, start + aLength, bLength, unsorted);
            else
                mergeWithExtraStorage(start, aLength, start + aLength, bLength, unsorted);
        } else if (length == 2) {
            T e = unsorted[start + 1];
            if (e.compareTo(unsorted[start]) < 0) {
                unsorted[start + 1] = unsorted[start];
                unsorted[start] = e;
            }
        }
    }

    /**
	 * Merge in place.
	 *
	 * @param <T> the generic type
	 * @param aStart the a start
	 * @param aLength the a length
	 * @param bStart the b start
	 * @param bLength the b length
	 * @param unsorted the unsorted
	 */
    private static <T extends Comparable<T>> void mergeInPlace(int aStart, int aLength, int bStart, int bLength, T[] unsorted) {
        int i = aStart;
        int j = bStart;
        int aSize = aStart + aLength;
        int bSize = bStart + bLength;
        while (i < aSize && j < bSize) {
            T a = unsorted[i];
            T b = unsorted[j];
            if (b.compareTo(a) < 0) {
                // Shift everything to the right one spot
                System.arraycopy(unsorted, i, unsorted, i+1, j-i);
                unsorted[i] = b;
                i++;
                j++;
                aSize++;
            } else {
                i++;
            }
        }
    }

    /**
	 * Merge with extra storage.
	 *
	 * @param <T> the generic type
	 * @param aStart the a start
	 * @param aLength the a length
	 * @param bStart the b start
	 * @param bLength the b length
	 * @param unsorted the unsorted
	 */
    private static <T extends Comparable<T>> void mergeWithExtraStorage(int aStart, int aLength, int bStart, int bLength, T[] unsorted) {
        int count = 0;
        T[] output = (T[]) new Comparable[aLength + bLength];
        int i = aStart;
        int j = bStart;
        int aSize = aStart + aLength;
        int bSize = bStart + bLength;
        while (i < aSize || j < bSize) {
            T a = null;
            if (i < aSize) {
                a = unsorted[i];
            }
            T b = null;
            if (j < bSize) {
                b = unsorted[j];
            }
            if (a != null && b == null) {
                output[count++] = a;
                i++;
            } else if (b != null && a == null) {
                output[count++] = b;
                j++;
            } else if (b != null && b.compareTo(a) <= 0) {
                output[count++] = b;
                j++;
            } else {
                output[count++] = a;
                i++;
            }
        }
        int x = 0;
        int size = aStart + aLength + bLength;
        for (int y = aStart; y < size; y++) {
            unsorted[y] = output[x++];
        }
    }
}