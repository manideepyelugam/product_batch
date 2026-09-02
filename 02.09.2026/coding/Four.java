class Four {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean isBalanced(Node root) {

        if (root == null) {

            return true;

        }

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {


            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    static int height(Node root) {

        if (root == null) {


            return 0;
        }

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println(isBalanced(root));
    }
}