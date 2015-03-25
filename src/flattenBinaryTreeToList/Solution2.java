public class Solution2 {
    TreeNode hook, prev;
    public void flatten(TreeNode root) {
        if (root == null) return;
        hook = new TreeNode(0);
        prev = hook;
        _flatten(root);
        return;
    }
    private void _flatten(TreeNode e) {
        prev.right = e;
        prev = e;
        TreeNode mark = e.right;
        if (e.left != null) _flatten(e.left);
        e.left = null;
        if (mark != null) _flatten(mark);
        return;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution2 s = new Solution2();
        s.flatten(root);
    }
}