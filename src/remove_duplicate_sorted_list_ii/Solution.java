public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            } else {
                ListNode sameValue = head;
                while (sameValue != null && sameValue.val == head.val) {
                    sameValue = sameValue.next;
                }
                head = sameValue;
            }
        }
        curr.next = null;
        return ret.next;
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
