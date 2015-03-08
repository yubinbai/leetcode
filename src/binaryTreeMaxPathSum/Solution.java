class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    private static int MINV = (int) -1e9;
    public int maxPathSum(TreeNode root) {
        int[] ret = _maxPathSum(root);
        return ret[0];
    }
    /**
     * get max path sum
     * @param node
     * @return ret, mutable array for return values
     *      ret[0] any path
     *      ret[1] path that ends at current node
     */
    private int[] _maxPathSum(TreeNode node) {
        if (node == null) return new int[] {MINV, MINV};
        int[] ret = {node.val, node.val};
        if (node.left == null && node.right == null) {
            return ret;
        }

        int[] leftRet = _maxPathSum(node.left);
        ret[0] = Math.max(ret[0], leftRet[0]);
        ret[0] = Math.max(ret[0], node.val + leftRet[1]);

        int[] rightRet = _maxPathSum(node.right);
        ret[0] = Math.max(ret[0], rightRet[0]);
        ret[0] = Math.max(ret[0], node.val + rightRet[1]);

        ret[1] = Math.max(ret[1], node.val + Math.max(leftRet[1], rightRet[1]));
        ret[0] = Math.max(ret[0], node.val + leftRet[1] + rightRet[1]);
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode e = new TreeNode(-2);
        e.left = new TreeNode(-1);
        // e.right = new TreeNode(3);
        System.out.println(s.maxPathSum(e));
    }
}