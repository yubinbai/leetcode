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

    // YU's coding
    public ArrayList<ArrayList<Integer>> _levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        if (root == null) return ret;
        queue.add(root);
        int curcount = 1;
        int next = 0;

        while (queue.size() > 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (curcount > 0) {
                TreeNode cur = queue.get(0);
                if (cur.left != null) {
                    queue.add(cur.left);
                    next++;
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                    next++;
                }

                level.add(cur.val);
                queue.remove(0);
                curcount--;
            }

            curcount = next;
            next = 0;
            ret.add(level);
        }
        return ret;
    }

    // use counting instead of extra queue
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

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
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(3);
        System.out.println(sol.levelOrder(t));
    }
}
