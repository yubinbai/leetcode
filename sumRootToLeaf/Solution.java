// * Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    int ret;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        _sumNumbers(root, 0);
        return ret;
    }
    public void _sumNumbers(TreeNode root, int curr) {
        if (root.left == null && root.right == null) {
            ret += curr * 10 + root.val;
        } else {
            if (root.left != null) _sumNumbers(root.left, curr * 10 + root.val);
            if (root.right != null) _sumNumbers(root.right, curr * 10 + root.val);
        }
    }
}