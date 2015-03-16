import java.util.*;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode parent = root, curr = null, nextLevel = null;
        TreeLinkNode currLevel = root.left != null ? root.left : root.right;

        while (currLevel != null) {
            curr = currLevel;
            while (parent != null) {
                if (curr.left != null && nextLevel == null) nextLevel = curr.left;
                if (curr.right != null && nextLevel == null) nextLevel = curr.right;

                if (curr == parent.left) {
                    if (parent.right != null) {
                        curr.next = parent.right;
                        curr = parent.right;
                    } else {
                        parent = parent.next;
                    }
                } else if (curr == parent.right) {
                    parent = parent.next;
                    if (parent == null) continue;
                    if (parent.left != null) {
                        curr.next = parent.left;
                        curr = parent.left;
                    } else if (parent.right != null) {
                        curr.next = parent.right;
                        curr = parent.right;
                    }
                } else {
                    parent = parent.next;
                }
            }
            parent = currLevel;
            currLevel = nextLevel;
            nextLevel = null;
        }

    }
    public static void main(String[] args) {
        TreeLinkNode e = new TreeLinkNode(1);
        e.left = new TreeLinkNode(1);
        e.right = new TreeLinkNode(2);

        e.left.left = new TreeLinkNode(3);
        e.left.right = new TreeLinkNode(4);

        e.right.left = new TreeLinkNode(5);
        e.right.right = new TreeLinkNode(6);

        Solution s = new Solution();
        s.connect(e);
        s.printList(e.left);
        s.printList(e.left.left);
    }
    public void printList(TreeLinkNode e) {
        while (e != null) {
            System.out.format("%d ", e.val);
            e = e.next;
        }
        System.out.println("");
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
