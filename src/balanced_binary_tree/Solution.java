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
        int[] ret = _isBalanced(root);
        return ret[0] == 1;
    }

    private int[] _isBalanced(TreeNode e) {
        int[] ret = new int[2];
        if (e == null) {
            ret[0] = 1;
            ret[1] = 0;
        } else {
            int[] left = _isBalanced(e.left);
            int[] right = _isBalanced(e.right);
            if (
                left[0] == 1
                && right[0] == 1
                && Math.abs(left[1] - right[1]) <= 1
            ) {
                ret[0] = 1;
            }
            ret[1] = Math.max(left[1], right[1]) + 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode e = new TreeNode(1);
        e.left = new TreeNode(2);
        System.out.println(s.isBalanced(e));
    }
}
