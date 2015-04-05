class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode hook = new ListNode(0);
        hook.next = head;
        int count = 0;
        ListNode prev = hook;
        ListNode curr = head, next = null;
        while (curr != null) {
            count ++;
            next = curr.next;
            if (count == k) {
                prev = reverse(prev, next);
                count = 0;
            }
            curr = next;
        }
        return hook.next;
    }

    // reverse prev.next ... end, and return the end of reversed part
    private ListNode reverse(ListNode prev, ListNode end) {
        if (prev == null || prev.next == null) return prev;

        ListNode head = prev.next;
        ListNode curr = head.next, next = null;
        while (curr != end) {
            next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        head.next = end;
        return head;
    }
}