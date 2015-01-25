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
        _flatten(root);
    }
    public TreeNode[] _flatten(TreeNode e) {
        TreeNode[] ret = new TreeNode[2];
        if (e == null) {
            ret[0] = ret[1] = null;
        } else {
            ret[0] = ret[1] = e;
            TreeNode[] left = _flatten(e.left);
            TreeNode[] right = _flatten(e.right);

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
        return ret;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution s = new Solution();
        s.flatten(root);
    }
}