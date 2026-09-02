class One {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

static Node delete(Node root, int value) {

        if (root == null) {
            return null;
            
        }

        if (value < root.data) {

              root.left = delete(root.left, value);
        }

      
        else if (value > root.data) {


               root.right = delete(root.right, value);
        }

        else {

            if (root.left == null && root.right == null) {



                return null;
            }

            if (root.left == null) {


                   return root.right;
            }

            if (root.right == null) {


                return root.left;
            }

            int smallest = findSmallest(root.right);

            root.data = smallest;

            root.right = delete(root.right, smallest);
        }

        return root;
    }

    static int findSmallest(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        root = delete(root, 50);

        inorder(root);
    }
}