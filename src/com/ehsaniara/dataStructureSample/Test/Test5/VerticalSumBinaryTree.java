package com.ehsaniara.dataStructureSample.Test.Test5;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 *

 Vertical Sum in Binary Tree | Set 2 (Space Optimized)
 Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines.

 Examples:

        1
      /  \
     2    3
   / \   / \
 4   5  6   7

 The tree has 5 vertical lines

 Vertical-Line-1 has only one node 4 => vertical sum is 4
 Vertical-Line-2: has only one node 2=> vertical sum is 2
 Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
 Vertical-Line-4: has only one node 3 => vertical sum is 3
 Vertical-Line-5: has only one node 7 => vertical sum is 7

 So expected output is 4, 2, 12, 3 and 7

 */
class Node {
    int data, vId = 0;
    Node left;
    Node right;


    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    Node insertLeft(int id) {
        Node newNode = new Node(id);
        newNode.vId = this.vId + 1;
        left = newNode;
        return left;
    }

    Node insertRight(int id) {
        Node newNode = new Node(id);
        newNode.vId = this.vId - 1;
        right = newNode;
        return right;
    }
}

public class VerticalSumBinaryTree {

    Node root;
    int sum = 0, vId = 0;

    public void show(Node current) {
        if (current != null) {
            show(current.left);
            sum = 0;
            vId = current.vId;
            System.out.println("Node:" + current.data + " has Sum:" + calculate(root));
            show(current.right);
        }
    }

    int calculate(Node current) {
        if (current != null) {
            calculate(current.left);
            if (current.vId == vId)
                sum += current.data;
            calculate(current.right);
        }
        return sum;
    }

    public static void main(String arg[]) {
        VerticalSumBinaryTree b = new VerticalSumBinaryTree();
        b.root = new Node(1);
        Node node2 = b.root.insertLeft(2);
        Node node3 = b.root.insertRight(3);


        Node node4 = node2.insertLeft(4);
        Node node5 = node2.insertRight(5);

        Node node6 = node3.insertLeft(6);
        Node node7 = node3.insertRight(7);
        b.show(b.root);

    }
}
