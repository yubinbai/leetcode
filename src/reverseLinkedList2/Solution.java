public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr, prev, oldList, newListHead, newListTail;

        // pass m - 1 nodes
        curr = head;
        prev = null;
        for (int i = 0; i < m - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        // reverse list
        oldList = curr.next;
        newListHead = curr;
        newListTail = curr;

        for (int i = n - m; i > 0; i--) {
            curr = oldList;
            oldList = curr.next;
            curr.next = newListHead;
            newListHead = curr;
        }

        // link the list back
        newListTail.next = oldList;
        if (prev == null) {
            return newListHead;
        } else {
            prev.next = newListHead;
            return head;
        }

    }

    public static void main(String[] args) {
        ListNode t = new ListNode(5);
        Solution s = new Solution();
        ListNode a = s.reverseBetween(t, 1, 1);
        System.out.format("List %d", a.val);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
