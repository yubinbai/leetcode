import java.util.*;

public class Solution {

    public static TreeNode singular = new TreeNode(0);

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricIter(root);
    }

    public boolean isSymmetricRecur(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return left == null;

        if (left.val != right.val) return false;

        if (!isSym(left.left, right.right)) return false;

        if (!isSym(left.right, right.left)) return false;
        return true;
    }

    public boolean isSymmetricIter(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        LinkedList<TreeNode> r = new LinkedList<TreeNode>();

        l.add(root.left);
        r.add(root.right);
        while (!l.isEmpty() && !r.isEmpty()) {
            TreeNode temp1 = l.poll(), temp2 = r.poll();

            if (temp1 == null && temp2 != null || temp1 != null && temp2 == null) return false;
            
            if (temp1 != null) {
                if (temp1.val != temp2.val) return false;
                l.add(temp1.left);
                l.add(temp1.right);
                r.add(temp2.right);
                r.add(temp2.left);
            }
        }
        return true;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

