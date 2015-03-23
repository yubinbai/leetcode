/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// http://en.wikipedia.org/wiki/Floyd%27s_cycle-finding_algorithm#Tortoise_and_hare
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode t = head.next, h = head.next.next;
        while (h != null && t != h) {
            if (h.next == null) return false;
            h = h.next.next;
            t = t.next;
        }
        return (t == h);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Solution sol = new Solution();
        System.out.println(sol.hasCycle(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public void printList() {
        ListNode curr = this;
        if (curr == null) {
            System.out.print("List : null");
            return;
        }
        System.out.print("List : [ ");
        while (curr != null) {
            System.out.format("%d ", curr.val);
            curr = curr.next;
        }
        System.out.println("] ");
    }
}