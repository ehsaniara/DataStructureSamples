package com.ehsaniara.dataStructureSample.BinaryTreeNoSiblingNodes;

import java.util.TreeSet;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(6);
        root.left = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(2);


        binaryTree.printSibling(root);
        System.out.println();
        System.out.println("-------------------");
        binaryTree.show(root);
    }

    TreeSet<Integer> list;


    void printSibling(Node node) {
        // Your code here
        list = new TreeSet<>();
        make(node);

        if (list.size() > 0) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        } else {
            System.out.print("-1");
        }
    }

    void make(Node node) {
        if (node != null) {
            make(node.left);
            make(node.right);

            if (node.right == null && node.left != null) {
                list.add(node.left.data);
            } else if (node.right != null && node.left == null) {
                list.add(node.right.data);
            }
        }
    }

    public void show(Node root) {
        if (root != null) {
            show(root.left);
            System.out.print(" " + root.data);
            show(root.right);
        }
    }
}