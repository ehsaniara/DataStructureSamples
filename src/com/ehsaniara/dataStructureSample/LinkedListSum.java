package com.ehsaniara.dataStructureSample;


/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class LinkedListSum {


    private static class Node {
        Node next;
        int data;

        Node(int data) {
            next = null;
            this.data = data;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.push(4);
        linkedList1.push(5);
        System.out.println("List A:");
        linkedList1.show();

        int sum1 = linkedList1.convertToReversInt();



        LinkedList linkedList2 = new LinkedList();
        linkedList2.push(3);
        linkedList2.push(4);
        linkedList2.push(5);
        System.out.println("List B:");
        linkedList2.show();

        int sum2 = linkedList2.convertToReversInt();


        int total = sum1 + sum2;

        LinkedList result = new LinkedList();

        result.convertToLinkedList(total);
        System.out.println("Result:");
        result.show();

    }

    private static class LinkedList {
        Node head;

        //insert at the head
        public void push(int data) {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }

        public void show() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                current = current.next;
                if (current != null)
                    System.out.print("->");
            }
            System.out.println();
        }

        public void reverse() {
            Node prev = null;
            Node current = head;
            while (current != null) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        public int convertToReversInt() {
            int count = 0;
            int sum = 0;

            Node current = head;
            while (current != null) {


                sum += Math.pow(10, count) * current.data;
                count++;
                current = current.next;
            }
            return sum;
        }

        public void convertToLinkedList(int sum) {
            head = null;
            String temp = String.valueOf(sum);

            int[] arr = new int[temp.length()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(temp.charAt(i) + "");

                push(arr[i]);
            }
        }
    }

}
