public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fastP = head.next.next, slowP = head;
        while (fastP != null) {
            if (fastP.next == null) break;
            fastP = fastP.next.next;
            slowP = slowP.next;
        }
        ListNode left = head;
        ListNode right = slowP.next;
        slowP.next = null;

        ListNode h1 = sortList(left);
        ListNode h2 = sortList(right);
        ListNode merged = merge(h1, h2);

        return merged;
    }

    public static ListNode merge(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;

        ListNode hook = new ListNode(100);
        ListNode curr = hook;

        while (p1 != null || p2 != null) {

            if (p1 == null) {
                curr.next = p2;
                break;
            } else if (p2 == null) {
                curr.next = p1;
                break;
            } else {
                if (p1.val < p2.val) {
                    curr.next = new ListNode(p1.val);
                    p1 = p1.next;
                    curr = curr.next;
                } else if (p1.val == p2.val) {
                    curr.next = new ListNode(p1.val);
                    curr.next.next = new ListNode(p1.val);
                    curr = curr.next.next;
                    p1 = p1.next;
                    p2 = p2.next;
                } else {
                    curr.next = new ListNode(p2.val);
                    p2 = p2.next;
                    curr = curr.next;
                }
            }
        }

        return hook.next;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 0, 100, -100, 1};
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