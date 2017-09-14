package com.ehsaniara.dataStructureSample.QueueArray;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class QueueArray {
    int front, rear, size;
    int capacity;
    int array[];

    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];

    }


    boolean isFull(QueueArray queueArray) {
        return (queueArray.size == queueArray.capacity);
    }

    boolean isEmpty(QueueArray queueArray) {
        return (queueArray.size == 0);
    }

    // add an item to the queue
    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }

    // remove an item from queue
    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    //  get front
    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    // get rear
    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(1000);

        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(40);

        System.out.println(queueArray.dequeue() +
                " dequeued from queueArray\n");

        System.out.println("Front item is " +
                queueArray.front());

        System.out.println("Rear item is " +
                queueArray.rear());
    }
}
