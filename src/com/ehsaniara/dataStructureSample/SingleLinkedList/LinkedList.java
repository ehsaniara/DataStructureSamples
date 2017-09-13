package com.ehsaniara.dataStructureSample.SingleLinkedList;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class LinkedList {

    Node head;

    //insert at the head
    public void push(Object data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

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

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.show();
        linkedList.append(5);
        linkedList.show();
        linkedList.push(6);
        linkedList.show();
        linkedList.insertAfter(linkedList.head.next, 7);
        linkedList.show();
        linkedList.deleteNode(2); // Delete node at position 6
        linkedList.show();
    }

    private class Node {
        Node next;
        Object data;

        Node(Object data) {
            next = null;
            this.data = data;
        }
    }
}
