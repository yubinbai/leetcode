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
    ArrayList<ArrayList<Integer>> ret;
    Stack<Integer> stack;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<ArrayList<Integer>>();
        stack = new Stack<Integer>();
        if (root == null) return ret;
        _pathsum(root, sum);
        return ret;
    }
    private void _pathsum(TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                stack.push(root.val);
                ret.add(new ArrayList<Integer>(stack));
                stack.pop();
            }
            return;
        }
        stack.push(root.val);
        if (root.left != null) _pathsum(root.left, target - root.val);
        if (root.right != null) _pathsum(root.right, target - root.val);
        stack.pop();
    }
}