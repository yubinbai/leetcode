import java.util.*;
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    private ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> lefts = dfs(start, i - 1);
            ArrayList<TreeNode> rights = dfs(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
