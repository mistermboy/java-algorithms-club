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

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Graph.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 * @param <T> the generic type
 */
public class Graph<T extends Comparable<T>> {

	/** The nodes. */
	List<GraphNode<T>> nodes;
	
	/** The edges. */
	private boolean[][] edges;
	
	/** The weight. */
	private double[][] weight;

	/** The a. */
	// Floyd attributes.
	private double[][] A;
	
	/** The p. */
	private int[][] P;

	/** The d. */
	// Dijkstra attributes
	private double[] D;
	
	/** The pd. */
	private int[] PD;

	/** The Constant INDEX_NOT_FOUND. */
	// Constants.
	public static final int INDEX_NOT_FOUND = -1;
	
	/** The Constant MAX_NUMBER. */
	public final static Double MAX_NUMBER = Double.MAX_VALUE;

	/**
	 * Instantiates a new graph.
	 *
	 * @param n the n
	 */
	public Graph( int n ) {
		if (n > 0) {
			nodes = new ArrayList<GraphNode<T>>();
			edges = new boolean[n][n];
			weight = new double[n][n];
		}
	}

	/**
	 * Return the actual position of the given T element.
	 * 
	 * @param value to be searched inside the graph.
	 * @return the position of the node if it's inside the graph, -1 otherwise.
	 */
	public int getValueIndex( T value ) {
		int i = 0;
		for (GraphNode<T> curr : nodes) {
			if (value.compareTo( curr.getContent() ) == 0)
				return i;
			i++;
		}
		return INDEX_NOT_FOUND;
	}

	/**
	 * Gets the value at index.
	 *
	 * @param index the index
	 * @return the value at index
	 */
	public T getValueAtIndex( int index ) {
		return nodes.get( index ).getContent();
	}

	/**
	 * Size.
	 *
	 * @return the size of the graph. Or the number of nodes that the graph
	 *         contains.
	 */
	public int size() {
		return nodes.size();
	}

	/**
	 * Given a T element we create a node in the graph.
	 * 
	 * @param element to be added to the graph
	 * @throws Exception if the node already exits on the graph. Or if the graph
	 *             is full.
	 */
	public void addContent( T element ) throws Exception {
		if (element == null) {
			throw new Exception( "You cannot add null elements to the graph." );
		} else if (size() == weight.length) {
			throw new Exception(
					"The node cannot be added because there's no space." );
		}
		for (GraphNode<T> node : nodes) {
			if (node.getContent().equals( element ))
				throw new Exception( "Element is already in the graph." );
		}
		nodes.add( new GraphNode<T>( element ) );
	}

	/**
	 * Returns true if exists an edge between the given origin and dest.
	 *
	 * @param origin the origin
	 * @param dest the dest
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean existsEdge( T origin, T dest ) throws Exception {
		return edges[getValueIndex( origin )][getValueIndex( dest )];
	}

	/**
	 * Adds and edge between the given origin, destination and sets a weight.
	 *
	 * @param origin the origin
	 * @param dest the dest
	 * @param weight the weight
	 * @throws Exception the exception
	 */
	public void addEdge( T origin, T dest, double weight ) throws Exception {
		if (existsEdge( origin, dest ))
			throw new Exception( "You cannot add a repeated edge." );
		else {
			this.weight[getValueIndex( origin )][getValueIndex( dest )] = weight;
			edges[getValueIndex( origin )][getValueIndex( dest )] = true;
		}
	}

	/**
	 * Just for testing proposes...
	 * 
	 * @return the edges array.
	 */
	public boolean[][] getEdges() {
		return this.edges;
	}

	/**
	 * Just for testing proposes...
	 * 
	 * @return the weights array.
	 */
	public double[][] getWeights() {
		return this.weight;
	}

	/**
	 * Traverse over the graph by using the DFPrint private method.
	 *
	 * @param element the element
	 * @return the string
	 * @throws Exception the exception
	 */
	public String traverseGraph( T element ) throws Exception {
		int v = getValueIndex( element );
		if (v == INDEX_NOT_FOUND)
			throw new Exception( "That node does not exists." );
		for (GraphNode<T> n : nodes)
			n.setVisited( false );
		return DFPrint( v );
	}

	/**
	 * Recursive method that traverses over the and returns its content as
	 * "a-b-c-".
	 *
	 * @param v the v
	 * @return the string
	 */
	private String DFPrint( int v ) {
		nodes.get( v ).setVisited( true );
		StringBuilder aux = new StringBuilder();
		aux.append( getValueAtIndex( v ).toString() + "-" );
		for (int i = 0; i < size(); i++) {
			if (edges[v][i] && !nodes.get( i ).isVisited())
				aux.append( DFPrint( i ) );
		}
		return aux.toString();
	}

	/**
	 * Prints the.
	 *
	 * @throws Exception the exception
	 */
	public void print() throws Exception {
		System.out.println( traverseGraph( nodes.get( 0 ).getContent() ) );
	}

	/**
	 * Removes a node from the graph.
	 * 
	 * @param element stored in the graph to be removed.
	 * @throws Exception if the node doesn't exist in the graph.
	 */
	public void removeNode( T element ) throws Exception {
		int index = getValueIndex( element );
		if (index < 0)
			throw new Exception( "Attempting to remove a non existing node" );
		nodes.remove( index );
		for (int i = index; i < size(); i++) {
			for (int j = 0; j < size(); j++) {
				weight[i][j] = weight[i + 1][j];
				weight[j][i] = weight[j][i + 1];
				edges[i][j] = edges[i + 1][j];
				edges[j][i] = edges[j][i + 1];
			}
			weight[i][i] = weight[i + 1][i + 1];
			edges[i][i] = edges[i + 1][i + 1];
		}
	}

	/**
	 * Removes an edge between two nodes.
	 * 
	 * @param origin the element contained in the node that's the starting point
	 *            of the edge.
	 * @param dest the element contained in the node that's the end point of the
	 *            edge.
	 * @throws Exception if the edge does not exist.
	 */
	public void removeEdge( T origin, T dest ) throws Exception {
		if (!existsEdge( origin, dest ))
			throw new Exception( "There's no edge between the selected nodes" );
		edges[getValueIndex( origin )][getValueIndex( dest )] = false;
		weight[getValueIndex( origin )][getValueIndex( dest )] = 0.0;
	}

	/* ---------- FLOYD ALGORITHM ---------- */

	/**
	 * Returns matrix A from Floyd's algorithm. Contains the minimum cost of
	 * going to any node from any other node.
	 * 
	 * @return Floyd's A matrix
	 */
	public double[][] getA() {
		return A;
	}

	/**
	 * Returns matrix P from Floyd's algorithm. Contains the previous node that
	 * must be visited to get to any node from any other node.
	 * 
	 * @return Floyd's P matrix
	 */
	public int[][] getP() {
		return P;
	}

	/**
	 * Initializes the A matrix giving it the weight of the edges of going
	 * directly from each node to all the others, with infinite
	 * (Double.MAX_VALUE) if there's no direct connection.
	 */
	private void initFloyd() {
		A = getWeights();
		P = new int[size()][size()];
		for (int i = 0; i < size(); i++) {
			for (int j = 0; j < size(); j++) {
				P[i][j] = -1;
				if (A[i][j] == 0.0 && i != j)
					A[i][j] = MAX_NUMBER;
			}
		}
	}

	/**
	 * Executes the algorithm. Calculates the weight of going from each node to
	 * all the others making a stop through a different node each time. If it's
	 * less than the direct value, the A matrix is updated and the intermediate
	 * node is written in the P matrix.
	 *
	 * @param An the an
	 */
	public void computeFloyd( int An ) {
		if (An > size()) {
			An = size();
		}
		initFloyd();
		for (int i = 0; i < An; i++) {
			for (int j = 0; j < size(); j++) {
				for (int k = 0; k < size(); k++) {
					if (( A[i][k] + A[k][j] ) < A[i][j]) {
						A[i][j] = ( A[i][k] + A[k][j] );
						P[i][j] = k;
						i = 0;
						j = 0;
					}
				}
			}
		}
	}

	/**
	 * Returns an String containing the path with the minimum cost to get from
	 * one node to a different one using Floyd's algorithm. Notice that my
	 * algorithm return the hole path from the departure to the destination both
	 * of them included. If not, then for a direct connection would return an
	 * empty String
	 * 
	 * @param departure node to start floyd
	 * @param destination node to end floyd
	 * @return string describing the minimum cost path.
	 */
	public String printFloydPath( T departure, T destination ) {
		if (departure.equals( destination )) {
			return departure.toString();
		}
		int start = getValueIndex( departure );
		int end = getValueIndex( destination );
		int step = P[start][end];
		if (step == -1 && edges[start][end])
			step = start;
		return printFloydPath( departure, getValueAtIndex( step ) )
				+ getValueAtIndex( end ).toString();
	}

	/* ---------- DIJKSTRA ALGORITHM ---------- */

	/**
	 * Returns matrix D from Dijkstra's algorithm. Contains the minimum cost of
	 * going to any node from the node the algorithm has been executed over.
	 * We're doing it in that way because the assertArrayEqualsTo has a bug for
	 * double[].
	 * 
	 * @return Dijkstra's D matrix.
	 */
	public double[][] getD() {
		double[][] aux = new double[1][D.length];
		aux[0] = D;
		return aux;
	}

	/**
	 * Returns matrix P from Dijkstra's algorithm. Contains the previous node
	 * that must be visited to get to any node from the node the algorithm has
	 * been executed over.
	 * 
	 * @return Dijkstra's P matrix
	 */
	public int[] getPD() {
		return PD;
	}

	/**
	 * Initializes Dijkstra's algorithm creating matrices D and P and giving
	 * them the initial values. If there's an edge between two node, D will
	 * contain its weight and P the index of the starting node, otherwise D will
	 * contain infinite and P -1.
	 * 
	 * @param departureNode node the execute Dijkstra's algorithm over.
	 */
	private void initDijkstra( T departureNode ) {
		D = new double[size()];
		PD = new int[size()];
		int departureIndex = getValueIndex( departureNode );

		for (int i = 0; i < size(); i++) {
			nodes.get( i ).setVisited( false );
			if (departureIndex == i) {
				D[i] = 0.0;
				PD[i] = -1;
			} else if (edges[departureIndex][i]) {
				D[i] = weight[departureIndex][i];
				PD[i] = departureIndex;
			} else {
				D[i] = MAX_NUMBER;
				PD[i] = -1;
			}
		}
	}

	/**
	 * Complexity --> O(n2) Quadratic implementation for the Dijkstra algorithm.
	 * This algorithm calculates the shortest path from a source node to every
	 * other nodes in the graph.
	 *
	 * @param departureNode the departure node
	 */
	public void computeDijkstra( T departureNode ) {
		initDijkstra( departureNode );
		int dn = this.getValueIndex( departureNode );
		nodes.get( dn ).setVisited( true );
		for (int i = 1; i < this.size(); i++) {
			double min = MAX_NUMBER;
			int w = -1;
			for (int j = 0; j < this.size(); j++) {
				if (!nodes.get( j ).isVisited() && D[j] < min) {
					min = D[j];
					w = j;
				}
			}
			if (w != -1) {
				nodes.get( w ).setVisited( true );
				for (int k = 0; k < size(); k++) {
					if (edges[w][k] && D[w] + weight[w][k] < D[k]) {
						D[k] = D[w] + weight[w][k];
						PD[k] = w;
					}
				}
			}
		}

	}

	/**
	 * It return the number of nodes n such that is possible to go from the
	 * source to them and return to the source with no more cost than the one
	 * provided.
	 *
	 * @param source the node where we start the algorithm and therefore the
	 *            path
	 * @param cost the cost
	 * @return the number of reachable nodes within the range of cost.
	 * @throws Exception if the cost provided is negative. Cost must be always
	 *             positive.
	 */
	public int getNumberOfReturnNodesWithinCost( T source, double cost )
			throws Exception {
		if (cost < 0)
			throw new RuntimeException( "Costs cannot be negative." );
		int index = getValueIndex( source );
		computeFloyd( size() );
		int result = 1;
		for (int i = 0; i < size(); i++) {
			if (( A[index][i] + A[i][index] ) <= cost && index != i)
				result++;
		}
		return result;
	}

	/* ---------- SOME EXAMPLES OF WORKING WITH GRAPHS ---------- */
	
	/**
	 * IMPLEMENTING FLOYD Checks whether a node is strongly connected, i.e.
	 * there is a path from the node to every other node in the graph and at the
	 * same time from every other node to it.
	 * 
	 * @param node Node to check
	 * @return whether the node is strongly connected
	 */
	public boolean isStronglyConnected( T node ) {
		int index = getValueIndex( node );
		computeFloyd( size() );
		boolean result = true;

		for (int i = 0; i < size(); i++) {
			if (A[index][i] == MAX_NUMBER && index != i)
				result = false;
			if (A[i][index] == MAX_NUMBER && index != i)
				result = false;
		}

		return result;
	}

	/**
	 * IMPLEMENTING FLOYD Given a T node check all the minimum paths to the
	 * other nodes and returns the one with maximum distance.
	 *
	 * @param node the node
	 * @return the maximum distance from this node to every other node as a
	 *         double.
	 */
	public double computeExcentricity( T node ) {
		int index = getValueIndex( node );
		computeFloyd( size() );
		double result = 0.0;

		for (int i = 0; i < size(); i++) {
			if (A[index][i] > result && index != i && A[index][i] != MAX_NUMBER)
				result = A[index][i];
			if (A[i][index] > result && index != i && A[i][index] != MAX_NUMBER)
				result = A[i][index];
		}

		return result;
	}

	/**
	 * IMPLEMENTING DIJKSTRA Given a T node check all the minimum paths to the
	 * other nodes and returns the one with maximum distance.
	 *
	 * @param node the node
	 * @return the maximum distance from this node to every other node as a
	 *         double.
	 */
	public double computeExcentricityDijkstra( T node ) {
		computeDijkstra( node );
		double distances[][] = getD();
		double result = 0.0;

		for (int i = 0; i < distances[0].length; i++) {
			if (distances[0][i] > result && distances[0][i] < MAX_NUMBER)
				result = distances[0][i];
		}

		return result;
	}

	/**
	 * IMPLEMENTING FLOYD Return the diameter of the graph, that is the longest
	 * path of the minimum ones.
	 * 
	 * @return double diameter.
	 */
	public double getDiameter() {
		double result = 0.0;
		for (GraphNode<T> node : nodes) {
			double ex = computeExcentricity( node.getContent() );
			if (ex > result) {
				result = ex;
			}
		}

		return result;
	}

	/**
	 * IMPLEMENTING DIJKSTRA Same as diameter but this time implementing
	 * Dijkstra.
	 *
	 * @return the diameter dijkstra
	 */
	public double getDiameterDijkstra() {
		double result = 0.0;
		for (GraphNode<T> node : nodes) {
			double ex = computeExcentricityDijkstra( node.getContent() );
			if (ex > result) {
				result = ex;
			}
		}

		return result;
	}

	/**
	 * Número de aristas incidentes en el vértice. If edges[i][index]
	 * incoming, if edges[index][i] outcomming.
	 *
	 * @param node the node
	 * @return integer value with the number of aristas.
	 */
	public int getDegreeOf( T node ) {
		int index = getValueIndex( node );
		int result = 0;
		for (int i = 0; i < size(); i++) {
			if (edges[i][index])
				result++;
		}
		return result;
	}

	/**
	 * Número mínimo de aristas incidentes en un vértice de entre todos los
	 * vértices existentes en el grafo.
	 *
	 * @return integer. Número mínimo de aristas incidentes
	 */
	public int getMinDegree() {
		int result = Integer.MAX_VALUE;
		for (GraphNode<T> node : nodes) {
			int gn = getDegreeOf( node.getContent() );
			if (gn < result)
				result = gn;
		}
		return result;
	}

	/**
	 * Número máximo de aristas que inciden en un vértice de entre todos los
	 * vértices del grafo.
	 * 
	 * @return integer. Número máximo de aristas que incide
	 */
	public int getMaxDegree() {
		int result = 0;
		for (GraphNode<T> node : nodes) {
			int gn = getDegreeOf( node.getContent() );
			if (gn > result)
				result = gn;
		}
		return result;
	}
}
