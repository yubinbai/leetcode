import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {
    Stack<TreeNode> path, ret;
    TreeNode curr, prev;

    public BSTIterator(TreeNode root) {
        path = new Stack<TreeNode>();
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !path.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = null;
        while (hasNext()) {
            if (curr != null) {
                path.add(curr);
                curr = curr.left;
            } else {
                curr = path.pop();
                ret = curr;
                curr = curr.right;
                break;
            }
        }
        return ret == null ? -1 : ret.val;
    }
    public static void main(String[] args) {
        TreeNode e = new TreeNode(2);
        e.left = new TreeNode(1);
        BSTIterator i = new BSTIterator(e);
        while (i.hasNext()) {
            System.out.format("%d\n", i.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */