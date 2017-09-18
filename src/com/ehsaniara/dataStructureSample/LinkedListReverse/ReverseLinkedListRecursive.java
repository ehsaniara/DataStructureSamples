package com.ehsaniara.dataStructureSample.LinkedListReverse;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class ReverseLinkedListRecursive {
    Node head;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    Node reverseUtil(Node curr, Node prev) {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;
            return null;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }

    public static void main(String args[]) {
        ReverseLinkedListRecursive list = new ReverseLinkedListRecursive();
        int[] arr = {60, 50, 40, 30, 20, 10};
        for (int item : arr) {
            list.push(item);
        }

        list.show();

        list.reverseUtil(list.head, null);

        list.show();
    }
}
