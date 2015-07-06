class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
  int kk = 0;
  TreeNode curr = null;
  boolean found = false;
  public int kthSmallest(TreeNode root, int k) {
    this.kk = k;
    inOrder(root);
    return curr.val;
  }
  private void inOrder(TreeNode e) {
    if (e == null || found) return;
    inOrder(e.left);
    kk--;
    if (kk == 0) {
      found = true;
      curr = e;
      return;
    }
    inOrder(e.right);
  }

}
