package com.ehsaniara.dataStructureSample.QuickSortOnDoublyLinkedList;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

public class LinkedList {
    Node head;

    Node lastNode(Node node) {
        while (node.next != null)
            node = node.next;
        return node;
    }

    Node partition(Node l, Node h) {
        // set pivot as h element
        int x = h.data;

        // similar to i = l-1 for array implementation
        Node i = l.prev;

        // Similar to "for (int j = l; j <= h- 1; j++)"
        for (Node j = l; j != h; j = j.next) {
            if (j.data <= x) {
                // Similar to i++ for array
                i = (i == null) ? l : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? l : i.next;  // Similar to i++
        int temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }

    /* A recursive implementation of quick_sort for linked list */
    void linkedListQuickSort(Node l, Node h) {
        if (h != null && l != h && l != h.next) {
            Node temp = partition(l, h);
            linkedListQuickSort(l, temp.prev);
            linkedListQuickSort(temp.next, h);
        }
    }

    // The main function to sort a linked list. It mainly calls _quickSort()
    public void quickSort(Node node) {
        // Find last node
        Node head = lastNode(node);

        // Call the recursive IterativeQuickSort
        linkedListQuickSort(node, head);
    }

    // A utility function to print contents of arr
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(int data) {
        Node newNode = new Node(data);     /* allocate node */

        // if head is null, head = new_Node
        if (head == null) {
            head = newNode;
            return;
        }

        /* link the old list off the new node */
        newNode.next = head;

        /* change prev of head node to new node */
        head.prev = newNode;

        /* since we are adding at the beginning, prev is always NULL */
        newNode.prev = null;

        /* move the head to point to the new node */
        head = newNode;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);
        list.push(3);
        list.push(24);
        list.push(1);
        list.push(10);

        System.out.println("Linked List before sorting ");
        list.printList(list.head);
        System.out.println();
        System.out.println("Linked List after sorting");
        list.quickSort(list.head);
        list.printList(list.head);

    }

}
