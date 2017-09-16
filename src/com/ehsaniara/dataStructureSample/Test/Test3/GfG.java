package com.ehsaniara.dataStructureSample.Test.Test3;


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


    Node addTwoLists(Node first, Node second) {
        return sumList(first, second, 0);
    }

    public Node sumList(Node first, Node second, int carry) {
        if (first == null && second == null && carry == 0) return null;
        int sum = carry;
        if (first != null) {
            sum += first.data;
        }
        if (second != null) {
            sum += second.data;
        }
        if (sum >= 10) carry = 1;
        else carry = 0;

        sum = sum % 10;
        Node result = new Node(sum);
        result.next = sumList(first == null ? null : first.next,
                second == null ? null : second.next, carry);

        return result;
    }

    //insert at the head
    public void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
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
}