public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head.next.next;
        while (fast != null) {
            if (fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr2 = reverse(slow.next);
        slow.next = null;

        ListNode curr = head, curr1 = head.next;
        while (curr1 != null || curr2 != null) {
            if (curr2 != null) {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            }
            if (curr1 != null) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            }
        }
        curr.next = null;
    }

    public ListNode reverse(ListNode head) {
        ListNode swap = null, oldList = head, newList = null;

        while (oldList != null) {
            swap = oldList;
            oldList = oldList.next;
            swap.next = newList;
            newList = swap;
        }

        return newList;
    }

    public void printList(ListNode e) {
        while (e != null) {
            System.out.format("\t%d", e.val);
            e = e.next;
        }
        System.out.format("\n");
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        Solution s = new Solution();
        s.reorderList(a);
        s.printList(a);
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