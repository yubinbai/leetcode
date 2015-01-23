import java.util.*;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
};
public class Solution {
    /**
     * solution 2
     * @param  head [description]
     * @return      [description]
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // copy all nodes and insert in list
        RandomListNode p = head;
        while (p != null) {
            RandomListNode e = new RandomListNode(p.label);
            e.next = p.next;
            p.next = e;
            p = e.next;
        }
        // link the random pointer for copied
        p = head;
        while (p != null) {
            if (p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }
        // separate the copied to a new list
        p = head;
        RandomListNode ret = head.next, pp = head.next;
        while (p != null) {
            p.next = p.next.next;
            if (p.next != null) pp.next = pp.next.next;
            p = p.next;
            pp = pp.next;
        }
        return ret;
    }
    public RandomListNode copyRandomListSolution1(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode ret = new RandomListNode(0);
        ret.next = null;
        RandomListNode currNew = ret, curr = head;
        while (curr != null) {
            currNew.next = new RandomListNode(curr.label);
            map.put(curr, currNew.next);
            currNew = currNew.next;
            curr = curr.next;
        }
        currNew = ret.next;
        curr = head;
        while (curr != null) {
            currNew.random = map.get(curr.random);
            currNew = currNew.next;
            curr = curr.next;
        }
        return ret.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        RandomListNode e = new RandomListNode(-1);
        s.copyRandomList(e);
    }
}