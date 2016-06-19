#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
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
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* addTwoNumbers(ListNode* e1, ListNode* e2) {
    int v1 = 0, v2 = 0, carry = 0;
    ListNode* ret = new ListNode(0);
    ListNode* curr = ret;
    while (e1 != nullptr || e2 != nullptr){
      if (e1 != nullptr) {
        v1 = e1->val;
        e1 = e1->next;
      } else {
        v1 = 0;
      }
      if (e2 != nullptr) {
        v2 = e2->val;
        e2 = e2->next;
      } else {
        v2 = 0;
      }
      int s = v1 + v2 + carry;
      if (s >= 10) {
        curr->next = new ListNode(s - 10);
        carry = 1;
      } else {
        curr->next = new ListNode(s);
        carry = 0;
      }
      curr = curr->next;
    }
    if (carry > 0) {
      curr->next = new ListNode(1);
    }
    return ret->next;
  }
};

int main() {
  Solution sol;
  ListNode* a = new ListNode(2);
  a->next = new ListNode(4);
  a->next->next = new ListNode(3);

  ListNode* b = new ListNode(5);
  b->next = new ListNode(6);
  b->next->next = new ListNode(4);

  ListNode* c = sol.addTwoNumbers(a, b);
  while (c != nullptr) {
    cout << c->val << endl;
    c = c->next;
  }

  return 0;
}

