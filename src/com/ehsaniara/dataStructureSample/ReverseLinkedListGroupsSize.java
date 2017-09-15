package com.ehsaniara.dataStructureSample;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * <p>
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * <p>
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 * <p>
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL.
 */
public class ReverseLinkedListGroupsSize {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

       /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        ReverseLinkedListGroupsSize reverseLinkedListGroupsSize = new ReverseLinkedListGroupsSize();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        reverseLinkedListGroupsSize.push(9);
        reverseLinkedListGroupsSize.push(8);
        reverseLinkedListGroupsSize.push(7);
        reverseLinkedListGroupsSize.push(6);
        reverseLinkedListGroupsSize.push(5);
        reverseLinkedListGroupsSize.push(4);
        reverseLinkedListGroupsSize.push(3);
        reverseLinkedListGroupsSize.push(2);
        reverseLinkedListGroupsSize.push(1);

        System.out.println("Given Linked List");
        reverseLinkedListGroupsSize.printList();

        reverseLinkedListGroupsSize.head = reverseLinkedListGroupsSize.reverse(reverseLinkedListGroupsSize.head, 3);

        System.out.println("Reversed list");
        reverseLinkedListGroupsSize.printList();
    }
}
