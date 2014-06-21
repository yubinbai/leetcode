public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr, prev, oldList, newListHead, newListTail;
        int counter;

        // pass m - 1 nodes
        curr = head;
        prev = null;
        for (int i = 0; i < m - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        // reverse list
        counter = n - m + 1;
        oldList = curr.next;
        newListHead = curr;
        newListTail = curr;

        while (counter > 1) {
            curr = oldList;
            oldList = curr.next;
            curr.next = newListHead;
            newListHead = curr;
            counter -= 1;
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
