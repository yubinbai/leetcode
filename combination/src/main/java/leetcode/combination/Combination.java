package leetcode.combination;

import java.util.Stack;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 */
public class Combination {

	int count = 0;
	Stack<Integer> current = new Stack<Integer>();

	public int countCombinations(int n, int k) {
		this.count = 0;
		combine(n, k, 1);
		return count;
	}

	private void combine(int n, int k, int position) {
		if (k == 0) {
			this.count++;
			return;
		}

		// from start to end
		for (int i = position; i <= n; i++) {
			current.push(i);
			combine(n, k - 1, i + 1);
			current.pop();
		}
	}
}
