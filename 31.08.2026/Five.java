 import java.util.*;

class Five {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean findPath(Node root, int value, ArrayList<Integer> path) {

        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == value) {
            return true;
        }

        if (findPath(root.left, value, path)) {
            return true;
        }

        if (findPath(root.right, value, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> path = new ArrayList<>();

        findPath(root, 5, path);

        System.out.println(path);
    }
} 
