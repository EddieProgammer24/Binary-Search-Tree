// Create a Helper Class
class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BST {

    Node root; // root of BST

    BST() {
        root = null;
    }

    Node insertRec(Node root, int data) {
        // insert into tree
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) // insert left child
            root.left = insertRec(root.left, data);
        else if (data > root.data) // insert right child
            root.right = insertRec(root.right, data);

        return root;
    }

    // helper functions
    // call insertRec from main
    void insert(int data) {
        root = insertRec(root, data);
        System.out.println("New item inserted into tree => " +
                data);
    }
    // perform a postorder traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data);
        }
    }

    // Returns the max value in a binary tree
    static int findMax(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }
    public static void main(String[] args) {

        BST tree = new BST(); // create tree object
        /* Tree operations ************************/
        // build the tree
        // insert into tree
        tree.insert(27);
        tree.insert(13);
        tree.insert(42);
        tree.insert(6);
        tree.insert(17);
        tree.insert(33);
        tree.insert(48);
        // print max element of tree
        System.out.println("\nMaximum element is " +
                tree.findMax(tree.root));
        // print postorder of tree
        System.out.println("\nPostorder -> ");
        tree.postorderRec(tree.root);
    }
}
