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

        ListNode t = head.next;
        ListNode h = head.next.next;
        if (head == h) return true;
        while (t != null && h != null && t != h) {
            t = t.next;
            if (h.next == null) return false;
            h = h.next.next;
        }
        return (t == h);
    }
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 0, 100, -100};
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i : a) {
            curr.next = new ListNode(i);
            if (i == 0) {
                curr.next = head.next;
                break;
            }
            curr = curr.next;
        }
        Solution sol = new Solution();
        System.out.println(sol.hasCycle(head.next));

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