class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, curr = head.next;
        ListNode _prev = null, _curr = null, result = curr;
        do {
            _prev = curr.next;
            if (_prev != null) {
                _curr = _prev.next;
            } else {
                _curr = null;
            }
            curr.next = prev;
            if (_curr == null) {
                prev.next = _prev;
            } else {
                prev.next = _curr;
            }
            prev = _prev;
            curr = _curr;
        } while (prev != null && curr != null);
        return result;
    }
    public static void main(String[] args) {
        ListNode e = new ListNode(1);
        e.next = new ListNode(2);
        e.next.next = new ListNode(3);
        // e.next.next.next = new ListNode(4);
        Solution s = new Solution();
        ListNode r = s.swapPairs(e);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}