public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode curr, prev;
        curr = prev = head;
        int counter = n;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        if (len <= 1) return head;
        counter %= len;
        curr = prev = head;

        for (int i = 0; i < counter; i++) {
            curr = curr.next;
        }
        if (curr == null) return head;
        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }
        curr.next = head;
        ListNode ret = prev.next;
        prev.next = null;
        return ret;
    }
    public void printList(ListNode e) {
        while (e != null) {
            System.out.format("%d ", e.val);
            e = e.next;
        }
        System.out.format("\n");
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        s.printList(head);
        head = s.rotateRight(head, 2);
        s.printList(head);
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