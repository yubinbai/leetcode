class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, (long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode e, long min, long max) {
        if (e == null) return true;
        if (e.val > max || e.val < min) {
            return false;
        } else {
            return isValid(e.left, min, (long) e.val - 1) && isValid(e.right, (long) e.val + 1, max);
        }
    }
}