class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public void flatten(TreeNode root) {
        _flatten(root, new TreeNode[2]);
    }
    public void _flatten(TreeNode e, TreeNode[] ret) {
        if (e == null) {
            ret[0] = ret[1] = null;
        } else {
            ret[0] = ret[1] = e;
            TreeNode[] left = new TreeNode[2];
            _flatten(e.left, left);
            TreeNode[] right = new TreeNode[2];
            _flatten(e.right, right);

            e.left = null;
            if (left[0] != null) {
                ret[0].right = left[0];
                ret[1] = left[1];
            }
            if (right[0] != null) {
                ret[1].right = right[0];
                ret[1] = right[1];
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution s = new Solution();
        s.flatten(root);
    }
}