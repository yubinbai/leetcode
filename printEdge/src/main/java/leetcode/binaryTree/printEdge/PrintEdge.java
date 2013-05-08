package leetcode.binaryTree.printEdge;

/**
 * Print all edge nodes of a complete binary tree anti-clockwise. That is all
 * the left most nodes starting at root, then the leaves left to right and
 * finally all the rightmost nodes. In other words, print the boundary of the
 * tree.
 * 
 * Variant: Print the same for a tree that is not complete.
 * 
 */
public class PrintEdge {

	static void printLeftEdges(Node<Integer> p, boolean print) {
		if (p == null)
			return;
		if (print || (p.leftChild == null && p.rightChild == null))
			System.out.print(p.value + " ");
		printLeftEdges(p.leftChild, print);
		printLeftEdges(p.rightChild, false);
	}

	static void printRightEdges(Node<Integer> p, boolean print) {
		if (p == null)
			return;
		printRightEdges(p.leftChild, false);
		printRightEdges(p.rightChild, print);
		if (print || (p.leftChild == null && p.rightChild == null))
			System.out.print(p.value + " ");
	}

	public static void print(Node<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		printLeftEdges(root.leftChild, true);
		printRightEdges(root.rightChild, true);

	}
}
