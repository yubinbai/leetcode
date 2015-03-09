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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        boolean normalOrder = true;
        while (true) {
            ArrayList<Integer> num = new ArrayList<Integer>();
            for (TreeNode e : curr) {
                if (e != null) {
                    num.add(e.val);
                    next.add(e.left);
                    next.add(e.right);
                }
            }
            if (num.isEmpty()) break;
            if (normalOrder) {
                normalOrder = false;
                ret.add(num);
            } else {
                Collections.reverse(num);
                normalOrder = true;
                ret.add(num);
            }
            curr = next;
            next = new ArrayList<TreeNode>();
        }
        return ret;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution s = new Solution();
        System.out.print(s.zigzagLevelOrder(root));
    }
}