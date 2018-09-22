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
package es.uniovi.data_structures.graph;

import es.uniovi.data_structures.containers.Node;

/**
 * The Class GraphNode.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public class GraphNode<T extends Comparable<T>> extends Node<T> {

	/** The visited. */
	private boolean visited;

	/**
	 * Instantiates a new graph node.
	 *
	 * @param content the content
	 */
	public GraphNode( T content ) {
		super( content );
		setVisited( false );
	}

	/**
	 * Sets the element of the node.
	 * 
	 * @param content to be stored.
	 */
	public void setContent( T content ) {
		if (content != null)
			super.setContent( content );
	}

	/**
	 * Sets if a node has been visited or not.
	 *
	 * @param visited the new visited
	 */
	public void setVisited( boolean visited ) {
		this.visited = visited;
	}

	/**
	 * Returns if a node has been visited or not.
	 * 
	 * @return true if the node has been visited, false otherwise.
	 */
	public boolean isVisited() {
		return this.visited;
	}

	/**
	 * To string.
	 *
	 * @return as an String formatted as GN(N:"element"/V:"visited").
	 */
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		toReturn.append( "GN(N:" ).append( this.getContent().toString() )
				.append( "/V:" ).append( this.isVisited() ).append( ")" );
		return toReturn.toString();
	}

	/**
	 * Prints in console the value of the toString method.
	 */
	public void print() {
		System.out.println( this.toString() );
	}

}
