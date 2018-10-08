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
package es.uniovi.data_structures.containers;

/**
 * The Class Node.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public class Node<T extends Comparable<T>> {

	/** The content. */
	private T content;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param content the content
	 */
	public Node(T content) {
		setContent(content);
	}
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public T getContent() {
		return this.content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(T content) {
		this.content = content;
	}
}