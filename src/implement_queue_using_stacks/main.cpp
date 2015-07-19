#include <stack>
#include <iostream>

using namespace std;

class Queue {

private:
  stack<int> in_stack, out_stack;

public:
  ~Queue() {}
  // Push element x to the back of queue.
  void push(int x) {
    in_stack.push(x);
  }

  // Removes the element from in front of queue.
  void pop(void) {
    if (!this->empty()) {
      out_stack.pop();
    }
  }

  // Get the front element.
  int peek(void) {
    if (!this->empty()) {
      return out_stack.top();
    } else {
      return -1;
    }
  }

  // Return whether the queue is empty.
  bool empty(void) {
    if (out_stack.empty()) {
      while (!in_stack.empty()) {
        out_stack.push(in_stack.top());
        in_stack.pop();
      }
    }
    return out_stack.empty();
  }
};
int main() {
  Queue q;
  q.push(1);
  cout << q.peek();
  q.pop();
}
