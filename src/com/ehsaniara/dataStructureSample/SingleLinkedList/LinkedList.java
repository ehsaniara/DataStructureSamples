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

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.show();
        System.out.println();
        linkedList.append(5);
        linkedList.show();
        System.out.println();
        linkedList.push(6);
        linkedList.show();
        System.out.println();
        linkedList.insertAfter(linkedList.head.next, 7);
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
