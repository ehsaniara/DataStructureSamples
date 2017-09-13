# Linked List Data Structure
Introduction

Like arrays, Linked List is a linear data structure. Unlike arrays, linked list elements are not stored at contiguous location; the elements are linked using pointers.

![alt text](Linkedlist.png)


### Why Linked List?
Arrays can be used to store linear data of similar types, but arrays have following limitations.
1) The size of the arrays is fixed: So we must know the upper limit on the number of elements in advance. Also, generally, the allocated memory is equal to the upper limit irrespective of the usage.
2) Inserting a new element in an array of elements is expensive, because room has to be created for the new elements and to create room existing elements have to shifted.

````
public class LinkedList {

    Node head;

    private class Node {
        Node next;
        Object data;

        Node(Object data) {
            next = null;
            this.data = data;
        }
    }
}

````

## Add new Node into the Linked List?
A node can be added in three ways
1) At the Head (push)
2) After a given node. (insertAfter)
3) At the tail. (append)

###1) At the Head
![alt text](LinkedlistInsertAtHead.png)

````
public void push(Object data) {
    Node temp = new Node(data);
    temp.next = head;
    head = temp;
}

````
###2) After a given node.
![alt text](LinkedlistInsertAfter.png)

````
public void insertAfter(Node node, Object data) {
    if (node == null) {
        System.out.println("node cannot be null");
        return;
    }
    Node temp = new Node(data);
    temp.next = node.next;

    //make next of prev_node as new_node
    node.next = temp;
}

````
###3) At the tail.
![alt text](LinkedlistInsertAtTail.png)

````
 public void append(Object data) {
    Node temp = new Node(data);
    if (head == null) {
        push(data);
    } else {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
    }
}

````