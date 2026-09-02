import java.util.*;

class Three {

    static class Node {
        int data;
        Node left;
          Node right;

        Node(int data) {
            this.data = data;
        }
    }

 static void inorder(Node root, ArrayList<Integer> values) {

        if (root == null) {
            return;
        }

        inorder(root.left, values);



          values.add(root.data);

        inorder(root.right, values);
    }

    static int kthSmallest(Node root, int k) {

          ArrayList<Integer> values = new ArrayList<>();

        inorder(root, values);


        return values.get(k - 1);
    }

static int kthLargest(Node root, int k) {

        ArrayList<Integer> values = new ArrayList<>();



        inorder(root, values);

           return values.get(values.size() - k);
    }

    public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);


        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int k = 3;

        System.out.println("kth smallest: " + kthSmallest(root, k));

        System.out.println("kth largest: " + kthLargest(root, k));
    }
}