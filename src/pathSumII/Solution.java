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
    ArrayList<List<Integer>> ret;
    Stack<Integer> stack;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<List<Integer>>();
        stack = new Stack<Integer>();
        if (root == null) return ret;
        _pathSum(root, sum);
        return ret;
    }
    private void _pathSum(TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                stack.push(root.val);
                ret.add(new ArrayList<Integer>(stack));
                stack.pop();
            }
        } else {
            stack.push(root.val);
            if (root.left != null) _pathSum(root.left, target - root.val);
            if (root.right != null) _pathSum(root.right, target - root.val);
            stack.pop();
        }
    }
}