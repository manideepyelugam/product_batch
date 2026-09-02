class Two {

static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

static boolean isBST(Node root) {

           if (root == null) {
         
         
            return true;
        }

        if (root.left != null) {
            
            int leftMax = findMax(root.left);

            if (leftMax >= root.data) {
            
            
                return false;
            }
        }

        if (root.right != null) {
                 int rightMin = findMin(root.right);

              if (rightMin <= root.data) {
              
              
                return false;

            }
        }

         return isBST(root.left) && isBST(root.right);
    }

    static int findMax(Node root) {

        if (root == null) {

            return Integer.MIN_VALUE;

        }

        int leftMax = findMax(root.left);


        int rightMax = findMax(root.right);

         return Math.max(
               root.data, Math.max(leftMax, rightMax)
        );
    }

    static int findMin(Node root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);


         int rightMin = findMin(root.right);

        return Math.min(

            root.data,Math.min(leftMin, rightMin)
        );
    }

    public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println(isBST(root));
    }
}