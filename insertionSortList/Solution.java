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
        oldList.printList();
        head.printList();

        while (oldList != null) {
            prev = newHead;
            curr = newHead.next;

            while (true) {
                if ( (oldList.val >= prev.val) && (curr == null || curr.val >= oldList.val) ) {
                    prev.next = oldList;
                    System.out.println(oldList.val);
                    oldList = oldList.next;
                    System.out.println(oldList.val);
                    prev.next.next = curr;
                    prev = prev.next;
                } else {
                    if(curr == null) break;
                    curr = curr.next;
                    prev = curr;
                }
            }
        }
        return newHead.next;
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
        head = sol.insertionSortList(head.next);
        // head.printList();
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