package com.ehsaniara.dataStructureSample.MergingTwoSortedSinglyLinkedList;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists will be sorted in ascending order. Change the next pointers to obtain a single, merged linked list which also has data in ascending order. Either head pointer given may be null meaning that the corresponding list is empty.
 * <p>
 * Input Format
 * You have to complete the Node* MergeLists(Node* headA, Node* headB) method which takes two arguments - the heads of the two sorted linked lists to merge. You should NOT read any input from stdin/console.
 * <p>
 * Output Format
 * Change the next pointer of individual nodes so that nodes from both lists are merged into a single list. Then return the head of this merged list. Do NOT print anything to stdout/console.
 */
public class MergingTwoSortedSinglyLinkedList {

    Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method

        if (headA == null) return headB;
        if (headB == null) return headA;

        if (headA.data < headB.data) {
            headA.next = mergeLists(headA.next, headB);
            return headA;
        } else {
            headB.next = mergeLists(headB.next, headA);
            return headB;
        }

    }
}

class Node {
    int data;
    Node next;
}