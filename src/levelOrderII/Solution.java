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

    // use counting instead of extra queue
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (root == null) return ret;
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<TreeNode>();

        currentLevel.offer(root);
        int currCount = 1;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while (!currentLevel.isEmpty()) {
            TreeNode currTreeNode = currentLevel.pollFirst();
            if (currTreeNode != null) {
                curr.add(currTreeNode.val);
                if (currTreeNode.left != null) currentLevel.offer(currTreeNode.left);
                if (currTreeNode.right != null) currentLevel.offer(currTreeNode.right);
            }
            currCount--;
            if (currCount == 0) {
                ret.add(curr);
                curr = new ArrayList<Integer>();
                currCount = currentLevel.size();
            }
        }
        Collections.reverse(ret);
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(3);
        System.out.println(sol.levelOrderBottom(t));
    }
}
