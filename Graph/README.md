# Graphs :six_pointed_star:

## What is a graph?
A graph data structure consists of a finite (and possibly mutable) set of vertices or nodes or points, together with a set of unordered pairs of these vertices for an undirected graph or a set of ordered pairs for a directed graph. These pairs are known as edges, arcs, or lines for an undirected graph and as arrows, directed edges, directed arcs, or directed lines for a directed graph. The vertices may be part of the graph structure, or may be external entities represented by integer indices or references.

A graph data structure may also associate to each edge some edge value, such as a symbolic label or a numeric attribute (cost, capacity, length, etc.).

## To start with graphs
A good way to start with graphs is having a look to [GraphNode](https://github.com/thewilly/java-algorithms-club/blob/master/Graph/GraphNode.java) class.
If you look at the definition of the class, you can see that this class extends of <T extends Comparable<T>>. That means that is a generic class. So you can use generic objects in this class while this obects will extend Comparable. If you need more information about generic classes you can have a look in the [java documentation](https://docs.oracle.com/javase/tutorial/java/generics/types.html)
