package leetcode.problem.levelOrder;

public class Node<Key> {

	Key value;
	public Node<Key> parent, leftChild, rightChild;

	/**
	 * Use a key value to construct a tree node
	 * 
	 * @param value
	 */
	public Node(Key value) {
		super();
		this.value = value;
		// blank all connections
		parent = leftChild = rightChild = null;
	}
}
