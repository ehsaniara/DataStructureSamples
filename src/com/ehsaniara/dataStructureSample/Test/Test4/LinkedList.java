package com.ehsaniara.dataStructureSample.Test.Test4;

/**
 * Created by Jason Ara (Jay.Ara) on 9/16/17.
 * From https://www.exapot.com
 */

/**
 * Rearrange a given linked list in-place.
 Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …

 You are required do this in-place without altering the nodes’ values.

 Examples:
 Input:  1 -> 2 -> 3 -> 4
 Output: 1 -> 4 -> 2 -> 3

 Input:  1 -> 2 -> 3 -> 4 -> 5
 Output: 1 -> 5 -> 2 -> 4 -> 3

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
    Node head;

    void arrange() {

        int counter = 0, s = size(), left, right;
        Node tmp = null;
        while (head != null) {
            left = counter;
            right = s - (counter + 1);
            tmp = push(getAtIndex(left).data, tmp);

            if (left >= right)
                break;

            tmp = push(getAtIndex(right).data, tmp);
            counter++;
        }
        System.out.println();
        head = tmp;

    }

    Node push(int data, Node h) {
        Node newNode = new Node(data);
        newNode.next = h;
        h = newNode;
        return h;
    }

    int size() {
        int c = 0;
        Node temp = head;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
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

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }

    Node getAtIndex(int index) {
        int counter = 0;
        Node current = head;
        while (current != null) {
            if (counter++ == index)
                return current;
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = {5, 4, 3, 2, 1};
        for (int item : arr) {
            list.head = list.push(item, list.head);
        }

        list.show();

        list.arrange();

        list.reverse();

        list.show();
    }
}
