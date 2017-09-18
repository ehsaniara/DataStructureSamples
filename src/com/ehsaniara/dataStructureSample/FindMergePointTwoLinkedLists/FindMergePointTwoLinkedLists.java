package com.ehsaniara.dataStructureSample.FindMergePointTwoLinkedLists;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * Write a function to get the intersection point of two Linked Lists.
 * There are two singly linked lists in a system. By some programming error the end node of one of the linked list got linked into the second list, forming a inverted Y shaped list. Write a program to get the point where two linked list merge.
 */
class Node {
    int data;
    Node next;
}

public class FindMergePointTwoLinkedLists {

    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.
        Node currentA = headA;
        Node currentB = headB;

        //Do till the two nodes are the same
        while (currentA != currentB) {
            //currentA
            if (currentA.next == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            //currentB
            if (currentB.next == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }
        return currentB.data;
    }
}
