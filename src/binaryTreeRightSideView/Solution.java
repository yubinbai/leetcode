import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		} else {
			result.add(root.val);
		}

		List<TreeNode> curr, next, swap;
		curr = new ArrayList<TreeNode>();
		curr.add(root);
		next = new ArrayList<TreeNode>();
		while (!curr.isEmpty()) {
			for (TreeNode e : curr) {
				if (e.left != null) next.add(e.left);
				if (e.right != null) next.add(e.right);
			}
			if (next.isEmpty()) {
				break;
			} else {
				result.add(next.get(next.size() - 1).val);
				swap = curr;
				curr = next;
				next = swap;
				next.clear();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		System.out.println(s.rightSideView(root));
	}
}