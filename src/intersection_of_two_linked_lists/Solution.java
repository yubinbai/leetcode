class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode currA = headA, currB = headB;
        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }
        while (lenB > lenA) {
            currB = currB.next;
            lenB--;
        }
        while (currA != null) {
            if (currA == currB) {
                return currA;
            } else {
                currA = currA.next;
                currB = currB.next;
            }
        }
        return null;
    }
    public int getLength(ListNode e) {
        ListNode curr = e;
        int ret = 0;
        while (curr != null) {
            ret++;
            curr = curr.next;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}