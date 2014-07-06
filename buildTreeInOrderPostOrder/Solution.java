class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    int[] inorder, postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int l1, int r1, int l2, int r2) {
        TreeNode e = new TreeNode(postorder[r2]);
        int pos = l1, sizeLeft = 0;
        for (; pos <= r1; pos++) {
            if (inorder[pos] == postorder[r2]) break;
            sizeLeft++;
        }
        int sizeRight = r1 - l1 + 1 - sizeLeft - 1;
        e.left = (pos == l1) ? null : buildTree(l1, pos - 1, l2, l2 + sizeLeft - 1);
        e.right = (pos == r1) ? null : buildTree(pos + 1, r1, r2 - sizeRight, r2 - 1);
        return e;
    }
    public void printInOrder(TreeNode e) {
        if (e == null) return;
        printInOrder(e.left);
        System.out.format("%d\t", e.val);
        printInOrder(e.right);
    }
    public void printPostOrder(TreeNode e) {
        if (e == null) return;
        printPostOrder(e.left);
        printPostOrder(e.right);
        System.out.format("%d\t", e.val);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] in = {1, 2, 3, 4};
        int[] post = {3, 2, 4, 1};
        TreeNode e = sol.buildTree(in, post);
        sol.printInOrder(e);
        sol.printPostOrder(e);
    }
}