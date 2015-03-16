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
    TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr.left != null) {
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode result = curr;
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            curr.right = parent;
            curr.left = parent.right;
            parent.left = parent.right = null;
            curr = parent;
        }
        return result;
    }

    TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode prev = root, curr = root.left, newRoot = new TreeNode(0);
        // reverse linked list on left subtree
        while (curr != null) {
            prev.left = newRoot.left;
            newRoot.left = prev;
            prev = curr;
            curr = curr.left;
        }
        prev.left = newRoot.left;
        newRoot.left = prev;

        //  rearrange left and right
        curr = newRoot.left;
        TreeNode swap;
        while (curr != null) {
            curr.right = curr.left;
            swap = curr.left;
            if (swap != null) {
                curr.left = swap.right;
                swap.right = null;
            }
            curr = swap;
        }
        return newRoot.left;
    }
    public static void inOrder(TreeNode e) {
        if (e != null) {
            inOrder(e.left);
            System.out.format("%d ", e.val);
            inOrder(e.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        inOrder(root);
        System.out.println("");

        Solution s = new Solution();
        TreeNode ret = s.upsideDownBinaryTree(root);
        inOrder(ret);
    }
}