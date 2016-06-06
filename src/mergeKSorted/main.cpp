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

struct compare { 
  bool operator()(const ListNode* e1, const ListNode* e2) {  
    return e1->val > e2->val;  
  }  
};  

class Solution {
public:
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    priority_queue<ListNode*, vector<ListNode*>, compare> q;
    for (auto list: lists) {
      if (list != nullptr) {
        q.push(list);
      }
    }
    ListNode* ret = new ListNode(0);
    ListNode* curr = ret;
    while (!q.empty()) {
      ListNode* front = q.top();
      q.pop();
      curr->next = front;
      curr = curr->next;
      if (front->next != nullptr) {
        q.push(front->next);
      }
    }
    return ret->next;
  }

  void printList(ListNode* e) {
    while (e != nullptr) {
      cout << e->val << endl;
      e = e->next;
    }
  }
};

int main() {
  Solution s;
  ListNode* l1 = new ListNode(1);
  l1->next = new ListNode(3);
  l1->next->next = new ListNode(3);
  ListNode* l2 = new ListNode(2);
  vector<ListNode*> lists = {};
  lists.push_back(l1);
  lists.push_back(l2);
  ListNode* res = s.mergeKLists(lists);
  s.printList(res);
  return 0;
}
