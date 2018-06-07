package mylist;

import java.util.List;

public class MyList<E> {

  // MyList properties
  private Node<E> head;

  private static class Node<E> {
    // Private Node class that will represent each
    // item in a MyList instance

    private E element;
    private Node<E> next;

    public Node(E element) {
      this.element = element;
    }
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
