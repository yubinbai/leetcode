class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null || root.right != null) {
            TreeNode swap = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = swap;
        } 
        return root;
    }
}