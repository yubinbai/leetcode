import java.util.*;
class ReverseList {
	public Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node rest = head.next;
		Node newHead = reverse(rest);
		rest.next = head;
		head.next = null;
		return newHead;
	}

	public Node generateList(int n) {
		Random r = new Random();
		Node head = new Node(0);
		Node curr = head;
		for (int i = 0; i < n; i++) {
			curr.next = new Node(r.nextInt(n));
			curr = curr.next;
		}
		return head.next;
	}
	public void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.format("%d ", curr.val);
			curr = curr.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		ReverseList r = new ReverseList();
		Node list = r.generateList(10);
		r.printList(list);
		list = r.reverse(list);
		r.printList(list);
	}
}

class Node {
	int val;
	Node next;
	public Node (int v) {
		val = v;
	}
}