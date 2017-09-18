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


    Node append(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        return head;
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


    void deleteNodeAt(int index) {
        if (head == null)
            return;

        Node previousNode = head;

        // remove head
        if (index == 0) {
            head = head.next;
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; previousNode != null && i < index - 1; i++)
            previousNode = previousNode.next;

        // If position is out of range's number of Nodes
        if (previousNode == null || previousNode.next == null)
            return;

        //PrevNode.next is deleteNode.next
        previousNode.next = previousNode.next.next;  // Unlink the deleted node from list
    }

    //check if X is exist in the ReverseLinkedListIterative
    public boolean search(Object x) {
        Node current = head;
        while (current != null) {
            if (current.data == x)
                return true;
            current = current.next;
        }
        return false;
    }

    //swap the actual node not just its value
    public void swapNodes(Object x, Object y) {
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap both next
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }


    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void removeDuplicates() {
        if (head == null || head.next == null)
            return;

        Node current = head, checker;
        for (int i = 0; current != null; i++) {

            if (current.next != null) {
                //checker node is starts after current node
                checker = current.next;
                for (int j = i + 1; checker != null; j++) {
                    if (current.data == checker.data) {
                        deleteNodeAt(j);
                        removeDuplicates();
                        return;
                    }
                    checker = checker.next;
                }
            }
            current = current.next;
        }
    }

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
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
        linkedList.deleteNode(2); // Delete node at position 5
        linkedList.show();
        linkedList.deleteNodeAt(1); // Delete node at position 2
        linkedList.show();
        System.out.println("Linked List Size:" + linkedList.size());
        System.out.println("9 is Exist? " + linkedList.search(9));
        System.out.println("7 is Exist? " + linkedList.search(7));
        linkedList.swapNodes(4, 5);
        linkedList.show();
        linkedList.push(1);
        linkedList.push(1);
        linkedList.push(4);
        linkedList.push(1);
        linkedList.push(9);
        linkedList.append(9);
        linkedList.show();
        linkedList.removeDuplicates();
        linkedList.show();
        System.out.println("Linked List Index 2 is: " + linkedList.getAtIndex(2).data);
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
