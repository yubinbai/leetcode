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
                e.right = left[0];
                ret[1] = left[1];
            }
            if (right[0] != null) {
                ret[1].right = right[0];
                ret[1] = right[1];
            }
        }
        return ret;
    }
    public void flattenSolution2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution s = new Solution();
        s.flattenSolution2(root);
    }
}