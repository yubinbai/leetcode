public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        int carry = 0;
        int v1, v2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                v1 = 0;
            } else {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                v2 = 0;
            } else {
                v2 = l2.val;
                l2 = l2.next;
            }
            int s = v1 + v2 + carry;
            carry = s / 10;

            ListNode e = new ListNode(s % 10);
            curr.next = e;
            curr = e;
        }
        if (carry == 1) {
            ListNode e = new ListNode(1);
            curr.next = e;
        }

        return ret.next;
    }

    public ListNode makeNumber(int n) {
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        while (n > 0) {
            ListNode e = new ListNode(n % 10);
            curr.next = e;
            curr = e;
            n /= 10;
        }
        return ret.next;
    }

    public void printNumber(ListNode e) {
        while (e != null) {
            System.out.format("%d", e.val);
            e = e.next;
        }
        System.out.format("\n");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = s.makeNumber(1);
        ListNode n2 = s.makeNumber(999);
        s.printNumber(n1);
        s.printNumber(n2);
        ListNode res = s.addTwoNumbers(n1, n2);
        s.printNumber(res);
        
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
