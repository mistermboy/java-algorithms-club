# Doubly Linked List
In computer science, a doubly linked list is a linked data structure that consists of a set of sequentially linked records called nodes. Each node contains two fields, called links, that are references to the previous and to the next node in the sequence of nodes.

```java
/**
 * A single node with its content and its reference to the previous and next nodes.
 */ 
public class Node<T> {
  T data; // The data contained by the node.
  Node<T> previousNode; // The pointer to the previous node.
  Node<T> nextNode; // The pointer to the next node.
}
```

![alt text](https://github.com/computer-science-uniovi/java-algorithms/blob/master/src/main/java/es/uniovi/data_structures/doubly_linked_list/DLL1.png)

In the previous image the nodes are represented as rectangles, the A, B, C, D are the data of the nodes and the arrows the pointers between nodes. For Example for the first node this would be its properties values: `data : A`, `previousNode : NULL` and `nextNode: node with B as data`.

## Creating the list.
Notice that a linked list is nothig more that a set of nodes, and are the nodes the ones that hold the links between data. But in order to unify the behaviour of the list and other algorithms like add, remove, indexOf, contains... we will create a class called DoublyLinkedList, that will contain: `add`, `remove`, `contains`, `isEmpty`, `indexOf` and `toString`.

```java
public class DoublyLinkedList<T> {
  Node<T> head;
  // Node<T> tail; // This property is optional, its implementation depends on the design.
  int size;
}
```
With the above properties we have more than enought to make our list work.

## Adding elements
To add elements we have two options, as this is a doubly linked list we can go to the tail and add the node there, then update the tail. Or we can travel all the list to the tail and and there the new node. Lets compare both implementations.

```java
public void add(T data) {
  Node<T> newNode = new Node<T>(data); // Creating the new node from the content.
  this.tail.setNextNode(newNode); // Seting the new node as the last one.
  newNode.setPreviousNode(this.tail); // Seting the previous node of the new last node as the previous last one.
  this.tail = newNode; // Updating the tail.
}
