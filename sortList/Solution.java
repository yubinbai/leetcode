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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pivot = head;
        ListNode curr = head.next;
        ListNode headLeft = null;
        ListNode headRight = null;
        ListNode tailLeft = null;
        ListNode tailRight = null;

        // without random access array, quicksort degrades to insert sort
        while (curr != null) {
            if (curr.val >= pivot.val) {
                if (tailRight == null) {
                    tailRight = curr;
                    headRight = tailRight;
                } else {
                    tailRight.next = curr;
                    tailRight = curr;
                }
            } else {
                if (tailLeft == null) {
                    tailLeft = curr;
                    headLeft = tailLeft;
                } else {
                    tailLeft.next = curr;
                    tailLeft = curr;
                }
            }
            curr = curr.next;
        }

        // System.out.format("Pivot: %d \n", pivot.val);

        if (headLeft != null) {
            tailLeft.next = null;
            // System.out.print("Left"); if (headLeft != null) headLeft.printList();
            headLeft = sortList(headLeft);
            tailLeft = headLeft;
            while (tailLeft.next != null) tailLeft = tailLeft.next;
            tailLeft.next = pivot;
        }
        if (headRight != null) {
            tailRight.next = null;
            // System.out.print("Right"); if (headRight != null) headRight.printList();
            headRight = sortList(headRight);
        }

        pivot.next = headRight;
        if (headLeft != null)
            return headLeft;
        else
            return pivot;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 0, 100, -100};
        ListNode head = new ListNode(0);
        ListNode curr = head;

        for (int i : a) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        head.next.printList();

        Solution sol = new Solution();
        head = sol.sortList(head.next);
        head.printList();
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