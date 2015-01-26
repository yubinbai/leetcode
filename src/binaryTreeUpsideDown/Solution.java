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
            System.out.println(e.val);
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

        Solution s = new Solution();
        TreeNode ret = s.upsideDownBinaryTree(root);
        inOrder(ret);
    }
}