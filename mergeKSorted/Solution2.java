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
    class Record implements Comparable<Record> {
        ListNode e;
        int fromList;
        public Record(ListNode e, int l) {
            this.e = e;
            this.fromList = l;
        }

        public int compareTo (Record other) {
            int a = this.e.val;
            int b = other.e.val;
            System.out.format("%d %d \n", a, b);
            return a > b ? 1 : (a == b ? 0 : -1);
        }
    }
    // TLE
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<Record> pq = new PriorityQueue<Record>();
        ListNode retHead = new ListNode(0);
        ListNode retCurr = retHead;
        ListNode e;
        Record r;
        int n = lists.size();
        if (n == 0) {
        	return null;
        }
        for (int i = 0; i < n; i++) {
            e = lists.get(i);
            if (e != null) {
	            pq.offer(new Record(e, i));
	            lists.set(i, e.next);
	        }
        }
        while (!pq.isEmpty()) {
            r = pq.poll();
            int i = r.fromList;
            e = r.e;
            retCurr.next = e;
            e.next = null;
            retCurr = retCurr.next;
            if (lists.get(i) != null) {
            	e = lists.get(i);
	            lists.set(i, e.next);
	            pq.offer(new Record(e, i));
            }
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
        ListNode res = s.mergeKLists(lists);
        s.printList(res);
    }
}