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
package es.uniovi.data_structures.bynary_heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Class BinaryHeap.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public class BinaryHeap<T extends Comparable<T>> {

	/** The heap. */
	private ArrayList<T> heap;

	/**
	 * Main constructor. Initializes a heap.
	 */
	public BinaryHeap() {
		heap = new ArrayList<T>();
	}

	/**
	 * Initializes a heap from a given array of elements. Once the elements are
	 * added it will be filtered down for every element that is not a leaf.
	 * 
	 * @param elements to be added to the heap.
	 */
	public BinaryHeap( T[] elements ) {
		heap = new ArrayList<T>();
		for (T element : elements) {
			heap.add( element );
		}
		buildHeap();
	}

	/**
	 * Auxiliary internal method that apply the filter down to every element
	 * allocated from the half to the bottom.
	 */
	private void buildHeap() {
		for (int i = heap.size() / 2; i > -1; i--) {
			filterDown( i );
		}
	}

	/**
	 * Returns true or false whether the heap is empty or not.
	 * 
	 * @return true if the heap is empty. False otherwise.
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	/**
	 * Prints by console the whole heap as [e1, e2,...].
	 */
	public void print() {
		System.out.println( this.toString() );
	}

	/**
	 * Override of the toString method.
	 *
	 * @return the string
	 */
	@Override public String toString() {
		return this.heap.toString();
	}

	/**
	 * Filters up the tree. And shorted by the value of the content.
	 * 
	 * @param pos were we start to filter up.
	 */
	private void filterUp( int pos ) {
		while (pos != 0) {
			int parent = ( pos - 1 ) / 2;
			if (heap.get( pos ).compareTo( heap.get( parent ) ) < 0) {
				Collections.swap( heap, pos, parent );
				pos--;
			} else {
				pos--;
			}
		}
	}

	/**
	 * Adds the object at the end of the ArrayList and the filter ups.
	 *
	 * @param element the element
	 */
	public void add( T element ) {
		if (heap.contains( element ))
			throw new IllegalArgumentException(
					"You cannot add repeated elements to the heap." );
		heap.add( element );
		filterUp( ( heap.size() - 1 ) );
	}

	/**
	 * Filters down the tree. And shorted by the value of the content. Applies
	 * descending filtering to the node referred by a given position in the
	 * ArrayList. While (pos do not become a leaf) 1.Select which of the
	 * children of pos is the smallest. 2.If value of pos > value of that child
	 * swap the values
	 *
	 * @param pos were we start to filter down.
	 */
	private void filterDown( int pos ) {
		int childPos;

		while (pos < heap.size() / 2) {
			if (2 * pos + 1 >= heap.size())
				break;
			else if (2 * pos + 2 >= heap.size())
				childPos = 2 * pos + 1;
			else if (heap.get( 2 * pos + 1 )
					.compareTo( heap.get( 2 * pos + 2 ) ) > 0) {
				childPos = 2 * pos + 2;
			} else {
				childPos = 2 * pos + 1;
			}

			if (heap.get( pos ).compareTo( heap.get( childPos ) ) > 0) {
				Collections.swap( heap, pos, childPos );
				pos = childPos;
			} else
				break;
		}
	}

	/**
	 * Gives the highest priority element and then, after remove it from the
	 * heap, will filter down the rest of the elements.
	 * 
	 * @return the highest priority element.
	 */
	public T getHighestPriorityElement() {
		if (isEmpty()) {
			throw new IllegalStateException( "The heap is empty." );
		}
		// Behavior changed, now only if the heap is not empty we execute the
		// algorithm, nothing about exceptions.
		T aux = heap.get( 0 );
		T lastNode = heap.remove( ( heap.size() - 1 ) );
		if (!isEmpty()) {
			heap.set( 0, lastNode );
			filterDown( 0 );
		}
		return aux;
	}
}
