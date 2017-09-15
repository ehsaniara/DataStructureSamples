package com.ehsaniara.dataStructureSample.BinarySearchTree;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class BinarySearchTree {

    //Top Element of tree
    public Node root;


    public static void main(String arg[]) {
        BinarySearchTree b = new BinarySearchTree();
        int[] data = {3, 8, 1, 4, 6, 2, 10, 9, 20, 25, 15, 16};
        for (int i : data) {
            b.insert(i);
        }
        System.out.println("Binary Search Tree : ");
        b.displayTree();
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("do we have Node with value 8? " + b.exist(8));

        System.out.println("-------------------------------------------------");
        System.out.println("Delete Node with no children (2) : " + b.delete(2));
        b.displayTree();
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("Delete Node with one child (4) : " + b.delete(4));
        b.displayTree();
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println(" Delete Node with Two children (10) : " + b.delete(10));
        b.displayTree();

    }


    public BinarySearchTree() {
        this.root = null;
    }


    public boolean exist(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }


    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        //When deleted node has no children (Leaf Node)
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //When node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            //has both Left and Right
        } else {

            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        if (successor != deleteNode.right) {
            // if it does have the right child, add it to the left of successorParent.
            successorParent.left = successor.right;

            //replace the delete Node by successor
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        //start from the current and compare root.data with id
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void displayTree() {
        show(root);
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