package leetcode.subset;

import java.util.Stack;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 */
public class Subset {
	Stack<Integer> current = new Stack<Integer>();
	int count = 0;

	public int countSubsets(int[] data) {
		this.count = 0;
		subset(data, 0);
		return this.count;
	}

	private void subset(int[] data, int position) {
		// current stack is a subset
		this.count++;

		for (int i = position; i < data.length; i++) {
			current.push(data[i]);
			subset(data, i + 1);
			current.pop();
		}
	}
}
