class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode e, int min, int max) {
        if (e == null) return true;
        if (e.val >= max || e.val <= min) {
            return false;
        } else {
            return isValid(e.left, min, e.val) && isValid(e.right, e.val, max);
        }
    }
}