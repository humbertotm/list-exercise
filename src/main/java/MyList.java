package mylist;

import java.util.List;

public class MyList<E> {
  // This implementation is a doubly linked list

  // MyList properties
  private Node<E> head;
  private Node<E> tail;
  private int listSize;

  private static class Node<E> {
    // Private Node class that will represent each
    // item in a MyList instance

    private E element;
    private Node<E> next;
    private Node<E> previous;

    public Node(E element) {
      this.element = element;
    }
  }

// ========  PRIVATE METHODS EMPLOYED  BY CLASS METHODS ====

  private void linkFirst(Node<E> nodeToPrepend) {
    // Places the provided node at the head

    Node<E> first = this.head;

    if (first == null) {
      // No elements in list, so head and tail are
      // set to the same node
      this.head = nodeToPrepend;
      this.tail = nodeToPrepend;
    } else {
      this.head = nodeToPrepend;
      this.head.next = first;
    }
  }

  private void linkLast(Node<E> nodeToAppend) {
    // Places the provided node at the tail

    Node<E> last = this.tail;

    if(last == null) {
      // No elements in list, so head and tail are
      // set to the same node
      this.head = nodeToAppend;
      this.tail = nodeToAppend;
    } else {
      this.tail = nodeToAppend;
      last.next = nodeToAppend;
      nodeToAppend.previous = last;
    }
  }

  // Refactor considering the shortest way to move: forwards or backwards
  private void linkBefore(Node<E> nodeToInsert, int index) {
    // Insert provided node at provided index

    int currentNodeIndex = 0;
    Node<E> currentNode = this.head;

    while (currentNodeIndex < index - 1) {
      currentNode = currentNode.next;
      currentNodeIndex++;
    }

    nodeToInsert.next = currentNode.next;
    nodeToInsert.previous = currentNode;
    currentNode.next = nodeToInsert;
  }

  private void unlinkFirst() {
    // Unlink the head of the list

    Node<E> first = this.head;
    Node<E> newHead = first.next;

    this.head = newHead;
    // Set unlinked head to null to allow gc to
    // to reclaim it.
    first = null;
  }

  private void unlinkLast() {
    // Unlinks list's tail node

    Node<E> last = this.tail;
    Node<E> newTail = last.previous;

    newTail.next = null;
    this.tail = newTail;

    // Let garbage collection reclaim it
    last = null;
  }

  private void unlink(int index) {
    // Unlinks the node in the specified position

    int currentNodeIndex = 0;
    Node<E> currentNode = this.head;
    Node<E> previousNode;
    Node<E> nextNode;

    while (currentNodeIndex < index) {
      currentNode = currentNode.next;
        currentNodeIndex++;
    }

    previousNode = currentNode.previous;
    nextNode = currentNode.next;

    previousNode.next = nextNode;
    nextNode.previous = previousNode;

    // Let garbage collection reclaim it
    currentNode = null;
  }

  private int indexOf(Object o) {
    // Returns the index of the object if it exists, -1 otherwise

    int currentIndex = 0;
    Node<E> currentNode = this.head;
    int size = this.listSize;

    while (currentIndex < size) {
      if(currentNode.element == o) {
        return currentIndex;
      } else {
        currentNode = currentNode.next;
        currentIndex++;
      }
    }

    return -1;
  }

  private Node<E> getFirst() {
    // Returns the head of this list

    return this.head;
  }

  private Node<E> getLast() {
    // Returns tail of this list

    return this.tail;
  }

// ======== LIST INTERFACE METHODS IMPLEMENTATION ========

  public boolean add(E e) {
    // Appends the specified element to the end of this list (optional operation).

    Node<E> currentNode = this.head;
    Node<E> nodeToAppend;

    if (currentNode == null) {
      this.head = new Node<E>(e);
      return true;
    }

    while (currentNode.next != null) {
      currentNode = currentNode.next;
    }

    nodeToAppend = new Node<E>(e);
    currentNode.next = nodeToAppend;
    return true;
  }

  // Test this and check for possible edge cases.
  public void add(int index, E e) {
    // Inserts the specified element at the specified position in this list (optional operation).

    int currentIndex = 0;
    Node<E> currentNode = this.head;
    Node<E> nodeToInsert;

    while (currentIndex < index - 1) {
      currentIndex++;
      currentNode = currentNode.next;
    }

    nodeToInsert = new Node<E>(e);
    nodeToInsert.next = currentNode.next;
    currentNode.next = nodeToInsert;

    // Think about error cases to handle them
  }

}
