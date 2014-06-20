public class Solution {
    public void reorderList(ListNode head) {
        ListNode fastP, slowP;
        fastP = slowP = head;

        // find half
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        // reverse second half
        ListNode revP = reverseList(slowP.next);
        slowP.next = null;

        // interleave
        ListNode ret = new ListNode(0);
        ListNode curr = head, curr1 = head.next, curr2 = revP;
        while (curr1 != null || curr2 != null) {
            if (curr2 != null) {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            }

            if (curr1 != null) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            }
        }
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
