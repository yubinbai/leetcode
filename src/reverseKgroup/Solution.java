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
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            count ++;
            ListNode next = curr.next;
            if (count == k) {
                prev = reverse(prev, next);
                count = 0;
            }
            curr = next;
        }
        return dummy.next;
    }

    // reverse prev.next ... end, and return the end of reversed part
    private ListNode reverse(ListNode prev, ListNode end) {
        if (prev == null || prev.next == null)
            return prev;
        ListNode head = prev.next, curr = prev.next.next, next;
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