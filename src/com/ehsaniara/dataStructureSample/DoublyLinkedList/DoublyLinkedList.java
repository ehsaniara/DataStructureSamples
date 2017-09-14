package com.ehsaniara.dataStructureSample.DoublyLinkedList;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class DoublyLinkedList {

    public Node head;

    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    //Add a node at the front
    public void push(int newData) {
        Node new_Node = new Node(newData);

        new_Node.next = head;
        new_Node.prev = null;

        if (head != null)
            head.prev = new_Node;

        head = new_Node;
    }

    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertAfter(Node prevNode, int newData) {

        if (prevNode == null) {
            System.err.println("The given previous node cannot be NULL ");
            return;
        }

        Node newNode = new Node(newData);

        newNode.next = prevNode.next;


        prevNode.next = newNode;

        newNode.prev = prevNode;

        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    public void append(int new_data) {
        Node newNode = new Node(new_data);

        Node last = head;/* used in step 5*/

        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = newNode;

        newNode.prev = last;
    }


    public void printList(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        dll.append(4);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        dll.InsertAfter(dll.head.next, 8);


        System.out.println("Created DLL is: ");
        dll.printList(dll.head);
    }

}
