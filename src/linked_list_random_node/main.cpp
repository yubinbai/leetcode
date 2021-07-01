#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
private:
  ListNode* head;
public:
  /** @param head The linked list's head.
      Note that the head is guaranteed to be not null, so it contains at least one node. */
  Solution(ListNode* head) {
    this->head = head;
  }
    
  /** Returns a random node's value. */
  int getRandom() {
    int pick = head->val;
    int size = 1;
    ListNode* curr = head->next;

    while (curr != nullptr) {
      size++;
      double probability = 1.0 / size;
      double r = 1.0 * std::rand() / RAND_MAX;
      if (r < probability) {
        pick = curr->val;
      }
      curr = curr->next;
    }
    return pick; 
  }
};

int main() {
  ListNode* head = new ListNode(1);
  head->next = new ListNode(2);
  head->next->next = new ListNode(3);
  Solution sol(head);
  for (int i = 0; i < 100; i++) {
    cout << sol.getRandom() << endl;
  }

  return 0;
}
