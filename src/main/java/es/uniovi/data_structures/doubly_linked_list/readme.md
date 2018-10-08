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
```

If we dont have a tail implemented in our list because of design constraints we can alwais perform an iterative/recursive algorithm to add the data.

#### Iterative version
```java
public void add(T data) {
  Node<T> newNode = new Node<T>(data); // Creating the new node from the content.
  Node<T> pointer = this.head; // Pointer to iterate over the list.
  
  // Traversing the list.
  while(pointer.getNextNode()!=null) {
    pointer = pointer.getNextNode();
  }
  // Adding and updating links.
  pointer.setNextNode(newNode); // Adding the new node to the end of the list.
  newNode.setPreviousNode(pointer); // Updating the link of the previous last node to the new one.
}
```

#### Recursive version
```java
public void add(T data) {
  this.add(this.head, data);
}

private void add(Node<T> iterator, T data) {
  if(iterator.getNextNode() != null) {
    this.add(iterator.getNextNode, data); // Recursive call.
  } else {
    Node<T> newNode = new Node<T>(data); // Creating the new node from the content.
    iterator.setNextNode(newNode); // Adding the new node to the end of the list.
    newNode.setPreviousNode(iterator); // Updating the link of the previous last node to the new one.
  }
}
```

## Removing elements
To remove an element we have to be more careful because the node to remove most probably wont be nor the first nor the last. So here is the recursive implementation of the algorithm to remove the emelemnts from the list.

```java
public boolean remove(T data) {
  return remove(this.head, data);
}

private boolean remove(Node<T> iterator, T data) {
  if(iterator == null) {
    return false; // The data to remove is not in the list.
  }
  if(iterator.getContent().equals(data)) {
    // Seting the previous node next pointer to the next of the node to remove.
    iterator.getPreviousNode().setNextNode(iterator.getNextNode());
    
    // If the node to remove was not the last...
    if(iterator.getNextNode() != null) {
      // Set the previous link of the next node to the previous of the node to remove.
      iterator.getNextNode().setPreviousNode(iterator.getPreviousNode());
    }
    
    // Return true to indicate that the node was succesfully removed.
    return true;
  }
  // Still looking for the element to remove.
  return this.remove(iterator.getNextNode(), data);
}
```

## Checking if an element is in the list.
For that we have some methods like contains or indexOf, we will re-use the implementation.

#### indexOf implementation:
```java
public int indexOf(T data) {
  return indexOf(this.head, data, 0);
}

public int indexOf(Node<T> iterator, T data, int i) {
  if(iterator == null)
    return -1; // The data is not in the list.
  if(iterator.getContent().equals(data))
    return i; // The index of the data.
  return indexOf(iterator.getNextNode(), data, i++); // Another iteration over the next element.
}
```
The above method will return the index in the list where the data introduced is found by first time.

#### contains implementation:
```java
public boolean contains(T data) {
  return indexOf(data) != -1;
}
```
By using the indexOf method the contains returns true if the list contains the data introduced, false otherwise.

#### isEmpty implementation:
```java
public boolean isEmpty() {
  return this.head == null;
}
```
Simply indicates whether the list id empty or not.

### toString implementation:

```java
public String toString() {
  Node<T> iterator = this.head;
  String returnValue = "";
  while(iterator.getNextNode() != null) {
    returnValue += iterator.getContent().toString() + " -> "
  }
  return returnValue;
}
```
Will construct an string in the format `A -> B -> C ->`.
