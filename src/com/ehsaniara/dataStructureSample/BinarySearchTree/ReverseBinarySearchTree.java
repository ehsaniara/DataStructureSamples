package com.ehsaniara.dataStructureSample.BinarySearchTree;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class ReverseBinarySearchTree {
    public Node root;

    public static void main(String[] args) {
        ReverseBinarySearchTree b = new ReverseBinarySearchTree();
        int[] data = {3, 8, 1, 4, 6, 2, 10, 9, 20, 25, 15, 16};
        for (int i : data) {
            b.insert(i);
        }

        System.out.println("Binary Search Tree : ");
        b.show(b.root);
        System.out.println();

        b.reverse(b.root);

        System.out.println("Reverse Binary Search Tree : ");
        b.show(b.root);
        System.out.println();
    }

    void reverse(Node root) {
        if (root != null) {
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            reverse(root.left);
            reverse(root.right);
        }
    }

    void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        //start from the current and compare root.data with id
        Node curr = root;
        Node parent = null;
        while (true) {
            parent = curr;
            if (id < curr.data) {
                curr = curr.left;
                if (curr == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                curr = curr.right;
                if (curr == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    //Show tree from this Node
    public void show(Node root) {
        if (root != null) {
            show(root.left);
            System.out.print(" " + root.data);
            show(root.right);
        }
    }


    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}


