#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
  ListNode* plusOne(ListNode* head) {
    if (head == nullptr) {
      return head;
    }
    ListNode *rev_head = reverse(head), *cur = rev_head, *pre = cur;
    int carry = 1;
    while (cur) {
      pre = cur;
      int t = cur->val + carry;
      cur->val = t % 10;
      carry = t / 10;
      if (carry == 0) break;
      cur = cur->next;
    }
    if (carry) {
      pre->next = new ListNode(1);
    }
    return reverse(rev_head);
  }

  ListNode* reverse(ListNode *head) {
    if (!head) return head;
    ListNode *dummy = new ListNode(-1), *cur = head;
    dummy->next = head;
    while (cur->next) {
      ListNode *t = cur->next;
      cur->next = t->next;
      t->next = dummy->next;
      dummy->next = t;
    }
    return dummy->next;
  }
};

int main() {
  Solution sol;
  ListNode* head = new ListNode(1);
  head->next = new ListNode(2);
  head->next->next = new ListNode(3);

  sol.plusOne(head);
  ListNode* curr = head;
  while (curr != nullptr) {
    cout << curr->val << endl;
    curr = curr->next;
  }

  return 0;
}
