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

package es.uniovi.data_structures.avl_tree;

import es.uniovi.data_structures.containers.Node;

/**
 * The Class AVLNode.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public final class AVLNode<T extends Comparable<T>> extends Node<T> {
	
	/** The right. */
	private AVLNode<T> left, right;
	
	/** The height. */
	private int height;
	
	/**
	 * Instantiates a new AVL node.
	 *
	 * @param content the content
	 */
	public AVLNode( T content ) {
		super( content );
		left = null;
		right = null;
	}
	
	/**
	 * Instantiates a new AVL node.
	 *
	 * @param content the content
	 * @param left the left
	 * @param right the right
	 */
	public AVLNode( T content, AVLNode<T> left, AVLNode<T> right ) {
		super( content );
		setLeft( left );
		setRight( right );
	}
	
	/* (non-Javadoc)
	 * @see es.uniovi.data_structures.containers.Node#getContent()
	 */
	public T getContent() {
		return super.getContent();
	}
	
	/* (non-Javadoc)
	 * @see es.uniovi.data_structures.containers.Node#setContent(java.lang.Comparable)
	 */
	public void setContent( T content ) {
		super.setContent( content );
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		updateHeight();
		return this.height;
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight( int height ) {
		if (height < 0)
			throw new IllegalArgumentException( "The height must be possitive" );
		this.height = height;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public AVLNode<T> getLeft() {
		return this.left;
	}
	
	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public AVLNode<T> getRight() {
		return this.right;
	}
	
	/**
	 * Sets the left.
	 *
	 * @param left the new left
	 */
	public void setLeft( AVLNode<T> left ) {
		this.left = left;
	}
	
	/**
	 * Sets the right.
	 *
	 * @param right the new right
	 */
	public void setRight( AVLNode<T> right ) {
		this.right = right;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.getContent().toString() + "(" + getBalanceFactor() + ")";
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println( this.toString() );
	}
	
	/**
	 * Update height.
	 */
	protected void updateHeight() {
		// If the node doesn't have children, its height is just 0
		if (getLeft() == null && getRight() == null)
			setHeight( 0 );

		// If it has a child on one side, its height is its child's height plus
		// one
		else if (getLeft() != null && getRight() == null)
			setHeight( 1 + getLeft().getHeight() );

		else if (getLeft() == null && getRight() != null)
			setHeight( 1 + getRight().getHeight() );

		// If it has one child on each side, its height will be the greatest of
		// its childrens's height plus one
		else if (getLeft().getHeight() > getRight().getHeight())
			setHeight( 1 + getLeft().getHeight() );
		else
			setHeight( 1 + getRight().getHeight() );
	}
	
	/**
	 * Gets the balance factor.
	 *
	 * @return the balance factor
	 */
	public int getBalanceFactor() {
		return computeBF();
	}
	
	/**
	 * Compute BF.
	 *
	 * @return the int
	 */
	private int computeBF() {

		// If the node doesn't have children, its BF is just 0
		if (getLeft() == null && getRight() == null)
			return 0;
		// If it has a child on one side
		else if (getRight() == null)
			return -1 - getLeft().getHeight();
		else if (getLeft() == null && getRight() != null)
			return 1 + getRight().getHeight();
		// If it has one child on each side
		else
			return ( getRight().getHeight() - getLeft().getHeight() );
	}
}
