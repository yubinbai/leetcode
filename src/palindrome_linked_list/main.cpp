#include <iostream>

using namespace std;
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
  bool isPalindrome(ListNode* head) {
    int len = getLen(head);
    if (len == 0 || len == 1) {
      return true;
    }

    ListNode* curr = head;
    ListNode* hook = head;
    for (int i = 0; i < len / 2 - 1; i++) {
      hook = hook->next;
    }
    
    // break list in 2
    ListNode* head2 = hook->next;
    hook->next = nullptr;
    head2 = reverseList(head2);
    ListNode* curr2 = head2;
    curr = head;

    bool ret = true;
    while (curr != nullptr) {
      if (curr->val != curr2->val) {
	ret = false;
	break;
      } else {
	curr = curr->next;
	curr2 = curr2->next;
      }
    }
    
    // recombine list
    head2 = reverseList(head2);
    hook->next = head2;

    return ret;
  }
  int getLen(ListNode* head) {
    ListNode* curr = head;
    int len = 0;
    while (curr != nullptr) {
      curr = curr->next;
      len++;
    }
    return len;
  }

  ListNode* reverseList(ListNode* head) {
    if (head == nullptr) return nullptr;
    ListNode *newList = head, *curr = head->next;
    newList->next = nullptr;
    while (curr != nullptr) {
      ListNode* swap = curr;
      curr = curr->next;
      swap->next = newList;
      newList = swap;
    }
    return newList;
  }
};
int main() {
  ListNode *list = new ListNode(2);
  list->next = new ListNode(2);
  Solution sol;
  cout << sol.isPalindrome(list) << endl;
  delete list->next;
  delete list;
  return 0;
}
