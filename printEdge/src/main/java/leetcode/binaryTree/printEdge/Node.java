package leetcode.binaryTree.printEdge;


public class Node<Key> {

    public Key value;
    public Node<Key> parent, leftChild, rightChild;

    /**
     * Use a key value to construct a tree node
     * @param value
     */
    public Node(Key value) {
        super();
        this.value = value;
        // blank all connections
        parent = leftChild = rightChild = null;
    }
}