import java.util.*;
public class Solution2 {

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode parentLevel = root, swap = null, curr = null, nextLevel = null;
        TreeLinkNode currLevel = root.left != null ? root.left : root.right;

        while (currLevel != null) {
            ChildIterator iter = new ChildIterator(parentLevel);
            if (!iter.hasNext()) break;
            curr = iter.next();
            if (nextLevel == null && curr.left != null) nextLevel = curr.left;
            if (nextLevel == null && curr.right != null) nextLevel = curr.right;
            while (iter.hasNext()) {
                swap = iter.next();
                if (nextLevel == null && swap.left != null) nextLevel = swap.left;
                if (nextLevel == null && swap.right != null) nextLevel = swap.right;
                curr.next = swap;
                curr = swap;
            }
            parentLevel = currLevel;
            currLevel = nextLevel;
            nextLevel = null;
        }
    }

    class ChildIterator {
        boolean leftIsUsed = false;
        TreeLinkNode curr;
        public ChildIterator(TreeLinkNode _curr) {
            curr = _curr;
        }
        public boolean hasNext() {
            while (curr != null) {
                if (curr.left != null && !leftIsUsed) {
                    return true;
                } else if (curr.right != null) {
                    return true;
                } else {
                    curr = curr.next;
                    leftIsUsed = false;
                }
            }
            return false;
        }
        public TreeLinkNode next() {
            if (hasNext()) {
                if (leftIsUsed) {
                    if (curr.right != null) {
                        return curr.right;
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    if (curr.left != null) {
                        leftIsUsed = true;
                        return curr.left;
                    } else if (curr.right != null) {
                        TreeLinkNode swap = curr;
                        curr = curr.next;
                        return swap.right;
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode e = new TreeLinkNode(1);
        e.left = new TreeLinkNode(2);
        e.right = new TreeLinkNode(3);

        e.left.left = new TreeLinkNode(4);
        e.left.right = new TreeLinkNode(5);

        e.right.left = new TreeLinkNode(6);
        e.right.right = new TreeLinkNode(7);

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

// class TreeLinkNode {
//     int val;
//     TreeLinkNode left, right, next;
//     TreeLinkNode(int x) { val = x; }
// }
