import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    HashMap<TreeNode, Integer> height = new HashMap<TreeNode, Integer>();
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode n) {
        if (height.containsKey(n)) return height.get(n);
        int ret = 0;
        if (n != null) ret = Math.max(getHeight(n.left), getHeight(n.right)) + 1;
        height.put(n, ret);
        return ret;
    }
}
