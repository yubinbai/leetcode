public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hook = new ListNode(0);
        ListNode curr = hook;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        return hook.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.deleteDuplicates(null);
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
