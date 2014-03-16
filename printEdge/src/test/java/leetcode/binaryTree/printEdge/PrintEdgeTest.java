package leetcode.binaryTree.printEdge;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class PrintEdgeTest extends TestCase {
	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int maxSize = 15;

		Node<Integer> root = generateNode(1, maxSize);

		PrintEdge.print(root);
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
