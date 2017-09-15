package com.ehsaniara.dataStructureSample.Test2;

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    Node() {
    }
}

class GfG {
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


    public static void main(String[] args) {
        GfG list1 = new GfG();
        list1.push(8);
        list1.push(6);
        list1.push(8);
        list1.push(8);
        list1.show();

        GfG list2 = new GfG();
        list2.push(0);
        list2.push(4);
        list2.push(4);
        list2.push(4);
        list2.show();

        GfG linkedList = new GfG();


        linkedList.head = linkedList.addTwoLists(list1.head, list2.head);
        linkedList.show();

    }

    Node addTwoLists(Node first, Node second) {
        // Your code here
        Node result = null;
        Node current = null;

        Node currentFirst = first;
        Node currentSecond = second;

        while (currentFirst != null || currentSecond != null) {

            int a = currentFirst != null ? currentFirst.data : 0;
            int b = currentSecond != null ? currentSecond.data : 0;

            int sum = add(a, b);

            result = append(result,sum);


            if (currentFirst != null)
                currentFirst = currentFirst.next;

            if (currentSecond != null)
                currentSecond = currentSecond.next;

        }

        while (carryer > 0) {
            int sum = carryer;
            if (sum > 9) {
                carryer = sum / 10;
                sum = sum % 10;

            } else {
                carryer = 0;
            }

            current = new Node(sum);
            current.next = result;
            result = current;
        }




        return result;
    }

    public Node append(Node result, int data) {
        Node temp = new Node(data);
        if (result == null) {
            result = temp;
        } else {
            Node current = result;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
        return result;
    }

    int carryer = 0;

    int add(int a, int b) {
        int sum = carryer + a + b;

        if (sum > 9) {
            carryer = sum / 10;
            sum = sum % 10;
        } else {
            carryer = 0;
        }

        return sum;
    }
}