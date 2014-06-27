public class Solution {
    public void reorderList(ListNode head) {
        ListNode curr = head, midHead;
        int len = 0, mid;

        // find length
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        if (len <= 2) return;

        if (len % 2 == 1) {
            mid = (len - 1) / 2 + 2;
        } else {
            mid = len / 2 + 1;
        }

        // break list in two parts, and reverse second half
        midHead = reverseBetween(head, mid, len);

        // interleave
        curr = head;
        ListNode curr1 = head.next, curr2 = midHead;
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

    /**
     * reverseBetween a linked list (indexed 1..n)
     *
     * @param  head [description]
     * @param  m    [description]
     * @param  n    [description]
     * @return start of reversed part
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr, prev, oldList, newListHead, newListTail;
        int counter;

        // pass m - 1 nodes
        curr = head;
        prev = null;
        for (int i = 0; i < m - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        // reverse list
        counter = n - m + 1;
        oldList = curr.next;
        newListHead = curr;
        newListTail = curr;

        while (counter > 1) {
            curr = oldList;
            oldList = curr.next;
            curr.next = newListHead;
            newListHead = curr;
            counter -= 1;
        }

        // break list in two
        newListTail.next = oldList;
        prev.next = null;
        return newListHead;
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
