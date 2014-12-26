class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        this.inorder = inorder;
        this.preorder = preorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int l1, int r1, int l2, int r2) {
        TreeNode e = new TreeNode(preorder[l1]);
        int pos = l2, sizeLeft = 0;
        for (; pos <= r2; pos++) {
            if (inorder[pos] == preorder[l1]) break;
            sizeLeft++;
        }
        int sizeRight = r1 - l1 + 1 - sizeLeft - 1;
        e.left = (pos == l2) ? null : buildTree(l1 + 1, l1 + sizeLeft, l2, l2 + sizeLeft - 1);
        e.right = (pos == r2) ? null : buildTree(l1 + sizeLeft + 1, r1, r2 - sizeRight + 1, r2);
        return e;
    }
    public void printInOrder(TreeNode e) {
        if (e == null) return;
        printInOrder(e.left);
        System.out.format("%d\t", e.val);
        printInOrder(e.right);
    }
    public void printPreOrder(TreeNode e) {
        if (e == null) return;
        System.out.format("%d\t", e.val);
        printPreOrder(e.left);
        printPreOrder(e.right);

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] pre = {1, 2};
        int[] in = {1, 2};
        TreeNode e = sol.buildTree(pre, in);
        sol.printPreOrder(e);
        sol.printInOrder(e);

    }
}