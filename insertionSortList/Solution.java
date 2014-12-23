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
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode oldList = head.next;
        ListNode prev = newHead, curr = head;
        prev.next = curr;
        curr.next = null;

        while (oldList != null) {
            prev = newHead; // sequential search pointers
            curr = newHead.next;

            while (curr != null) {
                if (oldList.val >= prev.val && oldList.val < curr.val) {
                    break;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }

            prev.next = oldList;
            oldList = oldList.next;
            prev.next.next = curr;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        // int[] a = {2, 1, 3, 0, 100, -100};
        // int[] a = {2, 1};
        int[] a = { -2147483647, -2147483648};
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i : a) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        head.next.printList();
        Solution sol = new Solution();
        head = sol.insertionSortList(head.next);
        head.printList();
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
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