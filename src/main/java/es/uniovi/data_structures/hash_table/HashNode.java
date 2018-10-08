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
package es.uniovi.data_structures.hash_table;

import es.uniovi.data_structures.containers.Node;

/**
 * The Class HashNode.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public class HashNode <T extends Comparable<T>> extends Node<T>{

	/** The Constant EMPTY. */
	// Constants
	public final static int EMPTY = 0;
	
	/** The Constant VALID. */
	public final static int VALID = 1;
	
	/** The Constant DELETED. */
	public final static int DELETED = 2;

	/** The status. */
	// Variables
	private int status;

	/**
	 * Main Constructor.
	 */
	public HashNode() {
		super( null );
		setStatus( EMPTY );
	}

	/**
	 * Setter. Sets the status.
	 * 
	 * @param status of the node.
	 */
	public void setStatus( int status ) {
		this.status = status;
	}

	/**
	 * Getter. Gets the status.
	 * 
	 * @return the status of the node.
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * toString default method.
	 *
	 * @return the string
	 * @format if[element != null] --> ellement.toString() else --> "null".
	 */
	public String toString() {
		if (super.getContent() != null)
			return super.getContent().toString();
		return "null";

	}
}
