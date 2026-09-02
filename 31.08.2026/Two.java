import java.util.*;

public class Two {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void findLeft(Node root, int level, int target) {
        if (root == null) {
            return;
        }

        if (level == target) {
            System.out.print(root.data + " ");
            return;
        }

        findLeft(root.left, level + 1, target);
        findLeft(root.right, level + 1, target);
    }

    static void leftView(Node root) {

        int h = height(root);

        for (int level = 0; level < h; level++) {
            findLeft(root, 0, level);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);

        leftView(root);
    }
}