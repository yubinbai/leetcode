import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    /**
     * DFS with explicit stack
     * @param  root [description]
     * @return      [description]
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode e = stack.pop();
            result.add(e.val);
            if (e.right != null) stack.push(e.right);
            if (e.left != null) stack.push(e.left);
        }
        return result;        
    }
    public static void main(String[] args) {
        TreeNode e = new TreeNode(0);
        e.left = new TreeNode(1);
        e.right = new TreeNode(2);
        Solution s = new Solution();
        System.out.println(s.preorderTraversal(e));
    }
}