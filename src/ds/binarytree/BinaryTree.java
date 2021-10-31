package ds.binarytree;

public class BinaryTree {

    class Node{
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        //use recursion to find the smallest value (on the left)
        public Node min(){
            if(left == null){
                return this;
            } else{
                return left.min();
            }
        }
    }

    Node root;

    //constructor
    public BinaryTree() {
        root = null;
    }

    //find
    public String find(int key) {

        //First find the node
        Node node = find(root, key);

        //then return the value
        return node == null ? null : node.value;

    }

    private Node find(Node node, int key) {
        if(node == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else if (key > node.key) {
            return find(node.right ,key);
        }

        return null;
    }

    //Insert
    public void insert(int key, String value) {
        root = insertItem(root, key, value);
    }

    public Node insertItem(Node node, int key, String value) {
        //create a new node
        Node newNode = new Node(key, value);

        //if null, set it here and we are done
        if (node == null) {
            node = newNode;
            return node;
        }

        // else walk until you find a null node
        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        } else {
            node.right = insertItem(node.right, key, value);
        }

        //we have returned from the bottom
        //return our fully constructed tree.
        return node;
    }

    public Node findMin(Node node) {
        return node.min();
    }


    public void delete(int key) {

        root = delete(root, key);

    }

    //delete
    public Node delete(Node node, int key) {

        //this portion tries to locate the node in the tree
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        //at this step, we found the node we want to delete
        } else {
            //1. no child
            if ( node.left == null && node.right == null) {
                node = null;
            }

            //2. one child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }

            //3: two children
            else {
                //find the minimum node on the right (could also max the left...)
                Node minRight = findMin(node.right);

                //Duplicate it by copying its values here
                node.key = minRight.key;
                node.value = minRight.value;

                //now go ahead and delete the node we just duplicated (same key)
                node.right = delete(node.right, node.key);
            }
        }

        return node;
    }


    //In order DFS
    public void printInOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.key);
            inOrderTraversal(node.right);
        }
    }


    //Pre Order DFS
    public void printPreOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if(node != null) {
            System.out.println(node.key);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    //Post Order DFS
    public void printPostOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.key);
        }

    }



}
