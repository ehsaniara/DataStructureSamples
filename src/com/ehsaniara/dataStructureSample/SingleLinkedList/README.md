# Linked List Data Structure
Introduction

Like arrays, Linked List is a linear data structure. Unlike arrays, linked list elements are not stored at contiguous location; the elements are linked using pointers.

![alt text](material/Linkedlist.png)


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

### 1) At the Head
![alt text](material/LinkedlistInsertAtHead.png)

````
public void push(Object data) {
    Node temp = new Node(data);
    temp.next = head;
    head = temp;
}

````
### 2) After a given node.
![alt text](material/LinkedlistInsertAfter.png)

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
### 3) At the tail.
![alt text](material/LinkedlistInsertAtTail.png)

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
## Deleting a node
To delete a node from linked list, we need to do following steps.
1) Find previous node of the node to be deleted.
2) Changed next of previous node.
3) Free memory for the node to be deleted.

![alt text](material/LinkedlistDelete.png)

````
void deleteNode(Object value) {
    Node temp = head;
    Node previousNode = null;

    // If head node itself holds the key to be deleted
    if (temp != null && temp.data == value) {
        head = temp.next; // Changed head
        return;
    }

    // Search for the value to be deleted, keep track of the
    while (temp != null && temp.data != value) {
        // previous node as we need to change temp.next
        previousNode = temp;
        temp = temp.next;
    }

    // value not exist
    if (temp == null) return;

    previousNode.next = temp.next;
}
//By Index
void deleteNodeAt(int index) {
        if (head == null)
            return;

        Node previousNode = head;

        // remove head
        if (index == 0) {
            head = head.next;
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; previousNode != null && i < index - 1; i++)
            previousNode = previousNode.next;

        // If position is out of range's number of Nodes
        if (previousNode == null || previousNode.next == null)
            return;

        //PrevNode.next is deleteNode.next
        previousNode.next = previousNode.next.next;  // Unlink the deleted node from list
    }
````