package com.ehsaniara.dataStructureSample.BinaryTreeIsomorphism;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class BinaryTree {
    Node node1, node2;

    /* Given a binary tree, print its nodes in reverse level order */
    boolean isIsomorphic(Node root1, Node root2) {
        // Both roots are NULL, trees isomorphic by definition
        if (root1 == null && root2 == null)
            return true;

        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (root1 == null || root2 == null)
            return false;

        if (root1.data != root2.data)
            return false;

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been
        // "Flipped".
        // Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        return (isIsomorphic(root1.left, root2.left) &&
                isIsomorphic(root1.right, root2.right))
                || (isIsomorphic(root1.left, root2.right) &&
                isIsomorphic(root1.right, root2.left));
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        // Let us create trees shown in above diagram
        tree.node1 = new Node(1);
        tree.node1.left = new Node(2);
        tree.node1.right = new Node(3);
        tree.node1.left.left = new Node(4);
        tree.node1.left.right = new Node(5);
        tree.node1.right.left = new Node(6);
        tree.node1.left.right.left = new Node(7);
        tree.node1.left.right.right = new Node(8);

        tree.node2 = new Node(1);
        tree.node2.left = new Node(3);
        tree.node2.right = new Node(2);
        tree.node2.right.left = new Node(4);
        tree.node2.right.right = new Node(5);
        tree.node2.left.right = new Node(6);
        tree.node2.right.right.left = new Node(8);
        tree.node2.right.right.right = new Node(7);

        if (tree.isIsomorphic(tree.node1, tree.node2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right;
    }
}