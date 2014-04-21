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
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<Integer> depthQ = new LinkedList<Integer>();
        if (root == null) return 0;
        q.offer(root);
        depthQ.offer(1);
        while ( !q.isEmpty() ) {
            TreeNode e = q.poll();
            Integer d = depthQ.poll();
            if (e.left == null && e.right == null)
                return d;
            if (e.left != null) {
                q.offer(e.left);
                depthQ.offer(d + 1);
            }
            if (e.right != null) {
                q.offer(e.right);
                depthQ.offer(d + 1);
            }
        }
        return 0;
    }
}