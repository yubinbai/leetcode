public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hook = new ListNode(0);
        ListNode curr = hook;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            } else {
                ListNode skip = head;
                while (skip != null && skip.val == head.val) {
                    skip = skip.next;
                }
                head = skip;
                curr.next = skip;
            }
        }
        return hook.next;
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
