class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ret = new int[2];
        _maxPathSun(root, ret);
        return ret[0];
    }

    private void _maxPathSun(TreeNode root, int[] ret) {
        // ret[0] any path
        // ret[1] path that ends at root
        int[] leftRet = new int[2];
        int[] rightRet = new int[2];
        if (root == null) return;
		ret[0] = ret[1] = root.val;
        if (root.left == null && root.right == null) {
        	return;
        }
        if (root.left != null) {
            _maxPathSun(root.left, leftRet);
            ret[0] = Math.max(ret[0], leftRet[0]);
            ret[1] = Math.max(ret[1], ret[1] + leftRet[1]);
        }
        if (root.right != null) {
            _maxPathSun(root.right, rightRet);
            ret[0] = Math.max(ret[0], rightRet[0]);
            ret[1] = Math.max(ret[1], ret[1] + rightRet[1]);
        }
        ret[0] = Math.max(ret[0], leftRet[1] + rightRet[1] + root.val);
        ret[0] = Math.max(ret[0], ret[1]);
        return;
    }
}