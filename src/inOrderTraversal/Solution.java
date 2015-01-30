import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static TreeNode makeTree(int[] arr, int i) {
        if (i >= arr.length) {
            return null;
        } else {
            TreeNode e = new TreeNode(arr[i]);
            e.left = makeTree(arr, i * 2 + 1);
            e.right = makeTree(arr, i * 2 + 2);
            return e;
        }
    }
}
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                ret.add(p.val);
                p = p.right;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] t = new int [] {1, 2, 5, 3, 4, 0, 6};
        TreeNode root = TreeNode.makeTree(t, 0); 
        Solution s = new Solution();
        System.out.println(s.inorderTraversal(root));
    }
}