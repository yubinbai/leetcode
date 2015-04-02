class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	ListNode curr;
	public TreeNode sortedListToBST(ListNode head) {
		curr = head;
		int size = 0;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		curr = head;
		return _makeBST(0, size - 1);
	}
	private TreeNode _makeBST(int low, int high) {
		if (low > high) return null;
		int mid = low + (high - low) / 2;
		TreeNode left = _makeBST(low, mid - 1);
		TreeNode root = new TreeNode(curr.val);
		curr = curr.next;
		root.left = left;
		root.right = _makeBST(mid + 1, high);
		return root;
	}
}