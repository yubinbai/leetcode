import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode retHead = new ListNode(0);
        ListNode retCurr = retHead;
        int i1, i2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                retCurr.next = l2;
                break;
            }
            if (l2 == null) {
                retCurr.next = l1;
                break;
            }
            i1 = l1.val;
            i2 = l2.val;
            if (i1 > i2) {
                retCurr.next = l2;
                l2 = l2.next;
            } else {
                retCurr.next = l1;
                l1 = l1.next;
            }
            retCurr = retCurr.next;
        }
        return retHead.next;
    }
    public void printList(ListNode e) {
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        Solution s = new Solution();
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1);
        lists.add(l2);
        ListNode res = s.mergeTwoLists(l1, l2);
        s.printList(res);
    }
}