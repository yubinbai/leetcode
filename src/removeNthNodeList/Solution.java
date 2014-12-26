class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hook = new ListNode(0);
        hook.next = head;
        ListNode curr = hook, prev;
        for (int i = 0; i <= n; i++) {
            curr = curr.next;
        }
        // System.out.println(curr.val);
        prev = hook;
        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        }
        // System.out.println(prev.val);
        prev.next = prev.next.next;
        return hook.next;
    }
    public ListNode generateList(int[] list) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i : list) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }
    public void printList(ListNode e) {
        while (e != null) {
            System.out.format("%d\t", e.val);
            e = e.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] intA = {1, 2, 3, 4, 5};
        ListNode in = sol.generateList(intA);
        sol.printList(in);
        sol.printList(sol.removeNthFromEnd(in, 1));
    }
}