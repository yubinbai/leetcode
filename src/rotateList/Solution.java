public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        ListNode curr = head;
        int len = 1;
        // make circular list
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        curr.next = head;
        n %= len;

        // break at required pos
        curr = head;
        for (int i = 0; i < len - n - 1; i++) {
            curr = curr.next;
        }
        ListNode ret = curr.next;
        curr.next = null;

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
        head = s.rotateRight(head, 1001);
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