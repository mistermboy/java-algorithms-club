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
package es.uniovi.data_structures.doubly_linked_list;

import es.uniovi.data_structures.containers.Node;

/**
 * The Class LinkedNode.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public class LinkedNode<T extends Comparable<T>> extends Node<T> implements Comparable<LinkedNode<T>>{
	
	/** The next. */
	private LinkedNode<T> prev, next;
	
	/**
	 * Allocates a LinkedNode object and initializes it with the content passed
	 * as value.
	 * 
	 * @param content of the node.
	 */
	public LinkedNode( T content ) {
		super( content );
	}

	/**
	 * Allocates a LinkedNode object and initializes it with the content and
	 * next node passed as value.
	 * 
	 * @param content of the node.
	 * @param next node.
	 */
	public LinkedNode( T content, LinkedNode<T> next ) {
		this( content );
		setNextNode( next );
	}

	/**
	 * 
	 * Allocates a LinkedNode object and initializes it with the content, next
	 * and previous nodes passed as value.
	 * 
	 * @param content of node.
	 * @param next value.
	 * @param previous value.
	 */
	public LinkedNode( T content, LinkedNode<T> next, LinkedNode<T> previous ) {
		this( content, next );
		setPreviousNode( previous );
	}

	/**
	 * Gets the content.
	 *
	 * @return the content of the node.
	 */
	public T getContent() {
		return super.getContent();
	}

	/**
	 * Sets the content.
	 *
	 * @param content of the node.
	 */
	public void setContent( T content ) {
		super.setContent( content );
	}

	/**
	 * Gets the previous node.
	 *
	 * @return the previous node.
	 */
	public LinkedNode<T> getPreviousNode() {
		return this.prev;
	}

	/**
	 * Sets the previous node.
	 *
	 * @param previousNode is a pointer to the previous node.
	 */
	public void setPreviousNode( LinkedNode<T> previousNode ) {
		this.prev = previousNode;
	}

	/**
	 * Gets the next node.
	 *
	 * @return the next node.
	 */
	public LinkedNode<T> getNextNode() {
		return this.next;
	}

	/**
	 * Sets the next node.
	 *
	 * @param nextNode is a pointer to the next node.
	 */
	public void setNextNode( LinkedNode<T> nextNode ) {
		this.next = nextNode;
	}

	/**
	 * Sets the node to null. Helps the garbage collector to find and delete the
	 * node. Even though its not necessary to be called at any time.
	 */
	public void delete() {
		super.setContent( null );
		this.next = null;
		this.prev = null;
	}

	/**
	 * Compares the value of the content.
	 *
	 * @param node the node
	 * @return the int
	 */
	public int compareTo( LinkedNode<T> node ) {
		return this.getContent().compareTo( node.getContent() );
	}

}
