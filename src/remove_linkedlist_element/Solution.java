public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return null;
		ListNode hook = new ListNode(0);
		hook.next = head;
		ListNode prev = hook, curr = head;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		return hook.next;
	}
}