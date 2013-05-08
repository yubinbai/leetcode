package leetcode.problem.levelOrder;

import junit.framework.TestCase;

/**
 * Print a binary tree in level order
 */
public class LevelOrderTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int maxSize = 31;

		Node<Integer> root = generateNode(1, maxSize);

		LevelOrder.print(root);
	}

	private Node<Integer> generateNode(int i, int maxSize) {
		if (i > maxSize)
			return null;
		else {
			Node<Integer> e = new Node<Integer>(i);
			e.leftChild = generateNode(2 * i, maxSize);
			e.rightChild = generateNode(2 * i + 1, maxSize);
			return e;
		}
	}
}
