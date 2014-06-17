import java.util.*;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRecur(root);
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
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
        currLevel.offer(root);

        while ( !currLevel.isEmpty() ) {
            for (TreeNode e : currLevel) {
                if (e == null) continue;
                nextLevel.offer(e.left);
                nextLevel.offer(e.right);
            }

            while ( !currLevel.isEmpty() ) {
                TreeNode pl = currLevel.pollFirst();
                TreeNode pr = currLevel.pollLast();
                int l = pl == null ? -1 : pl.val;
                int r = pr == null ? -1 : pr.val;
                if (l != r)
                    return false;
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

