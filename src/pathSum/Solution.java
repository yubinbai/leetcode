class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        } else if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else {
            return hasPathSum(root.left, sum - root.val)
                   || hasPathSum(root.right, sum - root.val);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode e = new TreeNode(1);
        e.left = new TreeNode(2);
        System.out.println(s.hasPathSum(e, 1));
    }
}