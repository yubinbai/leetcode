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

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ret;

        ArrayList<TreeNode> currLevel, nextLevel;
        currLevel = new ArrayList<TreeNode>();
        currLevel.add(root);

        while (!currLevel.isEmpty()) {
            nextLevel = new ArrayList<TreeNode>();
            ArrayList<Integer> intList = new ArrayList<Integer>();
            for (TreeNode e : currLevel) {
                intList.add(e.val);
                if (e.left != null) nextLevel.add(e.left);
                if (e.right != null) nextLevel.add(e.right);
            }

            ret.add(intList);
            currLevel = nextLevel;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(44);
        t.left.left = new TreeNode(3);
        System.out.println(sol.levelOrder(t));
    }
}
