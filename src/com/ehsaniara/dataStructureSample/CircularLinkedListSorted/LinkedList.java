package com.ehsaniara.dataStructureSample.CircularLinkedListSorted;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {
    Node head = null;

    void sortedInsert(Node newNode) {
        Node current = head;

        // Case 1 of the above algo
        if (current == null) {
            newNode.next = newNode;
            head = newNode;
        }

        // Case 2 of the above algo
        else if (current.data >= newNode.data) {
            /* If value is smaller than head's value then
             we need to change next of last node */
            while (current.next != head)
                current = current.next;

            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }

        // Case 3 of the above algo
        else {

            /* Locate the node before the point of insertion */
            while (current.next != head &&
                    current.next.data < newNode.data)
                current = current.next;

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Utility method to print a linked list
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            //Stop the infinity Loop
            if (current == head)
                break;
        }
        System.out.println();
    }

    // Driver code to test above
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        int arr[] = {12, 56, 2, 11, 1, 90};

        for (int item : arr) {
            list.sortedInsert(new Node(item));
        }

        list.printList();
    }

}
