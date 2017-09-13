package com.ehsaniara.dataStructureSample.SingleLinkedList;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class LinkedList {

    Node head;
    private int listCount;

    public LinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data) {
        //specified element to the end of this list.
        Node temp = new Node(data);
        Node current = head;
        // starting at the head node, crawl to the end of the list
        while (current.next != null) {
            current = current.next;
        }
        // the last node's "next" reference set to our new node
        current.next = temp;
        listCount++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.next != null; i++) {
            current = current.next;
        }
        // set the new node's next-node reference to this node's next-node reference
        temp.next = current.next;
        // now set this node's next-node reference to the new node
        current.next = temp;
        listCount++;// increment the number of elements variable
    }

    public Object get(int index) {
        // index must be 1 or higher
        if (index <= 0)
            return null;

        Node current = head.next;
        for (int i = 1; i < index; i++) {
            if (current.next == null)
                return null;

            current = current.next;
        }
        return current.next;
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
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
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
