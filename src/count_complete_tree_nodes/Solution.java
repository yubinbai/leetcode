import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int h = 0;
		TreeNode curr = root;
		while (curr.left != null) {
			curr = curr.left;
			h++;
		}
		if (h == 0) return 1;
		int low = 1 << h, high = 1 << (h + 1);
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (valid(root, mid, h)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low - 1;
	}
	private boolean valid(TreeNode root, int pos, int h) {
		TreeNode curr = root;
		for (int i = h - 1; i >= 0; i--) {
			if ((pos & (1 << i)) > 0) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		return curr != null;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(0);

		System.out.println(s.countNodes(root));

		root.left = new TreeNode(1);
		System.out.println(s.countNodes(root));

		root.right = new TreeNode(2);
		System.out.println(s.countNodes(root));
	}
}