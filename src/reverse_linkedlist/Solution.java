/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
	if (head == null) return null;
	ListNode newList = head, curr = head.next;
	newList.next = null;
	while (curr != null) {
	    ListNode swap = curr;
	    curr = curr.next;
	    swap.next = newList;
	    newList = swap;
	}
	return newList;
    }
}
