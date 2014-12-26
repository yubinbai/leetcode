class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    private TreeNode sortedArrayToBST(int[] num, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(num[left]);
        int mid = (right + left) >> 1;
        TreeNode e = new TreeNode(num[mid]);
        e.left = sortedArrayToBST(num, left, mid - 1);
        e.right = sortedArrayToBST(num, mid + 1, right);
        return e;
    }
}