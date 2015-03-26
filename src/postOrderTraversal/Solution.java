import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    // stack max at 2 * h
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode prev = new TreeNode(0), curr = null;

        while (!stack.isEmpty()) {
            // System.out.println(stack.size());
            curr = stack.peek();
            if (curr.left == prev || curr.right == prev) {
                result.add(curr.val);
                prev = curr;
                stack.pop();
            } else if (curr.left == null && curr.right == null) {
                result.add(curr.val);
                prev = curr;
                stack.pop();
            } else {
                if (curr.right!= null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode e = new TreeNode(0);
        e.left = new TreeNode(1);
        e.left.left = new TreeNode(3);
        e.left.left.left = new TreeNode(7);
        e.left.left.right = new TreeNode(8);
        e.left.right = new TreeNode(4);
        e.left.right.left = new TreeNode(9);
        e.left.right.right = new TreeNode(10);
        e.right = new TreeNode(2);
        e.right.left = new TreeNode(5);
        e.right.right = new TreeNode(6);
        System.out.println(s.postorderTraversal(e));
    }
}