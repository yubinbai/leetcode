import java.util.*;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
};
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
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
}