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
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* oddEvenList(ListNode* head) {
    if (head == NULL) {
      return NULL;
    }

    ListNode *oddHead, *oddTail, *evenHead, *evenTail;
    oddHead = new ListNode(0);
    evenHead = new ListNode(0);
    oddTail = oddHead;
    evenTail = evenHead;

    ListNode* curr = head;
    int counter = 1;
    while (curr != NULL) {
      if (counter % 2 == 0) {
        evenTail->next = curr;
        evenTail = evenTail->next;
      } else {
        oddTail->next = curr;
        oddTail = oddTail->next;
      }
      curr = curr->next;
      ++counter;
    }

    oddTail->next = evenHead->next;
    evenTail->next = NULL;
    return oddHead->next;
  }
};

int main() {
  Solution sol;
  sol.oddEvenList(NULL);

  ListNode head(1);
  head.next = new ListNode(2);
  sol.oddEvenList(&head);
  return 0;
}
