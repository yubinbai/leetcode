package leetcode.problem.levelOrder;

import java.util.LinkedList;

/**
 * Print a binary tree in level order
 * 
 */
public class LevelOrder {

	/**
	 * Using two queues, print the binary tree in level order
	 * 
	 * @param root
	 */
	public static void print(Node<Integer> root) {
		if (root == null)
			return;
		LinkedList<Node<Integer>> currentLevel = new LinkedList<Node<Integer>>();
		LinkedList<Node<Integer>> nextLevel = new LinkedList<Node<Integer>>();

		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			Node<Integer> currNode = currentLevel.poll();
			if (currNode != null) {
				System.out.print(currNode.value + " ");
				nextLevel.add(currNode.leftChild);
				nextLevel.add(currNode.rightChild);
			}
			if (currentLevel.isEmpty()) {
				System.out.println();
				LinkedList<Node<Integer>> swap = currentLevel;
				currentLevel = nextLevel;
				nextLevel = swap;
			}
		}

	}

}
