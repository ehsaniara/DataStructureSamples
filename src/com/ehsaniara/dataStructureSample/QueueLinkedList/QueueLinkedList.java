package com.ehsaniara.dataStructureSample.QueueLinkedList;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class QueueLinkedList {
    Node front, rear;

    public QueueLinkedList() {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void enqueue(int key) {

        // Create a new LL node
        Node temp = new Node(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    public Node dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead
        Node temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
        return temp;
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("DeQueued item is " + q.dequeue().key);
    }

    private class Node {
        int key;
        Node next;

        // constructor to create a new linked list node
        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }
}
