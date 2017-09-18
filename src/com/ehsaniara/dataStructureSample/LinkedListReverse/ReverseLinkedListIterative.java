package com.ehsaniara.dataStructureSample.LinkedListReverse;

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

public class ReverseLinkedListIterative {

    Node head;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void reverse() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node getAtIndex(int index) {
        int counter = 0;
        Node current = head;
        while (current != null) {
            if (counter++ == index)
                return current;
            current = current.next;
        }
        return null;
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ReverseLinkedListIterative list = new ReverseLinkedListIterative();
        int[] arr = {60, 50, 40, 30, 20, 10};
        for (int item : arr) {
            list.push(item);
        }

        list.show();

        list.reverse();

        list.show();
    }
}
