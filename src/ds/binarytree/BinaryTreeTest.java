package ds.binarytree;

public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.insert(5, "e");
        bt.insert(3, "b");
        bt.insert(2, "d");
        bt.insert(4, "c");
        bt.insert(7, "c");
        bt.insert(6, "g");
        bt.insert(8, "h");

       // System.out.println(bt.find(2));

        // bt.printInOrderTraversal();
        //bt.printPreOrderTraversal();
        bt.printPostOrderTraversal();

    }
}
