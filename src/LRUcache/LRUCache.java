import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    private ListNode head, end;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        ListNode latest = map.get(key);
        if (latest != null) {
            unlink(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }

    private void unlink(ListNode node) {
        ListNode curr = node;
        ListNode prev = curr.prev;
        ListNode next = curr.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            end = prev;
        }
    }

    private void setHead(ListNode node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (end == null) {
            end = node;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode e = map.get(key);
            e.val = value;
            unlink(e);
            setHead(e);
        } else {
            ListNode newNode = new ListNode(key, value);
            if (size < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                size++;
            } else {
                map.remove(end.key);
                end = end.prev;
                if (end != null) {
                    end.next = null;
                }
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }
}

class ListNode {
    public int val, key;
    public ListNode prev, next;

    public ListNode(int key, int value) {
        this.key = key;
        this.val = value;
    }
}
