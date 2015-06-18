import java.util.*;

public class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new ArrayDeque();
    }
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {

        int n = q.size();
        if (n == 0) return;

        for (int i = 0; i < n - 1; ++i) {
            int t = q.poll();
            q.offer(t);
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        int n = q.size();
        for (int i = 0; i < n - 1; ++i) {
            int t = q.poll();
            q.offer(t);
        }
        int result = q.poll();
        q.offer(result);
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty(); 
    }
    public static void main(String[] args) {
        
    }
}