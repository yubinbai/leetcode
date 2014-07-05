class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        if (curr == null) return null;
        ListNode oldList = new ListNode(0);
        ListNode oldListCurr = oldList;
        ListNode newList = new ListNode(0);
        ListNode newListCurr = newList;
        while (curr != null) {
            if (curr.val >= x) {
                newListCurr.next = curr;
                curr = curr.next;
                newListCurr = newListCurr.next;
            } else {
                oldListCurr.next = curr;
                curr = curr.next;
                oldListCurr = oldListCurr.next;
            }
        }
        oldListCurr.next = newList.next;
        newListCurr.next = null;
        return oldList.next;
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
        int[] intA = {1, 4, 3, 2, 5 , 2};
        ListNode in = sol.generateList(intA);
        sol.printList(in);
        sol.printList(sol.partition(in, 3));
    }
}