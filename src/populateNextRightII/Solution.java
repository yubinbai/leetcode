import java.util.*;
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayDeque<TreeLinkNode> curr, next;
        TreeLinkNode node;
        curr = new ArrayDeque<TreeLinkNode>();
        next = new ArrayDeque<TreeLinkNode>();
        curr.offer(root);
        while (!curr.isEmpty())  {
            node = curr.poll();
            node.next = curr.peek();
            if (node.left != null) next.offer(node.left);
            if (node.right != null) next.offer(node.right);
            if (curr.isEmpty()) {
                curr = next;
                next = new ArrayDeque<TreeLinkNode>();
            }
        }
    }
}