import java.util.*;

class One {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static void printLeft(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            System.out.print(root.data + " ");
            printLeft(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            printLeft(root.right);
        }
    }

    static void printLeaves(Node root) {
        if (root == null) {
            return;
        }

        printLeaves(root.left);

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }

        printLeaves(root.right);
    }

    static void printRight(Node root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            printRight(root.right);
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            printRight(root.left);
            System.out.print(root.data + " ");
        }
    }

    static void boundary(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        printLeft(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRight(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        boundary(root);
    }
}