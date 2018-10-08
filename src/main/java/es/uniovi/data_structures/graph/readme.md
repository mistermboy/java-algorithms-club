# Graph
A graph is a diagram showing the relation between variable quantities, typically of two variables, each measured along one of a pair of axes at right angles.

![](https://github.com/computer-science-uniovi/java-algorithms/blob/master/src/main/java/es/uniovi/data_structures/graph/graph-def-7.png)

For example in the avobe picture shows the nodes 1 2 3 4 and 5, the number in the edge (line that links two nodes) is the weight or the cost to pay to cross that path. Example, to go from 1 to 2 we can go directly with a cost of 2, or through 4 paying 5 + 5 = 10. Here we just discover the problem of minimum cost paths. But first lets specify how we will represent the graph in java.

## Node class
A node just has to store its content and a boolean value to indicate wheter it has been visited or not. This visited value bill be used later for minimum cost paths problems resolution.

```java
  public class Node<T> {
    T content;
    boolean visited;
  }
```

## Graph class
The graph class will be a collection of nodes with relations between them and costs (weights) for the relations between them (paths). For that porpouse we will use a list to store the nodes, and two matrices, one for the paths and another for the weights.


